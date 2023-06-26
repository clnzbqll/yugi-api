package com.example.yugi.api.sys;

import com.example.yugi.common.entity.Query;
import com.example.yugi.common.entity.Result;
import com.example.yugi.common.entity.Table;
import com.example.yugi.model.sys.domain.SysConfig;
import com.example.yugi.service.sys.ISysConfigService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * 参数配置控制层
 *
 * @author jia
 * @since 2023-06-25 16:31:34
 */
@RestController
@RequestMapping("/api/sys/config")
public class SysConfigController {
    /**
     * 服务对象
     */
    @Resource
    private ISysConfigService sysConfigService;

    @GetMapping("/find")
    public Result<SysConfig> find (Long id){
        return Result.success(sysConfigService.queryById(id));
    }

    @GetMapping("list")
    public Result<Table<SysConfig>> page(Query query){
        return Result.success(sysConfigService.page(query));
    }
}

