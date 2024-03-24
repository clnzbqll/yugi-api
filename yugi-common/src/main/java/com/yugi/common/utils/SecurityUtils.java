package com.yugi.common.utils;


import com.yugi.common.entity.security.SecurityUser;
import com.yugi.common.exception.YugiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;


/**
 * 安全服务工具类
 *
 * @author clnzbqll
 * @since 2024-03-09 08:30:33
 */
@Slf4j
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
                .map(securityUser -> securityUser.getId())
                .orElse(null);
    }


    /**
     * 获取系统用户名
     *
     * @return 系统用户id
     */
    public static String getUsername() {
        return Optional.ofNullable(getSecurityUser())
                .map(securityUser -> securityUser.getUsername())
                .orElse(null);
    }

    /**
     * 判断是否为管理员
     *
     * @return （1是0否）
     */
    public static boolean isAdmin() {
        return Optional.ofNullable(getSecurityUser())
                .map(securityUser -> securityUser.getId())
                .filter(id -> id.equals(1L))
                .isPresent();
    }
}
