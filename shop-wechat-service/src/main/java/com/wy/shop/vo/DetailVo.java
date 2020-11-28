package com.wy.shop.vo;

import com.wy.shop.entity.Gallery;
import com.wy.shop.entity.Goods;
import com.wy.shop.entity.Product;
import com.wy.shop.entity.SpecificationList;
import lombok.Data;

import java.util.List;

/**
 * ta: {,…}
 * info: {id: 1109004, category_id: 1008000, is_on_sale: 1, name: "简日挂钟", goods_number: 100, sell_volume: 2562,…}
 * gallery: [{id: 413, goods_id: 1109004,…}, {id: 414, goods_id: 1109004,…}, {id: 415, goods_id: 1109004,…},…]
 * specificationList: {specification_id: 1, name: "规格",…}
 * productList: [,…]
 */
@Data
public class DetailVo {

    private Goods info;
    private List<Gallery> gallery;
    private SpecificationList specificationList;
    private List<Product> productList;

}
