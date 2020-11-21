package com.shop.service.impl;

import com.shop.entity.Banner;
import com.shop.mapper.BannerMapper;
import com.shop.service.BannerService;
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
