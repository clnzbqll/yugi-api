package com.example.yugi.api.sys;

import com.example.yugi.service.sys.ILoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * 系统登入控制层
 *
 * @author jia
 * @since 2023-06-24 15:47:11
 */
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
