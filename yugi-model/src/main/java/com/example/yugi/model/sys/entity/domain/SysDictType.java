package com.example.yugi.model.sys.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.yugi.common.entity.Field;
import lombok.Data;

/**
 * 字典类型实体类
 *
 * @author jia
 * @since 2023-06-27 09:30:53
 */
@Data
@TableName("Sys_dict_type")
public class SysDictType extends Field {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典类型
     */
    private String dictType;
}

