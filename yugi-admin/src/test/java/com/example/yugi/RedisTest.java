package com.example.yugi;

import com.example.yugi.common.entity.security.SecurityUser;
import com.example.yugi.common.entity.security.SysUser;
import com.example.yugi.model.sys.entity.vo.SysTokenVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Redis测试类
 *
 * @author jia
 * @since 2023-07-17 09:40:12
 */
@Slf4j
@SpringBootTest(classes = {YugiAdminApplication.class})
public class RedisTest {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 设置字符串测试
     */
    @Test
    public void setStringTest() {
        String key = UUID.randomUUID().toString();
        stringRedisTemplate.opsForValue().set(key, "1234");
        log.info("值：{}", stringRedisTemplate.opsForValue().get(key));
    }

    /**
     * 设置对象测试
     */
    @Test
    public void setObjectTest() {
        String key = UUID.randomUUID().toString();
        SysTokenVo tokenVo = new SysTokenVo("123456");
        redisTemplate.opsForValue().set(key, tokenVo);
        SysTokenVo sysTokenVo = (SysTokenVo) redisTemplate.opsForValue().get(key);//需要无参构造函数
        log.info("值：{}", sysTokenVo);//需要toString函数
    }

    /**
     * 设置SecurityUser对象测试
     */
    @Test
    public void setSecurityUserTest() {
        String key = UUID.randomUUID().toString();
        SecurityUser securityUser = new SecurityUser();
        SysUser sysUser = new SysUser();
        sysUser.setPassword("2222");
        securityUser.setUser(sysUser);
        redisTemplate.opsForValue().set(key, securityUser, 43000, TimeUnit.MINUTES);
        SecurityUser user = (SecurityUser) redisTemplate.opsForValue().get(key);
        log.info("值：{}", user);
    }
}
