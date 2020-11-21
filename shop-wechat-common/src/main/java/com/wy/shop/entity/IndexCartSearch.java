package com.shop.bo;

import lombok.Data;

/**
 * @author : WangYB
 * @time: 2020/11/7  14:53
 */
@Data
public class IndexCartSearch {

    /** 用户id */
    private Integer uid;
    /** 是否是快速购买的 */
    private Integer isFast;

}
