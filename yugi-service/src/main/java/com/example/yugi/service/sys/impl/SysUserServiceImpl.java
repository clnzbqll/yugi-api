package com.example.yugi.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.yugi.common.entity.security.SecurityUser;
import com.example.yugi.model.sys.mapper.SysUserMapper;
import com.example.yugi.service.sys.ISysUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 用户信息服务实现类
 *
 * @author jia
 * @since 2023-06-27 15:06:37
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SecurityUser> implements ISysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 根据账户名获取用户
     *
     * @param account 账户名
     * @return 用户
     */
    @Override
    public SecurityUser find(String account) {
        return this.lambdaQuery().eq(SecurityUser::getAccount, account)
                .one();
    }
}
