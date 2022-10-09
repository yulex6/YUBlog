package com.yu.yublog.controller;

import com.yu.yublog.common.lang.Code;
import com.yu.yublog.common.lang.ResponseResult;
import com.yu.yublog.pojo.User;
import com.yu.yublog.service.UserService;
import com.yu.yublog.utils.TokenUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Author: zl-yu
 * @Date: 2022/9/17 17:01
 * @Description: TODO
 */
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ApiOperation(value = "管理员登录")
    public ResponseResult login(@RequestBody User user){
        HashMap<String, Object> hs = new HashMap<>();
        String id = userService.checkUser(user);
        if(id.equals("")){
            return new ResponseResult(Code.LOGIN_ERROR);
        }
        String token = TokenUtils.getToken(user);
        hs.put("Authorization",token);
        hs.put("userId",id);
        return new ResponseResult(Code.LOGIN_SUCCESS,hs);
    }
}
