package com.yugi.common.consts;

/**
 * http状态码
 *
 * @author clnzbqll
 * @since 2024-03-09 06:40:26
 */
public interface HttpStatus {
    /**
     * 请求成功
     */
    int OK = 200;

    /**
     * 重定向
     */
    int REDIRECT = 303;

    /**
     * 未授权
     */
    int UNAUTHORIZED = 401;

    /**
     * 访问受限/授权过期
     */
    int FORBIDDEN = 403;

    /**
     * 资源未找到
     */
    int NOT_FOUND = 404;

    /**
     * 操作失败
     */
    int ERROR = 500;
}
