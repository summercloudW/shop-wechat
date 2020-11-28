package com.wy.shop.request;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : WangYB
 * @time: 2020/11/13  15:39
 */
@Data
public class AddressInfoReq {

    private Integer addressId;
    private String postscript;
    private BigDecimal freightPrice;
    private String actualPrice;
    private BigDecimal offlinePay;

}
