package com.shop.service.impl;

import com.shop.entity.CatalogCategory;
import com.shop.entity.Category;
import com.shop.mapper.CategoryMapper;
import com.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getChannel() {
        return categoryMapper.getChannelCategory();
    }

    @Override
    public CatalogCategory getCatalogCategory(Integer id) {
        return categoryMapper.getCatalogCategory(id);
    }

    @Override
    public List<Category> getIndexCatalogCategory() {
        return categoryMapper.getListCategory();
    }

}
