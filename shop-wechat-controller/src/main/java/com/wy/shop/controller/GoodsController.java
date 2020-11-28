package com.wy.shop.controller;

import com.alibaba.fastjson.JSON;
import com.wy.shop.entity.User;
import com.wy.shop.result.Result;
import com.wy.shop.service.CartService;
import com.wy.shop.service.GoodsService;
import com.wy.shop.utils.JwtUtil;
import com.wy.shop.utils.StringUtil;
import com.wy.shop.vo.DetailVo;
import com.wy.shop.vo.IndexGoodsCount;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    CartService cartService;

    @GetMapping("/count")
    public Result<IndexGoodsCount> getGoodsCount() {
        IndexGoodsCount indexGoodsCount = new IndexGoodsCount();
        indexGoodsCount.setGoodsCount(goodsService.getGoodsCount());
        return Result.success(indexGoodsCount);
    }

    @GetMapping("/detail")
    @ResponseBody
    public Result<DetailVo> getDetail(@RequestParam Integer id, @RequestHeader("X-Nideshop-Token") String token) {
        if (!StringUtil.isEmpty(token)) {
            Claims claims = null;
            try {
                claims = JwtUtil.parseJWT(token);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String userStr = claims.getSubject();
            User user = JSON.parseObject(userStr, User.class);
            int uid = user.getId();
            cartService.updateFastCheck(uid, id);
        }
        DetailVo detailInfo = goodsService.getDetailInfo(id);
        return Result.success(detailInfo);
    }

}
