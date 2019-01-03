package com.shop.hzq.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shop.hzq.entity.User;
import com.shop.hzq.mapper.UserMapper;
import com.shop.hzq.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    private Logger logger = LogManager.getLogger(UserController.class);

    @GetMapping("/{userId}/info")
    public User userInfo(@PathVariable(name = "userId")String userId){
        return userMapper.selectById(userId);
    }

    @GetMapping("/login")
    public User userLogin(String username,String password,HttpServletRequest request){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username",username).eq("password",password));
        if (StringUtils.isEmpty(user)){
            throw new UnsupportedOperationException("用户名或者密码错误");
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            logger.info("用户登录信息："+user);
        }
        return  user;
    }

}

