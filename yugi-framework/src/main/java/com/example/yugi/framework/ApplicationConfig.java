package com.example.yugi.framework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 程序配置
 * （执行顺序：@Configuration -> @SpringBootApplication）
 *
 * @author jia
 * @since 2023-06-26 09:20:47
 */
@Configuration
@MapperScan({"com.example.yugi.model.**.mapper"})//配置获取Mapper类的包路径
public class ApplicationConfig {

}
