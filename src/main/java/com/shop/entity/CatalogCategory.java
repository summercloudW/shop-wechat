package com.shop.entity;

import lombok.Data;

/**
 * id: 1005000
 * name: "居家"
 * img_url: "http://nos.netease.com/yanxuan/f0d0e1a542e2095861b42bf789d948ce.jpg"
 * p_height: 155
 */
@Data
public class CatalogCategory {

    private Integer id;
    private String name;
    private String img_url;
    private Integer p_height;

}
