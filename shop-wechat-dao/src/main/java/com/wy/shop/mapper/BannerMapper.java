package com.shop.mapper;

import com.shop.entity.Banner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BannerMapper {

//    @Select("SELECT * FROM hiolabs_ad WHERE is_delete=0;")
    public List<Banner> getUseBanner();



}
