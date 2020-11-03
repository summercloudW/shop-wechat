package com.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.shop.entity.User;
import com.shop.handler.LoginHandler;
import com.shop.request.AuthInfoReq;
import com.shop.result.Result;
import com.shop.service.LoginService;
import com.shop.service.UserService;
import com.shop.util.JwtUtil;
import com.shop.util.MyBase64;
import com.shop.vo.LoginVo;
import com.shop.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginHandler loginHandler;


    @Override
    public LoginVo doLogin(AuthInfoReq authInfoReq) {

        //根据code,appid,secret发送HTTP请求，获得openid和session_key
        Map<String, Object> wxUserOpenid = loginHandler.getWxUserOpenid(authInfoReq.getCode(), "wx7788af9609a710ae", "f188744dcb0e4529ba776d3e1ec09749");
        String session_key = wxUserOpenid.get("session_key").toString();
        String openid = wxUserOpenid.get("openid").toString();

        //对数据EncryptedData进行解密可以获得用户信息
        String s = MyBase64.decryptData(authInfoReq.getUserInfo().getEncryptedData(), session_key, authInfoReq.getUserInfo().getIv());

        LoginVo loginVo = new LoginVo();
        UserInfoVo userInfoVo = new UserInfoVo();

        //根据openID查询数据库看是否有对应的用户
        User user = userService.getUserByOpenId(openid);
        loginVo.setIs_new(1);
        //如果为空则注册，将用户信息保存在数据库中
        if (user == null) {
            user = new User();
            user.setCity("");
            user.setCountry("中国");
            user.setGender(authInfoReq.getUserInfo().getUserInfo().getGender());
            user.setNickName(authInfoReq.getUserInfo().getUserInfo().getNickName());
            user.setProvince("");
            user.setAvatar(authInfoReq.getUserInfo().getUserInfo().getAvatarUrl());
            user.setMobile("");
            user.setName_mobile(0);
            user.setName("微信用户" + UUID.randomUUID());
            user.setPassword(openid);
            user.setRegister_time((int) System.currentTimeMillis());
            user.setWeixin_openid(openid);
            loginVo.setIs_new(0);
            //插入数据库
            userService.register(user);
        }

        //将数据传给vo
        userInfoVo.setId(user.getId());
        userInfoVo.setAvatar(user.getAvatar());
        userInfoVo.setGender(user.getGender());
        userInfoVo.setUsername(user.getUsername());
        userInfoVo.setNickname(user.getNickName());

        //利用jwt生成token
        String token = JwtUtil.createToken(UUID.randomUUID().toString(), JSON.toJSONString(user));
        loginVo.setToken(token);

        loginVo.setUserInfo(userInfoVo);
        return loginVo;

    }


}
