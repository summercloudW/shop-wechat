package com.wy.shop.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : WangYB
 * @time: 2020/11/26  14:57
 */
@Data
public class SubmitOrderReq {

    private Integer addressId;
    private String postscript;
    private BigDecimal freightPrice;
    private String actualPrice;
    private BigDecimal offlinePay;

}
