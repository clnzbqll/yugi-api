package com.example.yugi.api.sys;

import com.example.yugi.common.entity.Query;
import com.example.yugi.common.entity.Result;
import com.example.yugi.common.entity.Table;
import com.example.yugi.model.sys.entity.domain.SysDictType;
import com.example.yugi.service.sys.ISysDictTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/page")
    public Result<Table<SysDictType>> page(Query query){
        return Result.success(sysDictTypeService.page(query));
    }
}

