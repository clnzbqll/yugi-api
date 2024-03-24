package com.yugi.framework.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Securit跨域过滤器
 *
 * @author clnzbqll
 * @since 2024-03-09 06:21:46
 */
@Configuration
public class SecurityCorsFilter implements WebMvcConfigurer {
    /**
     * 拦截规则
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    }

    /**
     * 跨域配置
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // 访问源地址
        config.addAllowedOriginPattern("*");
        // 访问源请求头
        config.addAllowedHeader("*");
        // 访问源请求方法
        config.addAllowedMethod("*");
        // 有效期（1800秒）
        config.setMaxAge(1800L);
        // 拦截路径
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}