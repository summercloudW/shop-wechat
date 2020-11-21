package com.shop.mapper;

import com.shop.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface AdminMapper {

    @Select("SELECT * FROM hiolabs_admin WHERE id=14")
    public Admin getAdmin();

}
