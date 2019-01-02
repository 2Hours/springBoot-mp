package com.shop.hzq.service.impl;

import com.shop.hzq.entity.Shop;
import com.shop.hzq.mapper.ShopMapper;
import com.shop.hzq.service.ShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商家 服务实现类
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements ShopService {

    @Override
    public void addOneShop(Shop shop) {

    }

    @Override
    public void deleteShop(String shopId) {

    }

    @Override
    public void disableShop(String shopId) {

    }

    @Override
    public void updateShop(Shop shop) {

    }
}
