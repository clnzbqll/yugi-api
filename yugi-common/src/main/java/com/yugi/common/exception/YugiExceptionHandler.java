package com.yugi.common.exception;

import com.yugi.common.consts.HttpStatus;
import com.yugi.common.entity.base.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Yugi异常处理类
 *
 * @author clnzbqll
 * @since 2024-03-09 11:00:35
 */
@RestControllerAdvice
@Slf4j
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
        log.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }

    /**
     * 权限校验异常
     */
    @ExceptionHandler(AccessDeniedException.class)
    public Result<?> handleAccessDeniedException(AccessDeniedException e) {
        log.error(e.getMessage(), e);
        return Result.error(HttpStatus.FORBIDDEN, "没有权限，请联系管理员授权");
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(BindException.class)
    public Result<?> exceptionHandler(BindException e) {
        log.error(e.getMessage(), e);
        List<FieldError> msgList = e.getBindingResult().getFieldErrors();
        List<String> collect = msgList.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return Result.error("parameter error：" + String.join("；", collect));
    }

    /**
     * 参数绑定异常
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result<?> exceptionHandler(MissingServletRequestParameterException e) {
        log.error(e.getMessage(), e);
        return Result.error("parameter " + e.getParameterName() + " missing");
    }
}
