package com.example.yugi.common.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Security上下文工具类
 *
 * @author jia
 * @since 2023-07-13 16:26:51
 */
public class SecurityUtils {
    /**
     * 获取Security登入对象
     * (匿名获取)
     *
     * @return 登入对象
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
