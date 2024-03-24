package com.yugi.service.sys;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yugi.common.entity.base.Table;
import com.yugi.common.entity.security.SecurityUser;
import com.yugi.model.sys.entity.dto.SysUserChangePwdDto;
import com.yugi.model.sys.entity.dto.SysUserSaveDto;
import com.yugi.model.sys.entity.query.SysUserListQuery;
import com.yugi.model.sys.entity.query.SysUserPageQuery;
import com.yugi.model.sys.entity.vo.SysUserListVo;
import com.yugi.model.sys.entity.vo.SysUserPageVo;

import java.util.List;

/**
 * 系统用户服务接口
 *
 * @author clnzbqll
 * @since 2024-03-03 04:59:50
 */
public interface ISysUserService extends IService<SecurityUser> {
    /**
     * 分页查询
     */
    Table<SysUserPageVo> page(SysUserPageQuery query);

    /**
     * 列表查询
     */
    List<SysUserListVo> list(SysUserListQuery query);

    /**
     * 账户查询
     */
    SecurityUser findByName(String name);

    /**
     * 新增用户
     */
    boolean save(SysUserSaveDto saveDto);

    /**
     * 编辑用户
     */
    boolean edit(SysUserSaveDto saveDto);

    /**
     * 修改密码
     */
    boolean change(SysUserChangePwdDto pwdDto);
}
