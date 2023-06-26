package com.example.yugi.common.entity;

import lombok.*;

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
    private static final String ERROR = "error";
    private static final Integer SUCCESS_CODE = 200;
    private static final Integer ERROR_CODE = 500;

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
     * @param data 数据
     * @return 成功消息
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(SUCCESS_CODE, SUCCESS, data);
        return result;
    }
}