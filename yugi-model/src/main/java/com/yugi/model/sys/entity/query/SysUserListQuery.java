package com.yugi.model.sys.entity.query;

import lombok.Data;

/**
 * 系统用户列表查询条件
 *
 * @author clnzbqll
 * @since 2024-03-17 03:02:09
 */
@Data
public class SysUserListQuery {
    /**
     * 账号
     */
    private String account;
}
