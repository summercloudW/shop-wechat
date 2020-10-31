package com.shop.entity;

import lombok.Data;

/**
 * "channel": [{
 *         "id": "类别id",
 *         "name": "类别名字",
 *         "keywords": "关键词",
 *         "front_desc": "描述",
 *         "parent_id": "父类ID",
 *         "sort_order": "分类顺序",
 *         "show_index": "在首页的顺序",
 *         "is_show": "是否展示",
 *         "icon_url": "图标的URL",
 *         "img_url": "图片的URL",
 *         "level": "级别",
 *         "front_name": "名字",
 *         "p_height": "高度",
 *         "is_category": "是否是分类项",
 *         "is_channel": "是否是通道项"
 *     }],
 */
@Data
public class Category {

    private Integer id;
    private String name;
    private String keywords;
    private String front_desc;
    private Integer parent_id;
    private Integer sort_order;
    private Integer show_index;
    private Integer is_show;
    private String icon_url;
    private String img_url;
    private String level;
    private String front_name;
    private Integer p_height;
    private Integer is_category;
    private Integer is_channel;

}
