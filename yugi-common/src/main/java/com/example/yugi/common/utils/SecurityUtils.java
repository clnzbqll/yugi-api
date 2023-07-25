package com.example.yugi.common.utils;

import com.example.yugi.common.entity.security.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Optional;

/**
 * Security上下文工具类
 *
 * @author jia
 * @since 2023-07-13 16:26:51
 */
public class SecurityUtils {
    /**
     * 获取Security登入信息
     * (匿名获取)
     *
     * @return 登入信息
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取Security登入对象
     * (匿名获取)
     *
     * @return 登入对象
     */
    public static Object getPrincipal() {
        return getAuthentication().getPrincipal();
    }

    /**
     * 获取Security登入用户
     *
     * @return 登入对象
     */
    public static SecurityUser getSecurityUser() {
        return Optional.ofNullable(getPrincipal())
                .filter(principal -> !principal.equals("anonymousUser"))
                .map(principal -> {return (SecurityUser) principal;})
                .orElse(null);
    }

    /**
     * 获取系统用户id
     *
     * @return 系统用户id
     */
    public static Long getUserId() {
        return Optional.ofNullable(getSecurityUser())
                .map(securityUser -> securityUser.getUser().getId())
                .orElse(null);
    }
}
