package com.example.yugi.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 分页查询类
 *
 * @author jia
 * @since 2023-06-26 14:25:48
 */
@Getter
@Setter
public class Query{
    /**
     * 页数
     */
    private int pageNum = 1;

    /**
     * 条数
     */
    private int pageSize = 10;
}