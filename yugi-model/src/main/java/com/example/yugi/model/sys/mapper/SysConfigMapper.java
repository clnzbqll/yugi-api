package com.example.yugi.model.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.yugi.model.sys.entity.domain.SysConfig;
import com.example.yugi.model.sys.entity.vo.SysConfigVo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 参数配置数据库访问层
 *
 * @author jia
 * @sinnce 2023-06-25 16:31:37
 */
public interface SysConfigMapper extends BaseMapper<SysConfig>{
    SysConfigVo queryById(@Param("configId") Long configId);

    List<SysConfig> list();
}

