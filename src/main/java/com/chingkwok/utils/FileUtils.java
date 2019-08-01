package com.chingkwok.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

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

    public static int compress(File source, File target)  {
        try{
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(target));
            compress(zipOutputStream, source, null);
            zipOutputStream.close();
            return 1;
        }catch (IOException e){
            e.printStackTrace();
            return -1;
        }

    }

    private static void compress(ZipOutputStream zis, File source, String parentDir) throws IOException {
        if (StringUtils.isBlank(parentDir)) {
            parentDir = "";
        }
        if (source.exists() && source.isDirectory()) {
            String[] list = source.list();
            for (String childrenName : list
            ) {
                File childrenFile = new File(source.getCanonicalPath() + File.separator + childrenName);
                compress(zis, childrenFile, parentDir + File.separator + source.getName());
            }
        } else if (source.exists()) {
            byte[] buf = new byte[1024];
            zis.putNextEntry(new ZipEntry(parentDir + File.separator + source.getName()));
            FileInputStream is = new FileInputStream(source);
            int len = 0;
            while ((len = is.read(buf)) != -1) {
                zis.write(buf, 0, len);
            }
            is.close();
            zis.closeEntry();
        }
    }

}
