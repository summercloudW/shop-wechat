package com.shop.controller;

import com.alibaba.fastjson.JSON;
import com.shop.entity.Cart;
import com.shop.entity.User;
import com.shop.request.AddCartReq;
import com.shop.result.Result;
import com.shop.service.CartService;
import com.shop.util.JwtUtil;
import com.shop.util.StringUtil;
import com.shop.util.TokenUtil;
import com.shop.vo.CartIndexVo;
import com.shop.vo.CartTotal;
import com.shop.vo.GoodsCountVo;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/goodsCount")
    @ResponseBody
    public Result<GoodsCountVo> getGoodsCount(@RequestHeader("X-Nideshop-Token") String token) {
        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String userStr = claims.getSubject();
        User user = JSON.parseObject(userStr, User.class);
        int id = user.getId();
        CartTotal cartTotal = new CartTotal();
        cartTotal.setGoodsCount(cartService.getGoodsCount(id));
        GoodsCountVo goodsCountVo = new GoodsCountVo();
        goodsCountVo.setCartTotal(cartTotal);
        return Result.success(goodsCountVo);
    }

    @GetMapping("/index")
    @ResponseBody
    public Result<CartIndexVo> getIndex(@RequestHeader("X-Nideshop-Token") String token) {
        CartIndexVo cartIndexVo = new CartIndexVo();
        if (StringUtil.isEmpty(token)) {
            return Result.success(cartIndexVo);
        }
        try {
            Claims claims = JwtUtil.parseJWT(token);
            String userStr = claims.getSubject();
            User user = JSON.parseObject(userStr, User.class);
            int id = user.getId();
            cartIndexVo = cartService.getIndex(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(cartIndexVo);
    }

    @PostMapping("/add")
    @ResponseBody
    public Result<CartIndexVo> addCart(@RequestHeader("X-Nideshop-Token") String token, @RequestBody AddCartReq addCartReq) {
        CartIndexVo cartIndexVo = new CartIndexVo();
        if (StringUtil.isEmpty(token)) {
            return Result.success(cartIndexVo);
        }
        try {
            Claims claims = JwtUtil.parseJWT(token);
            String userStr = claims.getSubject();
            User user = JSON.parseObject(userStr, User.class);
            int id = user.getId();
            cartIndexVo = cartService.addCart(addCartReq, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(cartIndexVo);
    }

}
