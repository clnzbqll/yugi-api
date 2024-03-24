package com.yugi.common.entity.base;

import lombok.Getter;
import lombok.Setter;

/**
 * 分页查询类
 *
 * @author clnzbqll
 * @since 2024-03-09 10:56:26
 */
@Getter
@Setter
public class Query {
    /**
     * 页数
     */
    private int pageNum = 1;

    /**
     * 条数
     */
    private int pageSize = 10;
}