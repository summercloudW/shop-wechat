package com.wy.shop.service.impl;

import com.wy.shop.entity.User;
import com.wy.shop.mapper.UserMapper;
import com.wy.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByOpenId(String openid) {
        return userMapper.getUserByOpenId(openid);
    }

    @Override
    public void register(User user) {
        userMapper.register(user);
    }

}
