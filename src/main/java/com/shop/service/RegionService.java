package com.shop.service;

import com.shop.entity.Region;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/11/9  16:29
 */
public interface RegionService {

    public List<Region> findRegionListByPid(Integer pid);

}
