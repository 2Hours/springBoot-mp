package com.shop.hzq.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.hzq.entity.Goods;
import com.shop.hzq.mapper.GoodsMapper;
import com.shop.hzq.service.GoodsService;
import com.shop.hzq.service.ShopService;
import com.shop.hzq.vo.GoodsExtention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@RestController
@RequestMapping("/api/shop")
public class GoodsController {

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsService goodsService;

    @GetMapping("/goods-show/index")
    public IPage<GoodsExtention> indexItems(Integer type){
        return goodsMapper.getIndexItemByType(new Page<>(1,10),type);
    }

    @GetMapping("/{shopId}/goods-list")
    public IPage<Goods> findAllShopGoods(Integer pageNum,Integer pageSize){
        return goodsMapper.selectPage(new Page<>(pageNum,pageSize),new QueryWrapper<Goods>().orderByDesc("create_time"));
    }

    @GetMapping("/{shopId}/{categoryId}/items")
    public IPage<Goods> findGoodsByCategory(Integer pageNum,Integer pageSize,@PathVariable(name = "categoryId") String categoryId,
                                            @PathVariable(name = "shopId") String shopId,String goods_name){
        return goodsMapper.selectPage(new Page<>(pageNum,pageSize),new QueryWrapper<Goods>()
                .eq("shopId",shopId)
                .eq("goods_name",goods_name)
                .eq("class_id",categoryId));
    }

    @GetMapping("/{keyword}/goods-list")
    public Map<String,Object> searchResult(@PathVariable(name = "keyword")String keyword){
        return goodsMapper.searchResult(keyword);
    }

    @PostMapping("/{shopId}/goods/add")
    public void addGoods(@PathVariable(name = "shopId")String shopId,Goods goods){
        goodsService.addGoods(shopId,goods);
    }

    @PostMapping("/{shopId}/goods/update")
    public void updateGoods(@PathVariable(name = "shopId")String shopId,Goods goods){
        goodsService.updateGoods(goods);
    }

    @PostMapping("/{shopId}/goods/{goodsId}/delete")
    public void deleteGoods(@PathVariable(name = "shopId")String shopId,String goodsId){
        goodsService.deleteGoods(goodsId);
    }

    @PostMapping("/{shopId}/goods/{goodsId}/{disabled}")
    public void setGoodsStatus(@PathVariable(name = "shopId")String shopId,@PathVariable(name = "goodsId")String goodsId,@PathVariable(name = "goodsId")Integer disabled){
        goodsService.setGoodsStatus(goodsId,disabled);
    }

}

