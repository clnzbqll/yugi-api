package com.example.yugi.framework.config.other;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis序列化配置
 *
 * @author jia
 * @since 2023-07-17 17:43:20
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);//连接池
        redisTemplate.setKeySerializer(new StringRedisSerializer());//字符串序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());//Json序列化
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
