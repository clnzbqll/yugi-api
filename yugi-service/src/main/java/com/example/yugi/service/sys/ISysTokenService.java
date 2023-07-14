package com.example.yugi.service.sys;

import com.example.yugi.common.entity.security.SecurityUser;
import com.example.yugi.model.sys.entity.vo.SysTokenVo;
import javax.servlet.http.HttpServletRequest;

/**
 * 系统令牌服务实现类
 *
 * @author jia
 * @since 2023-06-30 10:23:32
 */
public interface ISysTokenService {
    /**
     * 保管用户登入信息并创建令牌
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
}
