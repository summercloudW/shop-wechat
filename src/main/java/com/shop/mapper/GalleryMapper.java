package com.shop.mapper;

import com.shop.entity.Gallery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GalleryMapper {

    public List<Gallery> getSpecificationGallery(Integer goods_id);

}
