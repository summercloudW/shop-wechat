package com.shop.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Goods {

    private Integer id;
    private Integer category_id;
    private Integer is_on_sale;
    private String name;
    private Integer goods_number;
    private Integer sell_volume;
    private String keywords;
    private String retail_price;
    private BigDecimal min_retail_price;
    private String cost_price;
    private BigDecimal min_cost_price;
    private String goods_brief;
    private String goods_desc;
    private Integer sort_order;
    private Integer is_index;
    private Integer is_new;
    private String goods_unit;
    private String https_pic_url;
    private String list_pic_url;
    private Integer freight_template_id;
    private Integer freight_type;
    private Integer is_delete;
    private Integer has_gallery;
    private Integer has_done;

}
