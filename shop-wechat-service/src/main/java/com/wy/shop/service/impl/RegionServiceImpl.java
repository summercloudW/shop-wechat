package com.shop.service.impl;

import com.shop.entity.Region;
import com.shop.mapper.RegionMapper;
import com.shop.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/11/9  16:30
 */
@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public List<Region> findRegionListByPid(Integer pid) {
        return regionMapper.findRegionListByPid(pid);
    }

}
