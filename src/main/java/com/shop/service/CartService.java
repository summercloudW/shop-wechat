package com.shop.service;

import com.shop.bo.IndexCartSearch;
import com.shop.entity.Cart;
import com.shop.request.AddCartReq;
import com.shop.vo.CartCheckoutVo;
import com.shop.vo.CartIndexVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartService {

    public Integer getGoodsCount(Integer uid);

    public CartIndexVo getIndex(IndexCartSearch indexCartSearch);

    public CartIndexVo addCart(AddCartReq addCartReq, Integer userId);

    public CartIndexVo updateCart(Integer id, Integer number, Integer userId);

    public CartIndexVo updateIsCheck(Integer ischeck, Integer productid, Integer userId);

    public CartCheckoutVo checkOut(Integer addType, Integer addressId, Integer uid);

    public void updateFastCheck(Integer userId, Integer goodsId);

}
