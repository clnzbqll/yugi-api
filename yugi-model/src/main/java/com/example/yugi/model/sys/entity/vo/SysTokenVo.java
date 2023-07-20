package com.example.yugi.model.sys.entity.vo;

import lombok.*;

import java.io.Serializable;

/**
 * 系统token视图对象
 *
 * @author jia
 * @since 2023-07-13 14:48:33
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
