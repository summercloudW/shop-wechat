package com.wy.shop.service.impl;

import com.wy.shop.entity.Banner;
import com.wy.shop.mapper.BannerMapper;
import com.wy.shop.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> getBannerList() {
        return bannerMapper.getUseBanner();
    }

}
