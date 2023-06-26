package com.example.yugi.service.sys;

import com.example.yugi.common.entity.Query;
import com.example.yugi.common.entity.Table;
import com.example.yugi.model.sys.domain.SysConfig;

/**
 * 参数配置服务接口
 *
 * @author jia
 * @since 2023-06-25 16:31:38
 */
public interface ISysConfigService {
     SysConfig queryById(Long id);

     Table<SysConfig> page(Query query);
}
