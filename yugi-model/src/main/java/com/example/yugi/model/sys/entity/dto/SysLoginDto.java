package com.example.yugi.model.sys.entity.dto;

import lombok.Data;

/**
 * 系统登入传输对象
 *
 * @author jia
 * @since 2023-06-29 17:54:23
 */
@Data
public class SysLoginDto {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
