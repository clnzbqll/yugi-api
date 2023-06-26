package com.example.yugi.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.yugi.common.entity.Query;
import com.example.yugi.common.entity.Table;
import com.example.yugi.model.sys.entity.domain.SysConfig;
import com.example.yugi.model.sys.entity.vo.SysConfigVo;

/**
 * 参数配置服务接口
 *
 * @author jia
 * @since 2023-06-25 16:31:38
 */
public interface ISysConfigService extends IService<SysConfig> {
     SysConfigVo queryById(Long id);

     Table<SysConfig> page(Query query);

     SysConfig get(Long id);
}
