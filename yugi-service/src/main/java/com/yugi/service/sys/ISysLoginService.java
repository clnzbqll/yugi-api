package com.yugi.service.sys;


import com.yugi.model.sys.entity.vo.SysTokenVo;


/**
 * 系统登入服务接口
 *
 * @author clnzbqll
 * @since 2024-03-09 06:23:48
 */
public interface ISysLoginService {
    /**
     * 登入
     *
     * @param username 用户名
     * @param password 密码
     */
    SysTokenVo login(String username, String password);
}
