package com.example.yugi.service.sys.impl;

import com.example.yugi.model.sys.domain.SysConfig;
import com.example.yugi.model.sys.mapper.SysConfigMapper;
import com.example.yugi.service.sys.ISysConfigService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

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
}
