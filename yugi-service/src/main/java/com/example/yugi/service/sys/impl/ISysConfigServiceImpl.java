package com.example.yugi.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.yugi.common.entity.Query;
import com.example.yugi.common.entity.Table;
import com.example.yugi.model.sys.entity.domain.SysConfig;
import com.example.yugi.model.sys.entity.vo.SysConfigVo;
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
public class ISysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {
    @Resource
    private SysConfigMapper sysConfigMapper;

    @Override
    public SysConfigVo queryById(Long id){
        SysConfigVo configVo = sysConfigMapper.queryById(id);
        return configVo;
    }

    @Override
    public Table<SysConfig> page(Query query) {
        Page<Object> page = PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<SysConfig> list = sysConfigMapper.list();
        return new Table<>(page.getTotal(), list);
    }

    @Override
    public SysConfig get(Long id) {
        SysConfig config = this.getById(id);
        return config;
    }
}
