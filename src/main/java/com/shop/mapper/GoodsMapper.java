package com.shop.mapper;

import com.shop.entity.CatalogGoods;
import com.shop.entity.Goods;
import com.shop.request.CatalogPageReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商品的持久层
 */
@Mapper
public interface GoodsMapper {

//    @Select("SELECT COUNT(*) FROM hiolabs_goods WHERE is_delete=0")
    public Integer getGoodsCount();

//    @Select("SELECT * FROM hiolabs_goods WHERE category_id=#{category_id} AND is_index=1")
    public List<Goods> getGoodsByCategoryId(Integer category_id);

    //    @Select("SELECT id,name,goods_brief,min_retail_price,goods_number,list_pic_url FROM hiolabs_goods WHERE is_delete=0 LIMIT #{startPage},#{pageSize}")
    public List<CatalogGoods> getCatalogGoods(@Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize,@Param("id") Integer id);

    public Goods getSpecificationGoods(Integer id);

}
