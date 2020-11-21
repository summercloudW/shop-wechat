package com.wy.shop.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : WangYB
 * @time: 2020/11/13  15:59
 */
@Data
public class Order {

    private Integer id;
    private String order_sn;
    private Integer user_id;
    private Integer order_status;
    private Integer offline_pay;
    private Integer shipping_status;
    private Integer print_status;
    private Integer pay_status;
    private String consignee;
    private Integer country;
    private Integer province;
    private Integer city;
    private Integer district;
    private String address;
    private String print_info;
    private String mobile;
    private String postscript;
    private String admin_memo;
    private BigDecimal shipping_fee;
    private String pay_name;
    private String pay_id;



}
