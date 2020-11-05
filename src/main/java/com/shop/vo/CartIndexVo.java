package com.shop.vo;

import com.shop.bo.IndexCartTotal;
import com.shop.entity.Cart;
import lombok.Data;

import java.util.List;

@Data
public class CartIndexVo {

    private List<Cart> cartList;
    private IndexCartTotal cartTotal;

}
