package com.example.yugi.sys;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Resource
    private ILoginService loginService;

    @PostMapping("/login")
    public void login(){
        loginService.login();
    }
}
