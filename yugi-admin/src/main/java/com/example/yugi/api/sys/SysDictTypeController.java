package com.example.yugi.api.sys;

import com.example.yugi.common.entity.base.Query;
import com.example.yugi.common.entity.base.Result;
import com.example.yugi.common.entity.base.Table;
import com.example.yugi.model.sys.entity.domain.SysDictType;
import com.example.yugi.model.sys.entity.dto.SysDictTypeDto;
import com.example.yugi.service.sys.ISysDictTypeService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * 字典类型控制层
 *
 * @author jia
 * @since 2023-06-27 09:30:51
 */
@RestController
@RequestMapping("/api/sys/dictType")
public class SysDictTypeController {
    /**
     * 服务对象
     */
    @Resource
    private ISysDictTypeService sysDictTypeService;

    // TODO 测试接口
    @GetMapping("/page")
    public Result<Table<SysDictType>> page(Query query){
        return Result.success(sysDictTypeService.page(query));
    }

    // TODO 测试接口
    @PatchMapping("/update")
    public Result<?> update (@RequestBody SysDictTypeDto dictTypeDto){
        sysDictTypeService.update(dictTypeDto);
        return Result.success();
    }

    // TODO 测试接口
    @PostMapping("/save")
    public Result<?> save (@RequestBody SysDictTypeDto dictTypeDto){
        sysDictTypeService.save(dictTypeDto);
        return Result.success();
    }
}

