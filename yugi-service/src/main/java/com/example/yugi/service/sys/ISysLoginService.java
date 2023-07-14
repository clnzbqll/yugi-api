package com.example.yugi.service.sys;
import com.example.yugi.model.sys.entity.vo.SysTokenVo;

/**
 * 系统登入服务接口
 *
 * @author jia
 * @since 2023-06-29 17:51:49
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
