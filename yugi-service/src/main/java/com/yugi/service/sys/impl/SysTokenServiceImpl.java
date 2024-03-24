package com.yugi.service.sys.impl;


import com.yugi.common.entity.security.SecurityUser;
import com.yugi.common.utils.JwtUtils;
import com.yugi.model.sys.entity.vo.SysTokenVo;
import com.yugi.service.sys.ISysTokenService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.yugi.common.entity.security.SecurityConst.*;


/**
 * 系统令牌服务实现类
 *
 * @author clnzbqll
 * @since 2024-03-09 06:24:50
 */
@Service("sysTokenService")
public class SysTokenServiceImpl implements ISysTokenService {
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 保管用户登入信息并创建令牌
     *
     * @param securityUser 用户登入信息
     * @return token
     */
    @Override
    public SysTokenVo create(SecurityUser securityUser) {
        // 生成uuid
        String uuid = YUGI_LOGIN + UUID.randomUUID().toString();
        // 保管登入信息
        redisTemplate.opsForValue().set(uuid, securityUser, EXPIRE, TimeUnit.MINUTES);
        // 返回token
        return new SysTokenVo(JwtUtils.create(uuid));
    }

    /**
     * 解析token并获取用户信息
     *
     * @param request http请求
     * @return 用户信息
     */
    @Override
    public SecurityUser parse(HttpServletRequest request) {
        return Optional.ofNullable(JwtUtils.get(request))
                .map(token -> {
                    String uuid = JwtUtils.parse(token);
                    SecurityUser securityUser = (SecurityUser) redisTemplate.opsForValue().get(uuid);
                    return securityUser;
                }).orElse(null);
    }

    /**
     * 校验令牌有效期
     * （不足20分钟则刷新有效期）
     *
     * @param securityUser 用户登入信息
     * @param request http请求
     */
    @Override
    public void verify(SecurityUser securityUser, HttpServletRequest request) {
        Optional.ofNullable(JwtUtils.get(request))
                .map(token -> JwtUtils.parse(token))
                .filter(uuid -> redisTemplate.getExpire(uuid, TimeUnit.MINUTES) <= LIMIT)
                .ifPresent(uuid -> {
                    redisTemplate.opsForValue().set(uuid, securityUser, EXPIRE, TimeUnit.MINUTES);
                });
    }
}
