package com.wy.shop.mapper;

import com.wy.shop.entity.Cart;
import com.wy.shop.entity.IndexCartSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CartMapper {

    public Integer getGoodsCount(Integer uid);

    public List<Cart> getCartList(@Param("indexCartSearch") IndexCartSearch indexCartSearch);

    public Integer getCartByUidAndPid(@Param("uid") Integer uid, @Param("productId") Integer productId);

    public void updateProductNumber(@Param("id") Integer id, @Param("number") Integer number);

    public void addCart(@Param("cart") Cart cart);

    public void updateCart(@Param("id") Integer id, @Param("number") Integer number);

    public void updateIsCheck(@Param("ischeck") Integer ischeck, @Param("productid") Integer productid, @Param("userId")Integer userId);

    public void updateFastCheck(@Param("userId") Integer userId, @Param("goodsId") Integer goodsId);



}
