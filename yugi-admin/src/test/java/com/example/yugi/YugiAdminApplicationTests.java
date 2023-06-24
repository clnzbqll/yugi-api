package com.example.yugi;

import com.example.yugi.sys.ILoginService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;

@SpringBootTest(classes = {YugiAdminApplication.class})//测试类需要指定启动类
class YugiAdminApplicationTests {
    @Resource
    private ILoginService loginService;

    @Test
    void contextLoads() {
        System.out.println("测试成功");
        loginService.login();
    }
}