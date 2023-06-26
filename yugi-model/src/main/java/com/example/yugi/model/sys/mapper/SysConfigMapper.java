package com.example.yugi.model.sys.mapper;

import com.example.yugi.model.sys.domain.SysConfig;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 参数配置数据库访问层
 *
 * @author jia
 * @sinnce 2023-06-25 16:31:37
 */
public interface SysConfigMapper {
    SysConfig queryById(@Param("configId") Long configId);

    List<SysConfig> list();
}

