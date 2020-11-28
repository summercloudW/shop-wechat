package com.wy.shop.vo;

import lombok.Data;

/**
 * @author : WangYB
 * @time: 2020/11/7  15:32
 */

@Data
public class AddressVo {

    private Integer id;
    private String name;
    private Integer user_id;
    private Integer country_id;
    private Integer province_id;
    private Integer city_id;
    private Integer district_id;
    private String address;
    private String mobile;
    private Integer is_default;
    private Integer is_delete;
    private String province_name;
    private String city_name;
    private String district_name;
    private String full_region;

}
