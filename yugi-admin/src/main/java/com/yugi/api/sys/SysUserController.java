package com.yugi.api.sys;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.yugi.common.entity.base.Result;
import com.yugi.common.entity.base.Table;
import com.yugi.model.sys.entity.dto.SysUserChangePwdDto;
import com.yugi.model.sys.entity.dto.SysUserSaveDto;
import com.yugi.model.sys.entity.query.SysUserListQuery;
import com.yugi.model.sys.entity.query.SysUserPageQuery;
import com.yugi.model.sys.entity.vo.SysUserListVo;
import com.yugi.model.sys.entity.vo.SysUserPageVo;
import com.yugi.service.sys.ISysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统用户控制层
 *
 * @author clnzbqll
 * @since 2024-03-09 09:52:20
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ISysUserService sysUserService;

    /**
     * 分页查询
     *
     * @param query 查询条件
     * @return 用户列表
     */
    @GetMapping("/page")
    public Result<Table<SysUserPageVo>> page(SysUserPageQuery query) {
        Table<SysUserPageVo> table = sysUserService.page(query);
        return Result.success(table);
    }

    /**
     * 列表查询
     *
     * @param query 查询条件
     * @return 用户列表
     */
    @GetMapping("/list")
    public Result<List<SysUserListVo>> list(SysUserListQuery query) {
        List<SysUserListVo> list = sysUserService.list(query);
        return Result.success(list);
    }

    /**
     * 新增用户
     *
     * @param saveDto 用户信息
     * @return 新增结果
     */
    @PostMapping
    public Result save(@RequestBody SysUserSaveDto saveDto) {
        return Result.isOk(sysUserService.save(saveDto));
    }

    /**
     * 编辑用户
     *
     * @param saveDto
     * @return 编辑结果
     */
    @PutMapping
    public Result edit(@RequestBody SysUserSaveDto saveDto){
        return Result.isOk(sysUserService.edit(saveDto));
    }

    /**
     * 修改密码
     *
     * @param pwdDto 密码信息
     * @return 修改结果
     */
    @PatchMapping("/change")
    public Result change(@RequestBody SysUserChangePwdDto pwdDto){
        return Result.isOk(sysUserService.change(pwdDto));
    }

    /**
     * 删除用户
     *
     * @param idList id列表
     * @return 删除结果
     */
    @DeleteMapping("/{idList}")
    public Result delete(@PathVariable("idList") List<Long> idList){
        return Result.isOk(sysUserService.removeByIds(idList));
    }
}

