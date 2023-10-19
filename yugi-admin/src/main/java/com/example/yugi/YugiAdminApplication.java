package com.example.yugi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Yugi启动程序
 *
 * @author jia
 * @since 2023-06-25 17:02:57
 */
@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class YugiAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(YugiAdminApplication.class, args);
        log.info("阿姨，一份儿童套餐！");
    }
}
