package com.example.yugi.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * 表格类
 *
 * @param <T> 列表数据
 * @author jia
 * @since 2023-06-26 14:12:16
 */
@Getter
@Setter
@AllArgsConstructor
public class Table<T> {
    /**
     * 总结果数
     */
    private Long total;

    /**
     * 查询结果集合
     */
    private List<T> list;
}
