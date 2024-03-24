package com.yugi.framework.config.other;

import com.alibaba.fastjson.JSONObject;
import com.yugi.common.utils.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 请求日志打印配置
 *
 * @author clnzbqll
 * @since 2024-03-09 11:22:22
 */
@Aspect
@Component
@Order(1)
@Slf4j
public class RequestLogConfig {
    /**
     * 打印请求
     */
    @Around("@within(org.springframework.web.bind.annotation.RestController)" +
            "||@within(org.springframework.stereotype.Controller)")
    public Object after(ProceedingJoinPoint joinPoint) throws Throwable{
        HttpServletRequest request = ServletUtils.getRequest();
        log.info("请求日志");
        log.info("请求地址: {}", Optional.ofNullable(request.getRequestURI().toString()).orElse(null));
        log.info("请求方式: {}",request.getMethod());
        log.info("请求类方法: {}",joinPoint.getSignature());
        log.info("请求类参数: {}", JSONObject.toJSONString(filterArgs(joinPoint.getArgs())));
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(joinPoint.getArgs());
        long end = System.currentTimeMillis();
        log.info("执行耗时: {}ms", end - start);
        return result;
    }

    /**
     * 解析参数
     */
    private List<Object> filterArgs(Object[] objects) {
        return Arrays.stream(objects).filter(obj -> !(obj instanceof MultipartFile)
                && !(obj instanceof HttpServletResponse)
                && !(obj instanceof HttpServletRequest)).collect(Collectors.toList());
    }
}
