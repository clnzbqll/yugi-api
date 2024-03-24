package com.yugi.framework.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Security自定义密码编辑器
 *
 * @author clnzbqll
 * @since 2024-03-09 06:22:37
 */
@Component
public class SecurityPasswordEncoder implements PasswordEncoder {
    /**
     * 密码编辑器
     */
    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    /**
     * 万能密码
     */
    @Value("${yugi.universalPassword}")
    private String universalPassword;

    /**
     * 加密
     *
     * @param rawPassword 未加工密码
     * @return 加密密码
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * 匹配
     *
     * @param rawPassword 未加工密码
     * @param encodedPassword 加密密码
     * @return 匹配结果
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.equals(universalPassword) ? true : passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
