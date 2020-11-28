package com.wy.shop.request;

import lombok.Data;

/**
 * @author : WangYB
 * @time: 2020/11/6  10:43
 */
@Data
public class CartUpdateReq {
    private Integer productId;
    private Integer number;
    private Integer id;
}
