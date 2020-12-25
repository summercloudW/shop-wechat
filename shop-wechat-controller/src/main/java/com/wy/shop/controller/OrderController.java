package com.wy.shop.controller;

import com.alibaba.fastjson.JSON;
import com.wy.shop.entity.JwtUser;
import com.wy.shop.entity.Order;
import com.wy.shop.mq.RabbitOrderSender;
import com.wy.shop.request.AddressInfoReq;
import com.wy.shop.result.Result;
import com.wy.shop.service.OrderService;
import com.wy.shop.utils.JwtUtil;
import com.wy.shop.vo.OrderCountVo;
import com.wy.shop.vo.PayInfoVo;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private RabbitOrderSender rabbitOrderSender;

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
            JwtUser user = JSON.parseObject(userStr, JwtUser.class);
            int id = user.getId();
            log.info("**************************" + id);
            orderCount = orderService.getOrderCount(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(orderCount);
    }

    @PostMapping("/submit")
    @ResponseBody
    public Result<PayInfoVo> submit(@RequestHeader("X-Nideshop-Token") String token, @RequestBody AddressInfoReq addressInfoReq) {
        Order order = null;
        PayInfoVo payInfoVo = null;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            String userStr = claims.getSubject();
            log.info(">>>>>>>>>>>>>>>>>>>>>>" + userStr);
            JwtUser user = JSON.parseObject(userStr, JwtUser.class);
            int id = user.getId();
            order = orderService.submitOrderInfo(id, addressInfoReq);
            payInfoVo = new PayInfoVo();
            payInfoVo.setOrderInfo(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(payInfoVo);
    }

    @GetMapping("/sendOrder")
    public void sendOrder() {
        Order order = new Order();
        order.setId(233244);
        order.setPay_id("edfdfwdgdhsaaga");
        rabbitOrderSender.sendOrder(order);
    }

}
