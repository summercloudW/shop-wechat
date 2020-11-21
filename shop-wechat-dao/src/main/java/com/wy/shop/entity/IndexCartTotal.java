package com.wy.shop.entity;

import lombok.Data;

@Data
public class IndexCartTotal {

    private Integer goodsCount;
    private String goodsAmount;
    private Integer checkedGoodsCount;
    private String checkedGoodsAmount;
    private Integer user_id;
    private Integer numberChange;

}
