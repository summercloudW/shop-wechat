package com.wy.shop.mapper;

import com.wy.shop.entity.CatalogGoods;
import com.wy.shop.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品的持久层
 */
@Component
@Mapper
public interface GoodsMapper {

    public Integer getGoodsCount();

    public List<Goods> getGoodsByCategoryId(Integer category_id);

    public List<CatalogGoods> getCatalogGoods(@Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize, @Param("id") Integer id);

    public Goods getSpecificationGoods(Integer id);

    public List<Goods> getGoodsListByKeyword(String keyword);

}
