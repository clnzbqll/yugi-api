package com.yugi.common.entity.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * 表格类
 *
 * @author clnzbqll
 * @since 2024-03-09 10:57:22
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
