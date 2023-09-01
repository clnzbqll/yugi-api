package com.example.yugi.framework.config.security;

import com.example.yugi.common.consts.HttpStatus;
import com.example.yugi.common.enums.Msg;
import com.example.yugi.common.utils.ServletUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        ServletUtils.error(response, HttpStatus.UNAUTHORIZED, Msg.ERR_AUTHORIZED);
    }
}