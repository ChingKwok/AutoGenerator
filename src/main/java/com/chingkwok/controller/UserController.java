package com.chingkwok.controller;

import com.chingkwok.bean.entity.User;
import com.chingkwok.service.UserService;


import com.chingkwok.utils.Result;
import com.chingkwok.utils.eum.ResultEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by guojingye on 2019/7/17
 */
@RestController
@Api(value = "User")
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Result login(@RequestBody User user){
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            subject.login(token);
            return new Result(ResultEnum.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(ResultEnum.FAILURE,e.getMessage());
        }
    }


}
