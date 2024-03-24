package com.yugi.framework.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;


/**
 * Security配置
 *
 * @author clnzbqll
 * @since 2024-03-03 05:37:48
 */
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 认证过滤器
     */
    @Autowired
    private SecurityJwtFilter authenticationTokenFilter;

    /**
     * 跨域过滤器
     */
    @Autowired
    private CorsFilter corsFilter;

    /**
     * 认证失败处理类
     */
    @Autowired
    private SecurityEntryPointHander unauthorizedHandler;


    /**
     * 设置AuthenticationManager
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 过滤器链
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // 禁用csrf
                .csrf().disable()
                // 禁用frame
                .headers().frameOptions().disable().and()
                // 禁用session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 认证失败处理类
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                // 认证过滤器
                .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                // 跨域过滤器
                .addFilterBefore(corsFilter, SecurityJwtFilter.class)
                // 过滤请求
                .authorizeRequests(auth -> auth
                        .antMatchers("/api/sys/login").anonymous()
                        .antMatchers("/**").anonymous()
                        .anyRequest().authenticated());

//                .authorizeRequests()
//                .antMatchers("/api/sys/login").anonymous()
//                .antMatchers("/**").anonymous()
//                .anyRequest().authenticated();
    }
}
