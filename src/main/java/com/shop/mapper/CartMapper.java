package com.shop.mapper;

import com.shop.entity.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartMapper {

    public Integer getGoodsCount(Integer uid);

    public List<Cart> getCartList(Integer id);

    public Integer getCartByUidAndPid(@Param("uid") Integer uid, @Param("productId") Integer productId);

    public void updateProductNumber(@Param("id") Integer id, @Param("number") Integer number);

    public void addCart(@Param("cart") Cart cart);

}
