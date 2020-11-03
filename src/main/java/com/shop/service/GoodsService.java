package com.shop.service;

import com.shop.entity.Goods;
import com.shop.vo.DetailVo;

import java.util.List;

public interface GoodsService {

    public Integer getGoodsCount();

    public List<Goods> getGoodsByCategoryId(Integer category_id);

    public DetailVo getDetailInfo(Integer goods_id);

}
