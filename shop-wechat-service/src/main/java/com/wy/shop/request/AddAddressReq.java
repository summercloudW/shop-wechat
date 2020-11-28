package com.wy.shop.request;

import lombok.Data;

/**
 * @author : WangYB
 * @time: 2020/11/9  16:46
 */
@Data
public class AddAddressReq {

    private String name;
    private String mobile;
    private Integer province_id;
    private Integer city_id;
    private Integer district_id;
    private String address;
    private Integer is_default;

}
