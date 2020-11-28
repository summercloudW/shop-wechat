package com.wy.shop.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CatalogGoods {

    private Integer id;
    private String name;
    private String goods_brief;
    private BigDecimal min_retail_price;
    private String list_pic_url;
    private Integer goods_number;

}
