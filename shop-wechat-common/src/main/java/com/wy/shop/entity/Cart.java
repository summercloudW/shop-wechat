package com.wy.shop.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Cart {

    private Integer id;
    private Integer user_id;
    private Integer goods_id;
    private String goods_sn;
    private Integer product_id;
    private String goods_name;
    private String goods_aka;
    private BigDecimal goods_weight;
    private BigDecimal add_price;
    private BigDecimal retail_price;
    private Integer number;
    private String goods_specifition_name_value;
    private String goods_specifition_ids;
    private Integer checked;
    private String list_pic_url;
    private Integer freight_template_id;
    private Integer is_on_sale;
    private Long add_time;
    private Integer is_fast;
    private Integer is_delete;
    private BigDecimal weight_count;

}
