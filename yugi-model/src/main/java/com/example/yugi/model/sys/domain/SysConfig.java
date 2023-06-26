package com.example.yugi.model.sys.domain;

import lombok.Data;

/**
 * 参数配置实体类
 *
 * @author jia
 * @since 2023-06-25 16:31:37
 */
@Data
public class SysConfig {
    /**
     * 参数主键
     */
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

    private UserConfig userConfig;
}

