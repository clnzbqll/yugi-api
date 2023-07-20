package com.example.yugi.common.entity.security;


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
@NoArgsConstructor
public class SecurityUser implements UserDetails {
    /**
     * 用户
     */
    private SysUser user;

    /**
     * 鉴权构造函数
     *
     * @param user 系统用户
     */
    public SecurityUser(SysUser user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return getUser().getPassword();
    }

    @Override
    public String getUsername() {
        return getUser().getAccount();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
