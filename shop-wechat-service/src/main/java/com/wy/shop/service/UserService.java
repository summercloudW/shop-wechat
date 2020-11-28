package com.wy.shop.service;


import com.wy.shop.entity.User;

public interface UserService {

    public User getUserByOpenId(String openid);

    public void register(User user);

}
