package com.example.yugi.framework.config.security;

import com.example.yugi.common.entity.security.SecurityUser;
import com.example.yugi.common.exception.YugiException;
import com.example.yugi.service.sys.ISysUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Optional;

/**
 * Security自定义用户数据源服务实现类
 *
 * @author jia
 * @since 2023-06-29 13:56:02
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
        return Optional.ofNullable(sysUserService.find(username))
                        .map(user -> new SecurityUser(user))
                .orElseThrow(YugiException::new);
    }
}
