package com.example.yugi.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.yugi.common.entity.base.Query;
import com.example.yugi.common.entity.base.Table;
import com.example.yugi.model.sys.entity.domain.SysDictType;
import com.example.yugi.model.sys.entity.dto.SysDictTypeDto;

/**
 * 字典类型服务接口
 *
 * @author jia
 * @since 2023-06-27 09:30:53
 */
public interface ISysDictTypeService extends IService<SysDictType> {
    Table<SysDictType> page(Query query);

    void update(SysDictTypeDto dictTypeDto);

    void save(SysDictTypeDto dictTypeDto);
}
