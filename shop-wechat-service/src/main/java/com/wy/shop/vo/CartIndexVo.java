package com.wy.shop.vo;

import com.wy.shop.entity.Cart;
import com.wy.shop.entity.IndexCartTotal;
import lombok.Data;

import java.util.List;

@Data
public class CartIndexVo {

    private List<Cart> cartList;
    private IndexCartTotal cartTotal;

}
