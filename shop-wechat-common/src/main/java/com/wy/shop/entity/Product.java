package com.wy.shop.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * id: 138
 * goods_id: 1109004
 * goods_specification_ids: "65"
 * goods_sn: "1109004"
 * goods_number: 100
 * retail_price: 89
 * cost: 50
 * goods_weight: 1
 * has_change: 0
 * goods_name: "简日挂钟"
 * is_on_sale: 1
 * is_delete: 0
 *
 */
@Data
public class Product {

    private Integer id;
    private Integer goods_id;
    private String goods_specification_ids;
    private String goods_sn;
    private Integer goods_number;
    private BigDecimal retail_price;
    private BigDecimal cost;
    private BigDecimal goods_weight;
    private Integer has_change;
    private String goods_name;
    private Integer is_on_sale;
    private Integer is_delete;

}
