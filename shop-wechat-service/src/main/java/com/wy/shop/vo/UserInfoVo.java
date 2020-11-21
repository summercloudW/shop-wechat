package com.shop.vo;

import lombok.Data;

/**
 * id,username,nickname,gender, avatar
 */
@Data
public class UserInfoVo {

    private Integer id;
    private String username;
    private String nickname;
    private Integer gender;
    private String avatar;

}
