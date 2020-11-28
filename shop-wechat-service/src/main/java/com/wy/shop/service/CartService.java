package com.wy.shop.service;


import com.wy.shop.entity.IndexCartSearch;
import com.wy.shop.request.AddCartReq;
import com.wy.shop.vo.CartCheckoutVo;
import com.wy.shop.vo.CartIndexVo;

public interface CartService {

    public Integer getGoodsCount(Integer uid);

    public CartIndexVo getIndex(IndexCartSearch indexCartSearch);

    public CartIndexVo addCart(AddCartReq addCartReq, Integer userId);

    public CartIndexVo updateCart(Integer id, Integer number, Integer userId);

    public CartIndexVo updateIsCheck(Integer ischeck, Integer productid, Integer userId);

    public CartCheckoutVo checkOut(Integer addType, Integer addressId, Integer uid);

    public void updateFastCheck(Integer userId, Integer goodsId);

}
