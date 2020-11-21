package com.shop.mapper;

import com.shop.entity.CatalogCategory;
import com.shop.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

//    @Select("SELECT * FROM hiolabs_category WHERE is_channel=1")
    public List<Category> getChannelCategory();

//    @Select("SELECT * FROM hiolabs_category WHERE is_category=1")
    public List<Category> getListCategory();

//    @Select("SELECT id,name,img_url,p_height FROM hiolabs_category WHERE id=#{id} AND is_category=1")
    public CatalogCategory getCatalogCategory(Integer id);

}
