package com.wy.shop.service;


import com.wy.shop.entity.CatalogCategory;
import com.wy.shop.entity.Category;
import com.wy.shop.request.CatalogPageReq;
import com.wy.shop.vo.CatalogCurrentListVo;

import java.util.List;

public interface CatalogService {

    public CatalogCurrentListVo getCurrentList(CatalogPageReq catalogPageReq);

    public CatalogCategory getCatalogCategory(Integer id);

    public List<Category> getIndexCatalogCategory();

}
