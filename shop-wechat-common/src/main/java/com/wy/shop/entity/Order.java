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
    private BigDecimal offline_pay;
    private String consignee;
    private Integer country;
    private Integer province;
    private Integer city;
    private Integer district;
    private String address;
    private String print_info;
    private String mobile;
    private String postscript;
    private BigDecimal change_price;
    private BigDecimal actual_price;
    private BigDecimal order_price;
    private Long add_time;
    private BigDecimal freight_price;

    private Integer shipping_status;
    private Integer print_status;
    private Integer pay_status;
    private String admin_memo;
    private BigDecimal shipping_fee;
    private String pay_name;
    private String pay_id;
    private Long pay_time;
    private Long shipping_time;
    private Long confirm_time;
    private Long dealdone_time;
    private String express_value;
    private String remark;
    private Integer order_type;
    private Integer is_delete;

}
