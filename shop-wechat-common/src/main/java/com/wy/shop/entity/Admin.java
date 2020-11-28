package com.wy.shop.entity;

import lombok.Data;

/**
 * 管理员实体类
 *
 */
@Data
public class Admin {

    private Integer id;
    private String username;
    private String password;
    private String password_salt;
    private String last_login_ip;
    private Integer last_login_time;
    private Integer is_delete;

}
