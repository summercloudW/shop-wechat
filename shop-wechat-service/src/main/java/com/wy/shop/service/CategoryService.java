package com.wy.shop.service;


import com.wy.shop.entity.CatalogCategory;
import com.wy.shop.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getChannel();

    public CatalogCategory getCatalogCategory(Integer id);

    public List<Category> getIndexCatalogCategory();

}
