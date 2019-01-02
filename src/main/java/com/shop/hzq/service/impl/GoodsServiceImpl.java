package com.shop.hzq.service.impl;

import com.shop.hzq.entity.Goods;
import com.shop.hzq.mapper.GoodsMapper;
import com.shop.hzq.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Override
    public void addGoods(String shopId, Goods goods) {

    }

    @Override
    public void updateGoods(Goods goods) {

    }

    @Override
    public void deleteGoods(String GoodsId) {

    }

    @Override
    public void setGoodsStatus(String GoodsId, Integer disabled) {

    }
}
