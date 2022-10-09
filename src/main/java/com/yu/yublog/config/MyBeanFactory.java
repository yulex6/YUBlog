package com.yu.yublog.config;

import com.yu.yublog.YuBlogApplication;
import com.yu.yublog.dao.UserDao;


/**
 * @Author: zl-yu
 * @Date: 2022/9/21 22:56
 * @Description: TODO
 */

public class MyBeanFactory {

    public static UserDao  getUserDao() {
        return YuBlogApplication.applicationContext.getBean(UserDao.class);
    }
}
