package com.wy.shop.mapper;

import com.wy.shop.entity.CatalogCategory;
import com.wy.shop.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CategoryMapper {

    public List<Category> getChannelCategory();

    public List<Category> getListCategory();

    public CatalogCategory getCatalogCategory(Integer id);

}
