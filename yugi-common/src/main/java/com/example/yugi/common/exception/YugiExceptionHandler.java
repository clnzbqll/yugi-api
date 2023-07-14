package com.example.yugi.common.exception;

import com.example.yugi.common.entity.base.Result;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Yugi异常处理类
 *
 * @author jia
 * @since 2023-07-14 10:43:52
 */
@RestControllerAdvice
public class YugiExceptionHandler {
    /**
     * Yugi业务异常
     */
    @ExceptionHandler(YugiException.class)
    public Result<?> handle(YugiException e) {
        return Result.error(e.getMessage());
    }

    /**
     * 请求方式异常
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<?> handle(HttpRequestMethodNotSupportedException e) {
        return Result.error(e.getMessage());
    }
}
