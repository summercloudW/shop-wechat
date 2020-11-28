package com.wy.shop.request;

import lombok.Data;

/**
 * addType: 0
 * goodsId: "1009024"
 * number: 7
 * productId: 251
 */
@Data
public class AddCartReq {

    private Integer addType;
    private String goodsId;
    private Integer number;
    private Integer productId;

}
