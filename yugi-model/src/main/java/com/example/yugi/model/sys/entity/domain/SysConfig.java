package com.example.yugi.model.sys.entity.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 参数配置实体类
 *
 * @author jia
 * @since 2023-06-25 16:31:37
 */
@Data
@TableName("sys_config")
public class SysConfig {
    /**
     * 参数主键
     */
    @TableId(type = IdType.AUTO)
    private Integer configId;

    /**
     * 参数名称
     */
    private String configName;

    /**
     * 参数键名
     */
    private String configKey;

    /**
     * 参数键值
     */
    private String configValue;

    /**
     * 系统内置（Y是 N否）
     */
    private String configType;

    /**
     * 创建者
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private Integer updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    @TableLogic
    private Integer isDeleted;
}

