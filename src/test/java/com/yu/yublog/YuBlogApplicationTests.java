package com.yu.yublog;

import com.yu.yublog.common.lang.Code;
import com.yu.yublog.common.lang.ResponseResult;
import com.yu.yublog.config.MyBeanFactory;
import com.yu.yublog.dao.UserDao;
import com.yu.yublog.mapper.ArticleMapper;
import com.yu.yublog.mapper.UserMapper;
import com.yu.yublog.pojo.Article;
import com.yu.yublog.pojo.User;
import com.yu.yublog.service.ArticleService;
import com.yu.yublog.service.UserService;
import com.yu.yublog.utils.MyUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;


@SpringBootTest
class YuBlogApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() throws IOException {
        UserDao userDao = MyBeanFactory.getUserDao();
        User user = userDao.queryUserById("05b96447-44d6-42ae-8de6-de3d35411cf7");
        System.out.println("user = " + user);

    }
}
