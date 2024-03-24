package com.yugi.framework.config.security;

import com.yugi.common.exception.YugiException;
import com.yugi.service.sys.ISysUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Optional;


/**
 * Security用户数据源服务实现类
 *
 * @author clnzbqll
 * @since 2024-03-09 06:23:00
 */
@Service
public class SecurityUserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private ISysUserService sysUserService;

    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        return Optional.ofNullable(sysUserService.findByName(username))
                .orElseThrow(YugiException::new);
    }
}