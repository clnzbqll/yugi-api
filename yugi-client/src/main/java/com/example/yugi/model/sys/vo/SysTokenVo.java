package com.example.yugi.model.sys.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 系统token视图对象
 *
 * @author jia
 * @since 2023-10-18 17:41:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysTokenVo implements Serializable {
    /**
     * token
     */
    private String token;
}