package com.yugi.model.sys.entity.dto;

import lombok.Data;

/**
 * 系统用户新增传输对象
 *
 * @author clnzbqll
 * @since 2024-03-17 03:19:53
 */
@Data
public class SysUserSaveDto {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 账号
     */
    private String account;

    /**
     * 性别
     */
    private Integer sex;

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
