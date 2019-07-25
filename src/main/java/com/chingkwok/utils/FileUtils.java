package com.chingkwok.utils;

import java.io.File;
import java.io.IOException;

/**
 * Created by guojingye on 2019/7/22
 */
public class FileUtils {


    /**
     * 删除文件夹
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static boolean deleteFile(File file) throws IOException {
        if (file.isDirectory()) {
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                deleteFile(new File(file, list[i]));
            }
        }
        return file.delete();
    }

    /**
     * 创建文件夹
     *
     * @param path
     * @return
     */
    public static boolean createFile(String path) {
        try {
            File file = new File(path);
            File parentFile = new File(file.getParent());
            while (!parentFile.exists()) {
                createFile(parentFile.getCanonicalPath());
            }
            return file.mkdir();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

}
