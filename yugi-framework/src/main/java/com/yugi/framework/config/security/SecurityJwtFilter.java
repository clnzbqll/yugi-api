package com.yugi.framework.config.security;



import com.yugi.common.entity.security.SecurityUser;
import com.yugi.common.utils.SecurityUtils;
import com.yugi.service.sys.ISysTokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * SecurityJwt过滤器
 *
 * @author clnzbqll
 * @since 2024-03-09 06:18:53
 */
@Component
public class SecurityJwtFilter extends OncePerRequestFilter {
    @Resource
    private ISysTokenService sysTokenService;

    /**
     * 登入请求 -> 密钥鉴权 -> 保管登入信息 -> 返回token
     */

    /**
     * 其他请求 -> 解析token -> 获取登入信息 -> 执行业务
     */

    /**
     * 过滤请求
     *
     * @param request  http请求
     * @param response http响应
     * @param chain    过滤链
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        SecurityUser securityUser = sysTokenService.parse(request);
        if (securityUser != null && SecurityUtils.getAuthentication() == null) {
            sysTokenService.verify(securityUser, request);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(securityUser, null, null);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        chain.doFilter(request, response);
    }
}
