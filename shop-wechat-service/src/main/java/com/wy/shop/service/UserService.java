package com.shop.service;

import com.shop.entity.User;

public interface UserService {

    public User getUserByOpenId(String openid);

    public void register(User user);

}
