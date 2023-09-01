package com.example.yugi.common.utils;

import com.alibaba.fastjson.JSON;
import com.example.yugi.common.entity.base.Result;
import com.example.yugi.common.enums.Msg;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 客户端工具类
 *
 * @author ruoyi
 */
@Slf4j
public class ServletUtils {
    /**
     * 响应错误信息
     *
     * @param response http响应
     * @param code 错误码
     * @param msg 错误消息
     */
    public static void error(HttpServletResponse response, Integer code, Msg msg) {
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