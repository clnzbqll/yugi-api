package com.example.yugi.common.entity.base;

import com.example.yugi.common.enums.Msg;
import com.example.yugi.common.utils.MessageUtils;
import lombok.*;

import static com.example.yugi.common.consts.HttpStatus.ERROR;
import static com.example.yugi.common.consts.HttpStatus.OK;

/**
 * 返回类
 *
 * @param <T> 返回数据
 * @author jia
 * @since 2023-06-26 11:50:17
 */
@Getter
@Setter
@AllArgsConstructor
public class Result<T> {
    private static final String SUCCESS = "success";

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 描述
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static <T> Result<T> success() {
        return new Result<>(OK, SUCCESS, null);
    }

    /**
     * 返回成功消息
     *
     * @param data 数据
     * @return 成功消息
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(OK, SUCCESS, data);
        return result;
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>(ERROR, msg, null);
        return result;
    }

    /**
     * 返回警告消息
     *
     * @param msg 消息
     * @return 国际化警告消息
     */
    public static <T> Result<T> error(Msg msg) {
        Result<T> result = new Result<>(ERROR, MessageUtils.message(msg), null);
        return result;
    }

    /**
     * 返回警告消息
     *
     * @param msg 消息
     * @param msg 消息
     * @return 国际化警告消息
     */
    public static <T> Result<T> error(Integer code, Msg msg) {
        Result<T> result = new Result<>(code, MessageUtils.message(msg), null);
        return result;
    }
}