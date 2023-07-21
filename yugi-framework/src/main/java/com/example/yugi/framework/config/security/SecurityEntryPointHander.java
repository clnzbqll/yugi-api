package com.example.yugi.framework.config.security;

import com.alibaba.fastjson.JSON;
import com.example.yugi.common.entity.base.Result;
import com.example.yugi.common.enums.Msg;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Security认证异常处理类
 *
 * @author jia
 * @since 2023-07-20 16:35:06
 */
@Component
public class SecurityEntryPointHander implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            String msg =  JSON.toJSONString(Result.error(Msg.ERR_AUTHORIZED));
            response.getWriter().print(msg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}