package com.example.yugi.model.sys.entity.domain;

import com.example.yugi.common.entity.Field;

/**
 * 用户信息实体类
 *
 * @author jia
 * @since 2023-06-27 15:06:36
 */
public class SysUser extends Field {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;
}

