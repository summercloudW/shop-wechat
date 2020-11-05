package com.shop.mapper;

import com.shop.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    public User getUserByOpenId(String openid);

    public void register(@Param("user") User user);

}
