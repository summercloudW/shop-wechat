package com.shop.entity;

import lombok.Data;

/**
 * @author : WangYB
 * @time: 2020/11/9  16:19
 */
@Data
public class Region {

    private Integer id;
    private Integer parent_id;
    private String name;
    private Integer type;
    private Integer agency_id;
    private Integer area;
    private String area_code;
    private Integer far_area;

}
