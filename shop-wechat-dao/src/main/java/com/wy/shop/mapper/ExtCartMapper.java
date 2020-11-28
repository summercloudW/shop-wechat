package com.wy.shop.mapper;

import com.wy.shop.entity.SubmitInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author : WangYB
 * @time: 2020/11/26  17:21
 */
@Component
@Mapper
public interface ExtCartMapper {

    public SubmitInfo getSubmitInfo(@Param("uid") Integer uid, @Param("addressId") Integer addressId);

}
