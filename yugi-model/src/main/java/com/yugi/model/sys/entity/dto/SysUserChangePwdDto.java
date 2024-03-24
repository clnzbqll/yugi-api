package com.yugi.model.sys.entity.dto;

import lombok.Data;

/**
 * 修改密码传输对象
 *
 * @author clnzbqll
 * @since 2024-03-17 03:43:06
 */
@Data
public class SysUserChangePwdDto {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 原密码
     */
    private String oldPwd;

    /**
     * 新密码
     */
    private String newPwd;

}
