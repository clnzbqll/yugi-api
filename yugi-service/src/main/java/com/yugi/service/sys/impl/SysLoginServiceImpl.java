package com.yugi.service.sys.impl;


import com.yugi.common.entity.security.SecurityUser;
import com.yugi.common.enums.Msg;
import com.yugi.common.exception.YugiException;
import com.yugi.model.sys.entity.vo.SysTokenVo;
import com.yugi.service.sys.ISysLoginService;
import com.yugi.service.sys.ISysTokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 系统登入服务实现类
 *
 * @author clnzbqll
 * @since 2024-03-09 06:24:31
 */
@Service("sysLoginService")
public class SysLoginServiceImpl implements ISysLoginService {
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private ISysTokenService sysTokenService;

    /**
     * 登入
     *
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    @Override
    public SysTokenVo login(String username, String password) {
//        try{
            // 用户鉴权
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            // 获取用户
            SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
            // 返回token
            return sysTokenService.create(securityUser);
//        }catch(Exception e){
//            throw new YugiException(Msg.ERR_LOGIN);
//        }
    }
}
