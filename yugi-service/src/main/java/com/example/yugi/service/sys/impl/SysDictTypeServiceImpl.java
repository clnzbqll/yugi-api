package com.example.yugi.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.yugi.common.entity.base.Query;
import com.example.yugi.common.entity.base.Table;
import com.example.yugi.model.sys.entity.dto.SysDictTypeDto;
import com.example.yugi.model.sys.mapper.SysDictTypeMapper;
import com.example.yugi.model.sys.entity.domain.SysDictType;
import com.example.yugi.service.sys.ISysDictTypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * 字典类型服务实现类
 *
 * @author jia
 * @since 2023-06-27 09:30:54
 */

@Service("sysDictTypeService")
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements ISysDictTypeService {
    @Resource
    private SysDictTypeMapper sysDictTypeMapper;

    @Override
    public Table<SysDictType> page(Query query) {
        Page<Object> page = PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<SysDictType> list = list();
        return new Table<SysDictType>(page.getTotal(), list);
    }

    @Override
    public void update(SysDictTypeDto dictTypeDto) {
        SysDictType dictType = new SysDictType();
        dictType.setId(dictTypeDto.getId());
        dictType.setDictType(dictTypeDto.getDictName());
        this.updateById(dictType);
    }

    @Override
    public void save(SysDictTypeDto dictTypeDto) {
        SysDictType dictType = new SysDictType();
        dictType.setDictType("怪物类型");
        this.save(dictType);
    }
}
