package com.yugi.model.sys.entity.dto;


import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * 系统登入传输对象
 *
 * @author clnzbqll
 * @since 2024-03-09 06:30:49
 */
@Data
public class SysLoginDto {
    /**
     * 用户名
     */
    @NotNull(message = "账号不能为空")
    private String username;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String password;
}
