package com.wy.shop.vo;

import lombok.Data;

/**
 * token: sessionKey,
 *             userInfo: newUserInfo,
 *             is_new: is_new
 */
@Data
public class LoginVo {

    private String token;
    private UserInfoVo userInfo;
    private Integer is_new;

}
