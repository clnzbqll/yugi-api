package com.yugi.model.sys.entity.vo;

import lombok.Data;

/**
 * 系统用户分页查询视图对象
 *
 * @author clnzbqll
 * @since 2024-03-17 02:31:24
 */
@Data
public class SysUserPageVo {
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
     * 是否禁用（1：禁用）
     */
    private Boolean status;

    /**
     * 邮箱
     */
    private String email;
}
