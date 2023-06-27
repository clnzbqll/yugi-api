package com.example.yugi.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.yugi.model.sys.mapper.SysDictTypeMapper;
import com.example.yugi.model.sys.entity.domain.SysDictType;
import com.example.yugi.service.sys.ISysDictTypeService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

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
}
