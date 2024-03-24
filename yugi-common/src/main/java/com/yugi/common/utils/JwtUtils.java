package com.yugi.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.yugi.common.entity.security.SecurityConst.*;


/**
 * Jwt工具类
 *
 * @author clnzbqll
 * @since 2024-03-09 06:46:42
 */
public class JwtUtils {
    /**
     * 用uuid生成token
     *
     * @param uuid 用户唯一识别码
     * @return token
     */
    public static String create(String uuid){
        Map<String, Object> claims = new HashMap<>();
        claims.put(YUGI_LOGIN, uuid);
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
        return Optional.ofNullable(request.getHeader(HEADER))
//                .filter(token -> !token.equals(""))
                .map(token -> token.replace(PREFIX, ""))
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
        String uuid = (String) claims.get(YUGI_LOGIN);
        return uuid;
    }
}
