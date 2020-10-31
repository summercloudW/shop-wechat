package com.shop.controller;

import com.shop.result.Result;
import com.shop.service.CartService;
import com.shop.vo.CartTotal;
import com.shop.vo.GoodsCountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/goodsCount")
    @ResponseBody
    public Result<GoodsCountVo> getGoodsCount() {
        CartTotal cartTotal = new CartTotal();
        cartTotal.setGoodsCount(cartService.getGoodsCount());
        GoodsCountVo goodsCountVo = new GoodsCountVo();
        goodsCountVo.setCartTotal(cartTotal);
        return Result.success(goodsCountVo);
    }

//    @GetMapping("/index")
//    @ResponseBody
//    public Result<CartIndexVo> getIndex() {
//        Cart cart = new Cart(14936, 0, 1064003, "1064003", 74, "六边形南瓜式宠物窝", "六边形南瓜式宠物窝", 1, BigDecimal.valueOf(89), BigDecimal.valueOf(89), 100, "蓝色", "51", 0, "http://yanxuan.nosdn.127.net/58ed94b63b39339e7814f1339013793c.png", 19, 1, 1603789966L, 0, 0, 100);
//        IndexCartTotal indexCartTotal = new IndexCartTotal(101, "8905.00", 0, "0.00", 0, 0);
//        CartIndexVo cartIndexVo = new CartIndexVo();
//        List<Cart> cartList = new ArrayList<Cart>();
//        cartList.add(cart);
//        cartIndexVo.setCartTotal(indexCartTotal);
//        cartIndexVo.setCartList(cartList);
//        return Result.success(cartIndexVo);
//    }

}
