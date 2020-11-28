package com.wy.shop.controller;

import com.alibaba.fastjson.JSON;
import com.wy.shop.entity.IndexCartSearch;
import com.wy.shop.entity.JwtUser;
import com.wy.shop.entity.User;
import com.wy.shop.request.AddCartReq;
import com.wy.shop.request.CartCheckReq;
import com.wy.shop.request.CartUpdateReq;
import com.wy.shop.result.Result;
import com.wy.shop.service.CartService;
import com.wy.shop.utils.JwtUtil;
import com.wy.shop.utils.StringUtil;
import com.wy.shop.vo.CartCheckoutVo;
import com.wy.shop.vo.CartIndexVo;
import com.wy.shop.vo.CartTotal;
import com.wy.shop.vo.GoodsCountVo;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        JwtUser user = JSON.parseObject(userStr, JwtUser.class);
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
            JwtUser user = JSON.parseObject(userStr, JwtUser.class);
            int id = user.getId();
            IndexCartSearch indexCartSearch = new IndexCartSearch();
            indexCartSearch.setUid(id);
            indexCartSearch.setIsFast(0);
            cartIndexVo = cartService.getIndex(indexCartSearch);
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
        JwtUser user = JSON.parseObject(userStr, JwtUser.class);
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
        JwtUser user = JSON.parseObject(userStr, JwtUser.class);
        int uid = user.getId();
        CartIndexVo cartIndexVo = cartService.updateIsCheck(cartCheckReq.getIsChecked(), cartCheckReq.getProductIds(), uid);
        return Result.success(cartIndexVo);
    }

    @GetMapping("/checkout")
    @ResponseBody
    public Result<CartCheckoutVo> checkout(@RequestHeader("X-Nideshop-Token") String token, @RequestParam Integer addressId, @RequestParam Integer addType, @RequestParam String orderFrom, @RequestParam Integer type) {
        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String userStr = claims.getSubject();
        JwtUser user = JSON.parseObject(userStr, JwtUser.class);
        int uid = user.getId();
        CartCheckoutVo cartCheckoutVo = cartService.checkOut(addType, addressId, uid);
        return Result.success(cartCheckoutVo);
    }

}
