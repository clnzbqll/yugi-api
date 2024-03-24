package com.yugi;

import com.yugi.common.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Yugi启动类
 *
 * @author clnzbqll
 * @since 2024-03-03 05:12:37
 */
@Slf4j
@SpringBootApplication
public class YugiAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(YugiAdminApplication.class, args);
        log.info("启动成功");
    }

}
