package com.yugi.framework.config.other;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Yugi程序配置
 *
 * @author clnzbqll
 * @since 2024-03-03 05:36:35
 */
@Configuration
@MapperScan("com.yugi.model.**.mapper")
public class ApplicationConfig {

}
