package com.shop.hzq.service.impl;

import com.shop.hzq.entity.Account;
import com.shop.hzq.mapper.AccountMapper;
import com.shop.hzq.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账户表 服务实现类
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
