package com.shop.mapper;

import com.shop.entity.Region;
import org.apache.ibatis.annotations.Mapper;
import org.hibernate.validator.constraints.EAN;

import java.util.List;

@Mapper
public interface RegionMapper {

    public String findNameById(Integer id);

    public List<Region> findRegionListByPid(Integer pid);

}
