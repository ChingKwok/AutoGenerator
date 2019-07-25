package com.chingkwok.autogenerator;

import com.chingkwok.bean.entity.Project;
import com.chingkwok.utils.GeneratorUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by guojingye on 2019/7/24
 */
public class Main {
    private static final String CLASS_PATH = "src/main/java/com/chingkwok/targetFile";
    private static final String SEPARATOR = System.getProperty("file.separator");

    public static void main(String[] args) throws IOException {
        Project project = new Project();
        project.setPackageName("com.chingkwok");
        project.setProjectCode("autogenerator");
        project.setPort("3306");
        project.setDatasourceName("auto_generator");
        project.setUsername("root");
        project.setIpAddress("134.175.6.168");
        project.setPassword("a602b854-8218-4857-b22c-f733bcd52671");
        BigDecimal bigDecimal = new BigDecimal("123");

        String path = Main.class.getClassLoader().getResource("template").getPath();
        GeneratorUtil util = new GeneratorUtil(path, "targetFile", project);
        util.generateEntity();

    }
}
