package com.example.yugi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YugiAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(YugiAdminApplication.class, args);
        System.out.println("阿姨，一份儿童套餐！");
    }
}
