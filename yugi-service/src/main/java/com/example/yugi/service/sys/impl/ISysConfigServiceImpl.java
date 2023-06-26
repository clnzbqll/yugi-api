package com.example.yugi.service.sys.impl;

import com.example.yugi.common.entity.Query;
import com.example.yugi.common.entity.Table;
import com.example.yugi.model.sys.domain.SysConfig;
import com.example.yugi.model.sys.mapper.SysConfigMapper;
import com.example.yugi.service.sys.ISysConfigService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * 参数配置服务实现类
 *
 * @author jia
 * @since 2023-06-25 16:31:39
 */
@Service("sysConfigService")
public class ISysConfigServiceImpl implements ISysConfigService {
    @Resource
    private SysConfigMapper sysConfigMapper;

    @Override
    public SysConfig queryById(Long id){
        SysConfig config = sysConfigMapper.queryById(id);
        return config;
    }

    @Override
    public Table<SysConfig> page(Query query) {
        Page<Object> page = PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<SysConfig> list = sysConfigMapper.list();
        return new Table<>(page.getTotal(), list);
    }
}
