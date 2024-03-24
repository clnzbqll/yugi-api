package com.yugi.model.sys.entity.vo;

import lombok.Data;

/**
 * 系统用户列表视图对象
 *
 * @author clnzbqll
 * @since 2024-03-17 03:03:07
 */
@Data
public class SysUserListVo {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 账号
     */
    private String account;
}
