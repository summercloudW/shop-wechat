package com.wy.shop.vo;

import com.wy.shop.entity.CatalogGoods;
import lombok.Data;

import java.util.List;

@Data
public class CatalogCurrentListVo {

    private Integer count;
    private Integer totalPages;
    private Integer pageSize;
    private Integer currentPage;
    private List<CatalogGoods> data;

}
