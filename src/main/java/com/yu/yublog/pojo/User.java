package com.yu.yublog.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @Author: zl-yu
 * @Date: 2022/9/17 11:24
 * @Description: TODO
 */
@Data
@NoArgsConstructor
public class User {
    private String id;
    private String username;
    private String password;

    public User(String username, String password) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
    }
}
