package com.wy.shop.utils;

import com.alibaba.fastjson.JSON;
import com.wy.shop.entity.User;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

public class JwtUtil {

    private static final String JWT_KEY = "wybymm";
    private static final Long ttlMillis = 360000000L;

    public static String createToken(String id, String subject) {
        //指定加密算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //令牌过期时间设置
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        //生成秘钥
        SecretKey secretKey = generalKey();
        //封装Jwt令牌信息
        JwtBuilder builder = Jwts.builder()
                .setId(id)                    //唯一的ID
                .setSubject(subject)          // 主题  可以是JSON数据
                .setIssuer("admin")          // 签发者
                .setIssuedAt(now)             // 签发时间
                .signWith(signatureAlgorithm, secretKey) // 签名算法以及密匙
                .setExpiration(expDate);      // 设置过期时间
        return builder.compact();

    }

    /**
     * 生成加密 secretKey
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getEncoder().encode(JwtUtil.JWT_KEY.getBytes());
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 获取id
     */
    public static Integer getId(String token) {
        Claims claims = JwtUtil.parseJWT(token);
        String userStr = claims.getSubject();
        User user = JSON.parseObject(userStr, User.class);
        int uid = user.getId();
        return uid;
    }


    /**
     * 是否已过期
     */
    public static boolean isExpiration(String token) {
        try {
            return parseJWT(token).getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            return true;
        }
    }

    /**
     * 解析令牌数据
     * @param jwt
     * @return
     * @throws
     */
    public static Claims parseJWT(String jwt)  {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }


}
