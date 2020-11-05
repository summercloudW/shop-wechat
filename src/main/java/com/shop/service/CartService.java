package com.shop.service;

import com.shop.entity.Cart;
import com.shop.request.AddCartReq;
import com.shop.vo.CartIndexVo;

import java.util.List;

public interface CartService {

    public Integer getGoodsCount(Integer uid);

    public CartIndexVo getIndex(Integer id);

    public CartIndexVo addCart(AddCartReq addCartReq, Integer userId);

}
