package com.chingkwok.autogenerator;

import com.chingkwok.utils.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by guojingye on 2019/7/25
 */
public class Demo {

    public static void main(String[] args) {
        try {
            File file = new File("D://zipTest");
            File target = new File("D://zipTest.zip");
            FileUtils.compress(file,target);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
