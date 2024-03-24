package com.yugi.service.sys;


import com.yugi.common.entity.security.SecurityUser;
import com.yugi.model.sys.entity.vo.SysTokenVo;

import javax.servlet.http.HttpServletRequest;


/**
 * 系统令牌服务接口
 *
 * @author clnzbqll
 * @since 2024-03-09 06:23:59
 */
public interface ISysTokenService {
    /**
     * 创建token并保管用户登入信息
     *
     * @param securityUser 用户登入信息
     * @return token
     */
    SysTokenVo create(SecurityUser securityUser);

    /**
     * 解析token并获取用户信息
     *
     * @param request http请求
     * @return 用户信息
     */
    SecurityUser parse(HttpServletRequest request);

    /**
     * 校验令牌有效期
     * （不足20分钟则刷新有效期）
     *
     * @param securityUser 用户登入信息
     * @param request http请求
     */
    void verify(SecurityUser securityUser, HttpServletRequest request);
}
