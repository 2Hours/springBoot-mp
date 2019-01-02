package com.shop.hzq.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropUtils {

    private static Logger logger = LogManager.getLogger(PropUtils.class
            .getName());
    private static Properties properties = new Properties();

    static {
        try {
            class ProcessUtil {

                public String getProcessId(){
                    String name = ManagementFactory.getRuntimeMXBean().getName();
                    // get pid
                    String pid = name.split("@")[0];
                    return pid;
                }
            }
            InputStream inputStream = null;
            if (System.getProperty("isDebug") != null) {
                if (System.getProperty("conf.path") != null) {
                    inputStream = new BufferedInputStream(new FileInputStream(
                            System.getProperty("conf.path")));
                } else {
                    inputStream = ProcessUtil.class
                            .getResourceAsStream("/config.properties");
                }
            } else {
                inputStream = ProcessUtil.class
                        .getResourceAsStream("/config.properties");
            }
            properties.load(inputStream);
            inputStream.close();// 关闭输入流
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("config.properties加載出錯");
        }
    }

    public static String getValue(String key) {
        if (key == null && "".equals(key)) {
            return null;
        }
        if (properties.contains(key) || "".equals(properties.get(key))) {
            return null;
        }
        return properties.get(key).toString();
    }

    public static String getValue(String key, String charset) {
        if (key == null && "".equals(key)) {
            return null;
        }
        if (properties.contains(key) || "".equals(properties.get(key))) {
            return null;
        }
        String value = properties.get(key).toString();
        String cValue = value;
        try {
            cValue = new String(value.getBytes(StandardCharsets.ISO_8859_1), charset);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cValue;
    }

    public static void main(String[] args) {
        String masterSecret = properties.get("masterSecret").toString();
        System.out.println(getValue("masterSecret"));
    }

}

