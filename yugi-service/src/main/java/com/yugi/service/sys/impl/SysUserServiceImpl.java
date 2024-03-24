package com.yugi.service.sys.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yugi.common.entity.base.Table;
import com.yugi.common.entity.security.SecurityUser;
import com.yugi.common.enums.Msg;
import com.yugi.common.exception.YugiAssert;
import com.yugi.common.utils.MapperUtils;
import com.yugi.model.sys.entity.dto.SysUserChangePwdDto;
import com.yugi.model.sys.entity.dto.SysUserSaveDto;
import com.yugi.model.sys.entity.query.SysUserListQuery;
import com.yugi.model.sys.entity.query.SysUserPageQuery;
import com.yugi.model.sys.entity.vo.SysUserListVo;
import com.yugi.model.sys.entity.vo.SysUserPageVo;
import com.yugi.model.sys.mapper.SysUserMapper;
import com.yugi.service.sys.ISysUserService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 系统用户服务实现类
 *
 * @author clnzbqll
 * @since 2024-03-03 05:05:12
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SecurityUser> implements ISysUserService{
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 分页查询
     */
    @Override
    public Table<SysUserPageVo> page(SysUserPageQuery query) {
        Page<Object> page = PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<SysUserPageVo> list = sysUserMapper.page(query);
        Table<SysUserPageVo> table = new Table<>(page.getTotal(), list);
        return table;
    }

    /**
     * 列表查询
     */
    @Override
    public List<SysUserListVo> list(SysUserListQuery query) {
        List<SysUserListVo> list = sysUserMapper.list(query);
        return list;
    }

    /**
     * 账户查询
     */
    @Override
    public SecurityUser findByName(String name) {
        return this.lambdaQuery().eq(SecurityUser::getAccount, name)
                .eq(SecurityUser::getStatus, 0)
                .one();
    }

    /**
     * 新增用户
     */
    @Override
    public boolean save(SysUserSaveDto saveDto) {
        SecurityUser user = MapperUtils.INSTANCE.map(SecurityUser.class, saveDto);
        String password = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(saveDto.getPassword());
        user.setPassword(password);
        return this.save(user);
    }

    /**
     * 编辑用户
     */
    @Override
    public boolean edit(SysUserSaveDto saveDto) {
        SecurityUser user = MapperUtils.INSTANCE.map(SecurityUser.class, saveDto);
        return this.updateById(user);
    }

    /**
     * 修改密码
     */
    @Override
    public boolean change(SysUserChangePwdDto pwdDto) {
        SecurityUser user = this.getById(pwdDto.getId());
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        boolean result = passwordEncoder.matches(pwdDto.getOldPwd(), user.getPassword());
        YugiAssert.cast(!result, Msg.ERR_PASSWORD);
        String password = passwordEncoder.encode(pwdDto.getNewPwd());
        user.setPassword(password);
        return this.updateById(user);
    }
}
