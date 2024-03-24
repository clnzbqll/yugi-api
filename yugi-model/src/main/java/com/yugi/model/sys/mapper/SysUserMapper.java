package com.yugi.model.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yugi.common.entity.security.SecurityUser;
import com.yugi.model.sys.entity.query.SysUserListQuery;
import com.yugi.model.sys.entity.query.SysUserPageQuery;
import com.yugi.model.sys.entity.vo.SysUserListVo;
import com.yugi.model.sys.entity.vo.SysUserPageVo;

import java.util.List;

/**
 * 系统用户数据库访问层
 *
 * @author clnzbqll
 * @since 2024-03-03 05:08:09
 */
public interface SysUserMapper extends BaseMapper<SecurityUser> {
    /**
     * 分页查询
     */
    List<SysUserPageVo> page(SysUserPageQuery query);

    /**
     * 列表查询
     */
    List<SysUserListVo> list(SysUserListQuery query);
}
