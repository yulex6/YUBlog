package com.yu.yublog.service;

import com.yu.yublog.dao.UserDao;
import com.yu.yublog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: zl-yu
 * @Date: 2022/9/17 16:59
 * @Description: TODO
 */
@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public String checkUser(User user){
        User res = userDao.queryUser(user.getUsername(), user.getPassword());
        if (res == null){
            return "";
        }
        return res.getId();
    }
}
