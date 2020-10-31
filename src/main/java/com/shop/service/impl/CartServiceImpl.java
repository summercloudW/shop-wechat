package com.shop.service.impl;

import com.shop.mapper.CartMapper;
import com.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public Integer getGoodsCount() {
        return cartMapper.getGoodsCount();
    }

}
