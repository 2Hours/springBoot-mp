package com.shop.hzq.controller;


import com.shop.hzq.entity.User;
import com.shop.hzq.mapper.UserMapper;
import com.shop.hzq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;

    @GetMapping("/{userId}/info")
    public User userInfo(@PathVariable(name = "userId")String userId){
        return userMapper.selectById(userId);
    }

}

