package com.shop.hzq.service;

import com.shop.hzq.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商家 服务类
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
public interface ShopService extends IService<Shop> {

    void addOneShop(Shop shop);

    void deleteShop(String shopId);

    void disableShop(String shopId);

    void updateShop(Shop shop);
}
