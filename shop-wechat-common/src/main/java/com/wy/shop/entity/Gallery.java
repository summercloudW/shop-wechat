package com.shop.entity;

import lombok.Data;

/**
 * id: 413
 * goods_id: 1109004
 * img_url: "http://yanxuan.nosdn.127.net/ed50cbf7fab10b35f676e2451e112130.jpg"
 * img_desc: ""
 * sort_order: 5
 * is_delete: 0
 *
 */

@Data
public class Gallery {

    public Integer id;
    public Integer goods_id;
    public String img_url;
    public String img_desc;
    public Integer sort_order;
    public Integer is_delete;

}
