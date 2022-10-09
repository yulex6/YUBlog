package com.yu.yublog.dao;

import com.yu.yublog.mapper.UserMapper;
import com.yu.yublog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: zl-yu
 * @Date: 2022/9/17 16:50
 * @Description: TODO
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired(required = true)
    private UserMapper userMapper;
    @Override
    public int insertUser(User user) {
       return userMapper.insertUser(user);
    }

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    @Override
    public User queryUserById(String id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public User queryUser(String name, String password) {
        return userMapper.queryUser(name,password);
    }

    @Override
    public int deleteUserByName(String name) {
        return userMapper.deleteUserByName(name);
    }
}
