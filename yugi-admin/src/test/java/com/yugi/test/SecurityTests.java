package com.yugi.test;

import com.yugi.YugiAdminApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SpringSecurity测试类
 *
 * @author clnzbqll
 * @since 2024-03-09 10:49:58
 */
@Slf4j
@SpringBootTest(classes = {YugiAdminApplication.class})
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