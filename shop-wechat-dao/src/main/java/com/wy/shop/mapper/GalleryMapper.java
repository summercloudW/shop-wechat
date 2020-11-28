package com.wy.shop.mapper;

import com.wy.shop.entity.Gallery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface GalleryMapper {

    public List<Gallery> getSpecificationGallery(Integer goods_id);

}
