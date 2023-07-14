package com.example.yugi.api.sys;

import com.example.yugi.service.sys.ISysUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * 用户信息表控制层
 *
 * @author jia
 * @since 2023-06-27 15:06:35
 */
@RestController
@RequestMapping("/api/sys/user")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private ISysUserService sysUserService;
}

