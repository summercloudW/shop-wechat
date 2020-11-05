package com.shop.controller;

import com.alibaba.fastjson.JSON;
import com.shop.entity.User;
import com.shop.result.Result;
import com.shop.service.OrderService;
import com.shop.util.JwtUtil;
import com.shop.util.TokenUtil;
import com.shop.vo.OrderCountVo;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orderCount")
    @ResponseBody
    public Result<OrderCountVo> getOrderCount(@RequestHeader("X-Nideshop-Token") String token) {
        OrderCountVo orderCount = new OrderCountVo();
        if (token == null || token.length() == 0) {
            return Result.success(orderCount);
        }
        try {
            Claims claims = JwtUtil.parseJWT(token);
            String userStr = claims.getSubject();
            log.info(">>>>>>>>>>>>>>>>>>>>>>" + userStr);
            User user = JSON.parseObject(userStr, User.class);
            int id = user.getId();
            log.info("**************************" + id);
            orderCount = orderService.getOrderCount(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(orderCount);
    }

}
