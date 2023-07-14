package com.example.yugi.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Jwt工具类
 *
 * @author jia
 * @since 2023-07-07 09:48:42
 */
public class JwtUtils {
    // TODO 先暂时归集到此，redis整合后整理常量，配置在ymal中或者类中
    /**
     * 登入令牌前缀
     */
    public static final String YUGI_LOGIN_KEY = "yugi_login_key";

    /**
     * 令牌密钥
     */
    public static final String SECRET = "yugi_clnzbqll";

    /**
     * request头部
     */
    public static final String TOKEN_HEADER = "Authorization";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * ODMS前缀
     */
    public static final String ODMS_CACHE = "tdd:odms:";

    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 用uuid生成token
     *
     * @param uuid 用户唯一识别码
     * @return token
     */
    public static String create(String uuid){
        Map<String, Object> claims = new HashMap<>();
        claims.put(YUGI_LOGIN_KEY, uuid);
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
        return token;
    }

    /**
     * 从http请求中获取token
     *
     * @param request http请求
     * @return token
     */
    public static String get(HttpServletRequest request){
        return Optional.ofNullable(request.getHeader(TOKEN_HEADER))
                .map(token -> token.replace(TOKEN_PREFIX, ""))
                .orElse(null);
    }

    /**
     * 解析token获取redis的key形式的uuid
     *
     * @param token 登入令牌
     * @return redis的key形式的uuid
     */
    public static String parse(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
        String uuid = (String) claims.get(YUGI_LOGIN_KEY);
        String key = ODMS_CACHE.concat(LOGIN_TOKEN_KEY) + uuid;
        return key;
    }
}
