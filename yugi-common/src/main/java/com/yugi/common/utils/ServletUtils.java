package com.yugi.common.utils;

import com.alibaba.fastjson.JSON;
import com.yugi.common.entity.base.Result;
import com.yugi.common.enums.Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * 客户端工具类
 *
 * @author clnzbqll
 * @since 2024-03-09 08:46:14
 */
@Slf4j
public class ServletUtils {
    /**
     * 获取servlet
     */
    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    /**
     * 获取session
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 获取request
     */
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    /**
     * 获取response
     */
    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }

    /**
     * 获取String参数
     */
    public static String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    /**
     * 设置返回消息
     *
     * @param response http响应
     * @param code 状态码
     * @param msg 消息
     */
    public static void setString(HttpServletResponse response, Integer code, Msg msg) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(JSON.toJSONString(Result.error(code, msg)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
