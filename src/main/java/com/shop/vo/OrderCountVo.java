package com.shop.vo;

import lombok.Data;

/**
 * toPay: 0
 * toDelivery: 0
 * toReceive: 0
 */
@Data
public class OrderCountVo {

    private Integer toPay;
    private Integer toDelivery;
    private Integer toReceive;

}
