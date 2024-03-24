package com.yugi.common.exception;

import com.yugi.common.enums.Msg;
import com.yugi.common.utils.MessageUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Yugi异常
 *
 * @author clnzbqll
 * @since 2024-03-09 06:47:21
 */
@Getter
@NoArgsConstructor
public final class YugiException extends RuntimeException {
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

    /**
     * 构造函数
     *
     * @param message 国际化错误信息
     */
    public YugiException(Msg message) {
        this.message = MessageUtils.message(message);
    }

}