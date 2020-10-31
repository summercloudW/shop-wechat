package com.shop.entity;

import lombok.Data;

@Data
public class Notice {

    private Integer id;
    private String content;
    private Long end_time;
    private Integer is_delete;

}
