package com.example.yugi.api.sys;

import com.example.yugi.commom.Result;
import com.example.yugi.model.sys.dto.SysLoginDto;
import com.example.yugi.model.sys.vo.SysTokenVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 系统登陆服务层
 *
 * @author jia
 * @since 2023-10-18 17:13:16
 */
@FeignClient(name = "yugi", path = "/api/sys")
public interface SysLoginClient {
    /**
     * 登入
     *
     * @param loginDto 登入信息
     * @return 登入结果
     */
    @PostMapping("/login")
    Result<SysTokenVo> login(@RequestBody SysLoginDto loginDto);
}
