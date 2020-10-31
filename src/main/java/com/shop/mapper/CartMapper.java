package com.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CartMapper {

    @Select("SELECT COUNT(*) FROM hiolabs_cart WHERE hiolabs_cart.user_id=1028 GROUP BY hiolabs_cart.goods_id")
    public Integer getGoodsCount();

}
