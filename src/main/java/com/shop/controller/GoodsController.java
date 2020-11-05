package com.shop.controller;

import com.alibaba.fastjson.JSON;
import com.shop.entity.User;
import com.shop.result.Result;
import com.shop.service.GoodsService;
import com.shop.util.JwtUtil;
import com.shop.vo.DetailVo;
import com.shop.vo.IndexGoodsCount;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/count")
    public Result<IndexGoodsCount> getGoodsCount(@RequestHeader("X-Nideshop-Token") String token) {
        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String userStr = claims.getSubject();
        User user = JSON.parseObject(userStr, User.class);
        int id = user.getId();
        IndexGoodsCount indexGoodsCount = new IndexGoodsCount();
        indexGoodsCount.setGoodsCount(goodsService.getGoodsCount());
        return Result.success(indexGoodsCount);
    }

    @GetMapping("/detail")
    @ResponseBody
    public Result<DetailVo> getDetail(@RequestParam Integer id) {
        DetailVo detailInfo = goodsService.getDetailInfo(id);
        return Result.success(detailInfo);
    }

}
