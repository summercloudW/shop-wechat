package com.wy.shop.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : WangYB
 * @time: 2020/11/26  17:28
 */
@Data
public class SubmitInfo {

    private BigDecimal goods_price;
    private BigDecimal order_price;
    private Integer province;
    private Integer city;
    private Integer district;
    private String address;
    private String consignee;
    private String mobile;
    private String productNameGroup;
    private String numberGroup;

}
