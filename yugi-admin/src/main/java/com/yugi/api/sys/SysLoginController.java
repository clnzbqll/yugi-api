package com.yugi.api.sys;


import com.yugi.common.entity.base.Result;
import com.yugi.model.sys.entity.dto.SysLoginDto;
import com.yugi.model.sys.entity.vo.SysTokenVo;
import com.yugi.service.sys.ISysLoginService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 系统登入控制层
 *
 * @author clnzbqll
 * @since 2024-03-03 09:42:34
 */
@RestController
@RequestMapping("/sys")
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
    public Result<SysTokenVo> login(@RequestBody @Validated SysLoginDto loginDto){
        SysTokenVo tokenVo = sysLoginService.login(loginDto.getUsername(), loginDto.getPassword());
        return Result.success(tokenVo);
    }
}
