package com.wy.shop.mapper;

import com.wy.shop.entity.FreightPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/11/25  20:46
 */
@Component
@Mapper
public interface FreightMapper {

    public List<FreightPrice> getFreightPrice(@Param("provinceId") Integer provinceId,
                                              @Param("templateIdList") List<Integer> templateIdList);

}
