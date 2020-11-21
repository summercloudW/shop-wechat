package com.shop.request;

import lombok.Data;

/**
 * nickName: "草帽"
 * gender: 1
 * language: "zh_CN"
 * city: ""
 * province: ""
 * country: ""
 * avatarUrl: "
 */
@Data
public class UserReq {

    private String nickName;
    private Integer gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;

}
