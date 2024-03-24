package com.yugi.common.entity.security;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yugi.common.entity.base.Field;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


/**
 * Security登入用户
 *
 * @author clnzbqll
 * @since 2024-03-09 06:42:25
 */
@Data
//@NoArgsConstructor
@TableName("sys_user")
public class SecurityUser extends Field implements UserDetails {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 账号
     */
    private String account;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 是否禁用（1：禁用）
     */
    private Boolean status;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 获取用户密码
     * （Security内部使用）
     *
     * @return 用户密码
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * 获取用户账号
     * （Security内部使用）
     *
     * @return 用户账号
     */
    @Override
    public String getUsername() {
        return this.account;
    }

    /**
     * 略
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 略
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 略
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 略
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * 略
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
