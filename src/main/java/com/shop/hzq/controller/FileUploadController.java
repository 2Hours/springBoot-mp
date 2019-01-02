package com.shop.hzq.controller;


import com.shop.hzq.utils.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Value("${FILE_URL}")
    private String absoulteRoute;

    @PostMapping("/image/upload")
    public Map<String,Object> uploadImg(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Map<String,Object> result = FileUtils.upload(request,response,null,null,absoulteRoute);
        return result;
    }

}
