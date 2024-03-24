package com.yugi.framework.config.security;

import com.yugi.common.consts.HttpStatus;
import com.yugi.common.enums.Msg;
import com.yugi.common.utils.ServletUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Security认证异常处理类
 *
 * @author clnzbqll
 * @since 2024-03-03 05:43:11
 */
@Component
public class SecurityEntryPointHander implements AuthenticationEntryPoint{
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        ServletUtils.setString(response, HttpStatus.UNAUTHORIZED, Msg.ERR_AUTHORIZED);
    }
}
