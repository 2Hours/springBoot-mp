package com.shop.hzq.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class FileUtils {

    public final static int TO_NAME = 99;		//文件名称过长
    public final static int TO_FORMAT = 100;  	//文件格式错误
    public final static int TO_MAX = 101;     	//文件太大
    public final static int TO_NO_FILE = 102; 	//未上传文件
    public final static int TO_OK = 0;   		//成功

    /***上传映射的真实路径*/
    //private static String  FILE_URL = PropUtils.getValue("FILE_URL");
    /***文件服务器测试域名*/
    //private static String  DOMAIN_FILE = PropUtils.getValue("DOMAIN_FILE");

    /**
     *
     * @param request
     * @param response
     * @param route 文件保存路径 (默认根目录下/upload)
     * @param size	上传文件大小 (默认20M)
     * @return
     */
    public static List<Map<String, Object>> uploads(HttpServletRequest request, HttpServletResponse response, String route, String size){
        //保存路径
        String savePath = request.getSession().getServletContext().getRealPath("/")+((route==null||"".equals(route))?"/upload/":route);
        //上传时生成的临时文件保存目录
        String tempPath = request.getSession().getServletContext().getRealPath("/")+"/temp";
        File tempFile=new File(tempPath);
        if(!tempFile.isDirectory()){
            tempFile.mkdirs();
        }
        File saveFile=new File(savePath);
        if(!saveFile.isDirectory()){
            saveFile.mkdirs();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(tempFile);
        ServletFileUpload upload = new ServletFileUpload(factory);
        //设置最大长度
        int biglength = Integer.parseInt(size==null?"100":size);
        upload.setSizeMax(1024000 * biglength);
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

        try {
            request.setCharacterEncoding("UTF-8");
            String [] image = {".jpg",".jpeg",".gif",".png",".bmp"};
            List<FileItem> fileItems = upload.parseRequest(request);

            //判断文件格式是否错误
            for(FileItem item:fileItems){
                Map<String, Object> result = new HashMap<String, Object>();
                if (!item.isFormField()){
                    String  fileName = item.getName();
                    String suffix =  fileName.substring(fileName.lastIndexOf("."));
                    if(!Arrays.asList(image).contains(suffix.toLowerCase())){
                        result.put("name", fileName);
                        result.put("status", TO_FORMAT);
                        result.put("message", "上传文件格式错误");
                        resultList.add(result);
                        return resultList;
                    }
                }
            }

            //开始上传文件
            for(FileItem item:fileItems){
                Map<String, Object> result = new HashMap<String, Object>();
                //如果fileitem中封装的是普通输入项的数据
                String name = item.getFieldName();
                if (item.isFormField()) {
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    result.put(name,value);
                } else {// 如果fileitem中封装的是上传文件
                    String  fileName = item.getName();
                    if(null == fileName || "".equals(fileName)){
                        continue;
                    }
                    String suffix =  fileName.substring(fileName.lastIndexOf("."));
                    String uuID = UUID.randomUUID().toString().trim().replaceAll("-","");
                    if(Arrays.asList(image).contains(suffix.toLowerCase())){
                        String imageName= uuID.toString()+suffix;
                        item.write(new File(savePath,imageName));
                        result.put("path", ((route==null||"".equals(route))?"/upload/":route+"/")+imageName);
                        result.put("name", fileName);
                        result.put("suffix", suffix);
                        result.put("status", TO_OK);
                        //压缩图片
                        Thumbnails.of(savePath+uuID.toString()+name).scale(1f)
                                .outputQuality(0.25f).outputFormat("jpg").toFile(savePath+uuID);
                        new File(savePath,uuID.toString()+name).delete();
                    }else{
                        result.put("name", fileName);
                        result.put("status", TO_FORMAT);
                        result.put("message", "上传文件格式错误");
                    }
                }
                resultList.add(result);
                System.out.println(resultList.toString());
            }
            return resultList;
        }catch (FileUploadBase.FileSizeLimitExceededException e) {
            e.printStackTrace();
            //LoggerUtils.error(BaseMessageEnum.UNKNOW_ERROR.getRetCode(), "单个文件超出最大值！");
        } catch (FileUploadBase.SizeLimitExceededException e) {
            System.out.println(29292929);
            e.printStackTrace();
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("status", TO_MAX);
            result.put("message", "上传文件超出最大值20M");
            resultList.add(result);
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            //LoggerUtils.error(BaseMessageEnum.UNKNOW_ERROR.getRetCode(),"文件上传失败！");
        }

        return resultList;
    }


    /**
     * 单个图片上传
     * @param request
     * @param response
     * @param route 文件保存路径 (默认根目录下/upload)
     * @param size	上传文件大小 (默认4M)
     * @param absolute 文件服务器绝对路径
     * @return
     */
    @SuppressWarnings("finally")
    public static Map<String, Object> upload(HttpServletRequest request,HttpServletResponse response,String route,String size,String absolute) throws IOException {
        MultipartFile file = null;
        if(request instanceof MultipartRequest){
            MultipartRequest multipartRequest = (MultipartRequest) request;
            file = multipartRequest.getFile("file");

        }
        //保存路径
        String savePath = "";
        if(absolute != null){
            savePath = absolute+((route==null||"".equals(route))?"/upload/":route);
        }else{
            savePath = request.getSession().getServletContext().getRealPath("/")+((route==null||"".equals(route))?"/upload/":route);
        }

        File saveFile=new File(savePath);
        if(!saveFile.isDirectory()){
            saveFile.mkdirs();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //设置最大长度

        long biglength = Integer.parseInt(size==null?"400":size) * 1024 * 1024;
        upload.setSizeMax(biglength);
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            request.setCharacterEncoding("UTF-8");
            String [] image = {".jpg",".jpeg",".gif",".png",".bmp"};
            //List<FileItem > fileItems = upload.parseRequest(request);

            //获取文件名称
            String originalFilename = file.getOriginalFilename();
            System.out.println(originalFilename);
            //文件大小
            long fileSize = 0;

            if(file.getSize() == 0){
                result.put("status", TO_NO_FILE);
                result.put("message", "请上传文件");
                return result;
            }

            //FileItem item = fileItems.get(0);
            //判断文件信息(格式、大小、是否上传)
            if (!file.isEmpty()){
                if(originalFilename.length() > 128){
                    result.put("status", TO_NAME);
                    result.put("message", "文件名称过长");
                    return result;
                }
                String suffix =  originalFilename.substring(originalFilename.lastIndexOf("."));
                if(!Arrays.asList(image).contains(suffix.toLowerCase())){
                    result.put("name", originalFilename);
                    result.put("status", TO_FORMAT);
                    result.put("message", "上传文件格式错误");
                    return result;
                }else if(fileSize > biglength){
                    result.put("status", TO_MAX);
                    result.put("message", "上传文件超出最大值4M");
                    return result;
                }
            }else{
                result.put("status", TO_NO_FILE);
                result.put("message", "请上传文件");
                return result;
            }


            String  fileName = originalFilename; //文件名称
            String suffix =  fileName.substring(fileName.lastIndexOf(".")); //文件后缀
            String uuID = UUID.randomUUID().toString().trim().replaceAll("-","");
            String imageName= uuID.toString()+suffix;
            file.transferTo(new File(savePath,imageName));
            //返回信息
            result.put("path", ((route==null||"".equals(route))?"/upload/":route) + imageName);  //文件相对路径
            result.put("absolutePath",savePath+imageName);  //绝对路径
            result.put("name", fileName); 					//文件名称
            result.put("suffix", suffix);					//文件后缀
            result.put("status", TO_OK);        			//返回状态
            result.put("message", "成功");					//返回信息
            Thumbnails.of(savePath+imageName).scale(1f)
                    .outputQuality(0.25f).outputFormat("jpg").toFile(savePath+imageName);
            //new File(savePath,uuID.toString()+name).delete();
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            //LoggerUtils.error(BaseMessageEnum.UNKNOW_ERROR.getRetCode(), "单个文件超出最大值！");
        } finally{
            return result;
        }
    }

    /**
     * 下载文件
     * @param request
     * @param response
     * @param route	自定义文件  /我的文件（默认download）
     * @param url	文件路径
     * @return
     */
    public static String download(HttpServletRequest request,HttpServletResponse response,String route, String url){
        String savePath = request.getSession().getServletContext().getRealPath("/")+((route==null||"".equals(route))?"/download/":route);
        //上传时生成的临时文件保存目录
        File saveFile=new File(savePath);
        if(!saveFile.isDirectory()){
            saveFile.mkdirs();
        }
        URL urlfile = null;
        HttpURLConnection httpUrl = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        String fileName =  UUID.randomUUID().toString().replaceAll("-","");
        try{
            urlfile = new URL(url);
            httpUrl = (HttpURLConnection)urlfile.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(saveFile + "/" + fileName));
            int len = 2048;
            byte[] b = new byte[len];
            while ((len = bis.read(b)) != -1){
                bos.write(b, 0, len);
            }
            bos.flush();
            bis.close();
            httpUrl.disconnect();
            return ((route==null||"".equals(route))?"/download/":route) + fileName;
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                bis.close();
                bos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }

}
