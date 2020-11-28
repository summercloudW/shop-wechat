package com.wy.shop.entity;

import lombok.Data;

@Data
public class GoodsSpecification {

    private Integer id;
    private Integer goods_id;
    private Integer specification_id;
    private String value;
    private String pic_url;
    private Integer is_delete;
    private Integer goods_number;

}
