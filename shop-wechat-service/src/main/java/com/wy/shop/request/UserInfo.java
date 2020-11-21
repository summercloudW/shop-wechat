package com.shop.request;

import com.shop.entity.User;
import lombok.Data;

/**
 * errMsg: "getUserInfo:ok"
 * rawData: "{"nickName":"草帽","gender":1,"language":"zh_CN","city":"","province":"","country":"","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epRia9g8Mlzib1bBBzx3bnBU3xXTNg00Amb5ibJGLKvLiaibzd6S0sUsEzRg2EWeLaKyPmHvbu4BdjDAWQ/132"}"
 * userInfo: {nickName: "草帽", gender: 1, language: "zh_CN", city: "", province: "", country: "",…}
 * signature: "43a59d207ca0e554123e5463aec80709faae621c"
 * encryptedData: "+gu9oao/W1wqklasmVvCe/G740OLdOZUV5/JqH5txlYJC0guj9dstn2/8+MNq75ZbuyxyvKL7+vTOwbN5rVnZg1QYN7k9CC+xp4vGugO3gMTjpPbkF4E2J5UU3qYBcS+u6lGVsN0gnXXAayOagj3OZvWILVd7afMCx4fpaH3+i93YoZfVkDHWmqzg0tVRzDtrvodmw0PJWpBqTOO6RtzcIIUyIQ8DV8zUd9QTeNRVUefLHDymBeeTXF+vYl7m2rVJFfC/PvovuxrcDEfbKv7OZglbgLllhA7LdfDzqMMTHpiKRykN/rlCkEM05oaaLZ7ZrZ1yqa3PRtOMSRq4xz5WlMBCYgh9gQp2YZwSP2URo5bclLn8keTRd5tfwOelVzUBm5v6X2SSZEe6vFZzrBpyfWhkjLEO5gI+QKxfRxN0MXoiCHy/hraJv5CboOOPg0nQxEhurKXhzFQFia/r3H/Zw=="
 * iv: "q
 */
@Data
public class UserInfo {

    private String errMsg;
    private String rawData;
    private UserReq userInfo;
    private String signature;
    private String encryptedData;
    private String iv;

}
