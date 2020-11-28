package com.wy.shop.mapper;

import com.wy.shop.entity.Banner;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface BannerMapper {

    public List<Banner> getUseBanner();



}
