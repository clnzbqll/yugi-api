package com.example.yugi.commom;

/**
 * http状态码
 *
 * @author jia
 * @since 2023-09-01 15:25:38
 */
public interface HttpStatus {
    /**
     * 请求成功
     */
    int OK = 200;

    /**
     * 未授权
     */
    int UNAUTHORIZED = 401;

    /**
     * 操作失败
     */
    int ERROR = 500;
}