package com.shop.request;

import lombok.Data;

/**
 * @author : WangYB
 * @time: 2020/11/6  14:08
 */
@Data
public class CartCheckReq {

    private Integer productIds;
    private Integer isChecked;

}
