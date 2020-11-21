package com.shop.service;

import com.shop.entity.CatalogCategory;
import com.shop.entity.Category;
import com.shop.request.CatalogPageReq;
import com.shop.vo.CatalogCurrentListVo;

import java.util.List;

public interface CatalogService {

    public CatalogCurrentListVo getCurrentList(CatalogPageReq catalogPageReq);

    public CatalogCategory getCatalogCategory(Integer id);

    public List<Category> getIndexCatalogCategory();

}
