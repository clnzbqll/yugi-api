package com.example.yugi.api.sys;

import com.example.yugi.common.entity.base.Result;
import com.example.yugi.model.sys.entity.dto.SysLoginDto;
import com.example.yugi.model.sys.entity.vo.SysTokenVo;
import com.example.yugi.service.sys.ISysLoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * 系统登入控制层
 *
 * @author jia
 * @since 2023-06-29 17:47:32
 */
@RestController
@RequestMapping("/api/sys")
public class SysLoginController {
    @Resource
    private ISysLoginService sysLoginService;

    /**
     * 登入
     *
     * @param loginDto 登入信息
     * @return 登入结果
     */
    @PostMapping("/login")
    public Result<SysTokenVo> login(@RequestBody SysLoginDto loginDto){
        SysTokenVo tokenVo = sysLoginService.login(loginDto.getUsername(), loginDto.getPassword());
        return Result.success(tokenVo);
    }
}
