package com.wy.shop.mapper;

import com.wy.shop.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {

    @Select("SELECT * FROM hiolabs_admin WHERE id=14")
    public Admin getAdmin();

}
