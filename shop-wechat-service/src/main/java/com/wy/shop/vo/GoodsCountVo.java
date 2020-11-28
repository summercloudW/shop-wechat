package com.wy.shop.vo;

import lombok.Data;

@Data
public class GoodsCountVo {

    private CartTotal cartTotal;

    public CartTotal getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(CartTotal cartTotal) {
        this.cartTotal = cartTotal;
    }

}
