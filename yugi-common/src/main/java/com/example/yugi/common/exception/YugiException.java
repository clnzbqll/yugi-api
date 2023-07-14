package com.example.yugi.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Yugi异常
 *
 * @author jia
 * @since 2023-06-30 09:07:50
 */
@Getter
@NoArgsConstructor
public class YugiException extends RuntimeException{
    /**
     * 错误信息
     */
    private String message;

    /**
     * 构造函数
     *
     * @param message 错误信息
     */
    public YugiException(String message) {
        this.message = message;
    }
}
