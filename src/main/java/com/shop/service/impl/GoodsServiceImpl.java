package com.shop.service.impl;

import com.shop.entity.Goods;
import com.shop.mapper.GoodsMapper;
import com.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Integer getGoodsCount() {
        return goodsMapper.getGoodsCount();
    }

    @Override
    public List<Goods> getGoodsByCategoryId(Integer category_id) {
        return goodsMapper.getGoodsByCategoryId(category_id);
    }

}
