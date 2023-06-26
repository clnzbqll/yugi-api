package com.example.yugi.model.sys.entity.vo;

import lombok.Data;

import java.nio.file.attribute.UserPrincipal;

@Data
public class SysConfigVo {
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
