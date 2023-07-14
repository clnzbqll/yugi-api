package com.example.yugi.common.entity.security;

import com.example.yugi.common.entity.base.Field;
import lombok.Data;

/**
 * 用户信息实体类
 *
 * @author jia
 * @since 2023-06-27 15:06:36
 */
@Data
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

