package com.wy.shop.mapper;

import com.wy.shop.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AdminMapper {

    @Select("SELECT * FROM hiolabs_admin WHERE id=14")
    public Admin getAdmin();

    @Update("UPDATE hiolabs_admin SET username=#{username} WHERE id = 14")
    public void updateUsername(String username);

}
