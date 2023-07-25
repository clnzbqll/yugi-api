package com.example.yugi.common.entity.security;


import com.baomidou.mybatisplus.annotation.TableName;
import com.example.yugi.common.entity.base.Field;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

/**
 * 登入用户
 *
 * @author jia
 * @since 2023-07-06 17:01:08
 */
@Data
//@NoArgsConstructor
@TableName("sys_user")
public class SecurityUser extends Field implements UserDetails {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 账号
     */
    private String account;

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
