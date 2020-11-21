package com.shop.vo;

import com.shop.entity.Cart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/11/7  14:12
 *
 */
@Data
public class CartCheckoutVo {
    
    private Integer checkedAddress;
    private BigDecimal freightPrice;
    private List<Cart> checkedGoodsList;
    private String goodsTotalPrice;
    private String orderTotalPrice;
    private String actualPrice;
    private Integer goodsCount;
    private Integer outStock;
    private Integer numberChange;

}
