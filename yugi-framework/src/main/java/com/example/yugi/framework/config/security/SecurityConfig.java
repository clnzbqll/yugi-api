package com.example.yugi.framework.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.annotation.Resource;

/**
 * Security配置
 *
 * @author jia
 * @since 2023-06-27 17:27:14
 */
@EnableWebSecurity
public class SecurityConfig {
    @Resource
    private SecurityJwtFilter securityJwtFilter;
    @Resource
    private SecurityEntryPointHander securityEntryPointHander;

    /**
     * Security配装顺序：
     * 过滤器 → 认证管理器 → 认证提供程序 → 用户数据源 → 密码编辑器 → 过滤器链
     */

    /**
     * 自定义密码编辑器：
     * 使用@Component实现PasswordEncoder接口即可，无需注入
     */

    /**
     * 注入认证管理器
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /**
     * 权限异常与登出均由前端做了处理
     */

    /**
     * 注入过滤器链
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                // 禁用csrf
                .csrf().disable()
                // 禁用session
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 认证异常处理类
                .exceptionHandling().authenticationEntryPoint(securityEntryPointHander).and()
                // 过滤器
                .addFilterBefore(securityJwtFilter, UsernamePasswordAuthenticationFilter.class)
                // 开放请求
                .authorizeHttpRequests(auth -> auth
                        .antMatchers("/api/sys/login").permitAll()
                        .anyRequest().authenticated())
                .build();
    }
}
