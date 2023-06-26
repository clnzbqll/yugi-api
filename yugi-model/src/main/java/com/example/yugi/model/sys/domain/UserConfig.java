package com.example.yugi.model.sys.domain;

import lombok.Data;

@Data
public class UserConfig {
    /**
     * 参数键值
     */
    private String configValue;

    /**
     * 系统内置（Y是 N否）
     */
    private String configType;
}
