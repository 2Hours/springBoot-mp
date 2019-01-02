package com.shop.hzq.service;

import com.shop.hzq.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
public interface GoodsService extends IService<Goods> {

    void addGoods(String shopId, Goods goods);

    void updateGoods(Goods goods);

    void deleteGoods(String GoodsId);

    void setGoodsStatus(String GoodsId,Integer disabled);

}
