package com.example.yugi.model.sys.dto;

import lombok.Data;

/**
 * 系统登入传输对象
 *
 * @author jia
 * @since 2023-10-18 17:41:42
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