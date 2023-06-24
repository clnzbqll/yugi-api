package com.example.yugi.sys.impl;

import com.example.yugi.sys.ILoginService;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {
    @Override
    public void login() {
        System.out.println("登入成功");
    }
}
