package com.yugi.common.entity.security;

/**
 * Security常量
 *
 * @author clnzbqll
 * @since 2024-03-09 06:42:14
 */
public interface SecurityConst {
    /**
     * 令牌密钥
     */
    String SECRET = "yugi_clnzbqll";

    /**
     * 令牌标识
     */
    String HEADER = "Authorization";

    /**
     * 令牌前缀
     */
    String PREFIX = "Bearer ";

    /**
     * 令牌有效时限
     * (4小时)
     */
    Long EXPIRE = 240L;

    /**
     * 令牌刷新时限
     * （20分钟）
     */
    Long LIMIT = 20L;

    /**
     * 登入码前缀
     */
    String YUGI_LOGIN = "yugi:login:";
}
