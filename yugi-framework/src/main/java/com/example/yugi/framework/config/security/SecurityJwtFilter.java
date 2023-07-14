package com.example.yugi.framework.config.security;


import com.example.yugi.common.utils.SecurityUtils;
import com.example.yugi.common.entity.security.SecurityUser;
import com.example.yugi.service.sys.ISysTokenService;
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
 * Security自定义Jwt过滤器
 *
 * @author jia
 * @since 2023-07-05 17:09:39
 */
@Component
public class SecurityJwtFilter extends OncePerRequestFilter {
    @Resource
    private ISysTokenService sysTokenService;

    /**
     * 过滤请求
     *
     * @param request  http请求
     * @param response http响应
     * @param chain    过滤链
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        SecurityUser securityUser = sysTokenService.parse(request);
        if (securityUser != null && SecurityUtils.getAuthentication() == null) {
            // TODO 整合redis后加入刷新令牌机制
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(securityUser, null, null);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        chain.doFilter(request, response);
    }
}
