package com.wy.shop.mapper;

import com.wy.shop.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    public User getUserByOpenId(String openid);

    public void register(@Param("user") User user);

}
