package com.wy.shop.service;


import com.wy.shop.entity.Goods;
import com.wy.shop.vo.DetailVo;

import java.util.List;

public interface GoodsService {

    public Integer getGoodsCount();

    public List<Goods> getGoodsByCategoryId(Integer category_id);

    public DetailVo getDetailInfo(Integer goods_id);

    public Goods getGoodsById(Integer goods_id);

}
