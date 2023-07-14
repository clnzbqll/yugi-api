package com.example.yugi.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.yugi.common.entity.security.SysUser;

/**
 * 用户信息服务接口
 *
 * @author jia
 * @since 2023-06-27 15:06:37
 */
public interface ISysUserService extends IService<SysUser> {
    /**
     * 根据账户名获取用户
     *
     * @param account 账户名
     * @return 用户
     */
    SysUser find(String account);
}
