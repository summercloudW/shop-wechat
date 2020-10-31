package com.shop.controller;

import com.shop.result.Result;
import com.shop.service.GoodsService;
import com.shop.vo.IndexGoodsCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/count")
    public Result<IndexGoodsCount> getGoodsCount() {
        IndexGoodsCount indexGoodsCount = new IndexGoodsCount();
        indexGoodsCount.setGoodsCount(goodsService.getGoodsCount());
        return Result.success(indexGoodsCount);
    }

}
