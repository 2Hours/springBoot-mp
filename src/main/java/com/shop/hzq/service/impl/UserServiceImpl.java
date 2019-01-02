package com.shop.hzq.service.impl;

import com.shop.hzq.entity.User;
import com.shop.hzq.mapper.UserMapper;
import com.shop.hzq.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
