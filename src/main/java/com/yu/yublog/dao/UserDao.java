package com.yu.yublog.dao;

import com.yu.yublog.pojo.User;

/**
 * @Author: zl-yu
 * @Date: 2022/9/17 16:43
 * @Description: TODO
 */
public interface UserDao {
    int insertUser(User user);
    User queryUserByName(String name);
    User queryUserById(String id);
    User queryUser(String name,String password);
    int deleteUserByName(String name);
}
