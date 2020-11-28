package com.wy.shop.entity;

import lombok.Data;

@Data
public class Banner {

    private Integer id;
    private Byte link_type;
    private String link;
    private Long goods_id;
    private String image_url;
    private Long end_time;
    private Byte enabled;
    private Byte sort_order;
    private Byte is_delete;


}
