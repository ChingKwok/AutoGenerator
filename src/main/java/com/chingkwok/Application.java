package com.chingkwok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by guojingye on 2019/7/17
 */
@SpringBootApplication(scanBasePackages = "com")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
