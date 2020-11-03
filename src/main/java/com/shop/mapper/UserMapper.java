package com.shop.mapper;

import com.shop.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public User getUserByOpenId(String openid);

    public void register(User user);

}
