package com.example.yugi;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SpringSecurity测试类
 *
 * @author jia
 * @since 2023-06-23 09:46:28
 */
@Slf4j
@SpringBootTest(classes = {YugiAdminApplication.class})//测试类需要指定启动类
class SecurityTests {
    /**
     * 默认编码器测试
     */
    @Test
    void defaultEncoderTest() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String cipher = passwordEncoder.encode("123456");
        boolean result = passwordEncoder.matches("123456", cipher);
        log.info("匹配结果：{}", result);
    }

    /**
     * MD5编码器测试
     */
    @Test
    void md5EncoderTest() {
        PasswordEncoder passwordEncoder = new MessageDigestPasswordEncoder("MD5");
        String cipher = passwordEncoder.encode("123456");
        boolean result = passwordEncoder.matches("123456", cipher);
        log.info("匹配结果：{}", result);
    }
}