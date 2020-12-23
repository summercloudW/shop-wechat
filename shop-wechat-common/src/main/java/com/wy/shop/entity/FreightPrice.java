package com.wy.shop.entity;

import lombok.Data;

import java.math.BigDecimal;
import lombok.ToString;

/**
 * @author : WangYB
 * @time: 2020/11/25  20:50
 */
@Data
@ToString
public class FreightPrice {

    private BigDecimal startFee;
    private Integer add;
    private BigDecimal addFee;
    private Integer freeByNumber;
    private BigDecimal freeByMoney;

}
