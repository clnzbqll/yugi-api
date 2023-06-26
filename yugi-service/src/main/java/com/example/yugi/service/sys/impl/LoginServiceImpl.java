package com.example.yugi.service.sys.impl;

import com.example.yugi.service.sys.ILoginService;
import org.springframework.stereotype.Service;

/**
 * 系统登入服务实现类
 *
 * @author jia
 * @since 2023-06-24 15:48:11
 */
@Service("loginService")
public class LoginServiceImpl implements ILoginService {
    @Override
    public void login() {
        System.out.println("登入成功");
    }
}
