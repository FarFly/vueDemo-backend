package com.fly.sell.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImgUtils {
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    private static String separator  = System.getProperty("file.separator");


    /**
     * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
     * @return
     */
    public static String getRandomFileName() {
        // 获取随机的五位数
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }

    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "img";
        } else {
            basePath = "img";
        }
        basePath = basePath.replace("/", separator);

        return basePath;
    }

    private static void makeDirPath(String targetAddr) {
        File dirPath = new File(targetAddr);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    public static String getImgPath(String fileName, String childFilePath){
        StringBuilder sb = new StringBuilder();
        String name = getRandomFileName();
        String extension = getFileExtension(fileName);
        String imgBasePath = getImgBasePath();
        String path = imgBasePath + childFilePath;
        makeDirPath(path);
        sb.append(path).append(name).append(extension);
        return sb.toString();
    }


}
