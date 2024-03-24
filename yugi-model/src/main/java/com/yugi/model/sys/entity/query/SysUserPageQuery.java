package com.yugi.model.sys.entity.query;

import com.yugi.common.entity.base.Query;
import lombok.Data;

/**
 * 用户分页查询条件
 *
 * @author clnzbqll
 * @since 2024-03-17 02:30:30
 */
@Data
public class SysUserPageQuery extends Query {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 账号
     */
    private String account;

}
