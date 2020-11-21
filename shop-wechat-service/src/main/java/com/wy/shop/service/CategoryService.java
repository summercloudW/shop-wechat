package com.shop.service;

import com.shop.entity.CatalogCategory;
import com.shop.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getChannel();

    public CatalogCategory getCatalogCategory(Integer id);

    public List<Category> getIndexCatalogCategory();

}
