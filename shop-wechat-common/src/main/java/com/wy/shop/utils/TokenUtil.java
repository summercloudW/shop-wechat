package com.wy.shop.utils;

import com.alibaba.fastjson.JSON;
import com.wy.shop.entity.User;
import io.jsonwebtoken.Claims;

public class TokenUtil {


    public static Integer getId(String token) throws Exception {
        Claims claims = JwtUtil.parseJWT(token);
        String userStr = claims.getSubject();
        User user = JSON.parseObject(userStr, User.class);
        return user.getId();
    }

}
