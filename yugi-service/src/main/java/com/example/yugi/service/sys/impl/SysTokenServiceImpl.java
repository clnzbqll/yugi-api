package com.example.yugi.service.sys.impl;

import com.example.yugi.common.entity.security.SecurityUser;
import com.example.yugi.common.entity.security.SysUser;
import com.example.yugi.common.utils.JwtUtils;
import com.example.yugi.model.sys.entity.vo.SysTokenVo;
import com.example.yugi.service.sys.ISysTokenService;
import com.example.yugi.service.sys.ISysUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;

/**
 * 系统令牌服务实现类
 *
 * @author jia
 * @since 2023-06-30 10:24:37
 */
@Service("sysTokenService")
public class SysTokenServiceImpl implements ISysTokenService {
    @Resource
    private ISysUserService sysUserService;

    // TODO 换个合适的方法名字
    /**
     * 保管用户登入信息并创建令牌
     *
     * @param securityUser 用户登入信息
     * @return token
     */
    @Override
    public SysTokenVo create(SecurityUser securityUser) {
        // TODO 此方法除redis外均已完成，全完成后删除输出语句，整理代理，添加注释
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        securityUser.setUuid(uuid);

        // TODO 使用redis以uuid为key将loginUser信息放入缓存中

        String token = JwtUtils.create(uuid);
        return new SysTokenVo(token);
    }

    // TODO 换个合适的方法名字
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

                    // TODO 从redis缓存中获取用户信息，暂时手动生成一个LoginUser对象
                    SecurityUser securityUser = new SecurityUser();
                    securityUser.setUuid(uuid.replace("tdd:odms:login_tokens:", ""));
                    System.out.println(securityUser.getUuid());
                    SysUser user = sysUserService.find("clnzbqll");
                    securityUser.setUser(user);
                    return securityUser;
                }).orElse(null);
    }
}
