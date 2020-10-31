package com.shop.entity;

import lombok.Data;

/**
 * {
 *     "id": "配置的id",
 *     "banner": "轮播图的数量",
 *     "channel": "下拉列表的数量",
 *     "index_banner_img": "首页的轮播图图片数量",
 *     "notice": "通知的数量"
 * }
 */

@Data
public class ShowSettings {

    private Integer id;
    private Integer banner;
    private Integer channel;
    private Integer index_banner_img;
    private Integer notice;

}
