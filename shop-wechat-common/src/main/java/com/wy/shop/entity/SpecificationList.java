package com.shop.bo;

import com.shop.entity.GoodsSpecification;
import lombok.Data;

import java.util.List;

/**
 * specification_id: 1
 * name: "规格"
 * valueList
 */
@Data
public class SpecificationList {

    private Integer specification_id;
    private String name;
    private List<GoodsSpecification> valueList;

}
