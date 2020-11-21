package com.wy.shop.entity;

import lombok.Data;

import java.util.List;

@Data
public class IndexCategoryGoods {

    private Integer id;
    private String name;
    private List<Goods> goodsList;
    private String banner;
    private Integer height;

}
