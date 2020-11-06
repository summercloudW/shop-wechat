package com.shop.controller;

import com.alibaba.fastjson.JSON;
import com.shop.entity.Cart;
import com.shop.entity.User;
import com.shop.request.AddCartReq;
import com.shop.request.CartCheckReq;
import com.shop.request.CartUpdateReq;
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
        GoodsCountVo goodsCountVo = new GoodsCountVo();
        CartTotal cartTotal = new CartTotal();
        if (StringUtil.isEmpty(token)) {
            cartTotal.setGoodsCount(0);
            goodsCountVo.setCartTotal(cartTotal);
            return Result.success(goodsCountVo);
        }
        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String userStr = claims.getSubject();
        User user = JSON.parseObject(userStr, User.class);
        int id = user.getId();
        cartTotal.setGoodsCount(cartService.getGoodsCount(id));
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


    @PostMapping("/update")
    @ResponseBody
    public Result<CartIndexVo> updateCart(@RequestBody CartUpdateReq cartUpdateReq, @RequestHeader("X-Nideshop-Token") String token) {
        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String userStr = claims.getSubject();
        User user = JSON.parseObject(userStr, User.class);
        int uid = user.getId();
        CartIndexVo cartIndexVo = cartService.updateCart(cartUpdateReq.getId(), cartUpdateReq.getNumber(), uid);
        return Result.success(cartIndexVo);
    }

    @PostMapping("/checked")
    @ResponseBody
    public Result<CartIndexVo> updateIsCheck(@RequestBody CartCheckReq cartCheckReq, @RequestHeader("X-Nideshop-Token") String token) {
        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String userStr = claims.getSubject();
        User user = JSON.parseObject(userStr, User.class);
        int uid = user.getId();
        CartIndexVo cartIndexVo = cartService.updateIsCheck(cartCheckReq.getIsChecked(), cartCheckReq.getProductIds(), uid);
        return Result.success(cartIndexVo);
    }

}
