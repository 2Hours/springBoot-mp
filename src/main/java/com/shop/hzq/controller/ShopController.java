package com.shop.hzq.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.hzq.entity.Shop;
import com.shop.hzq.mapper.ShopMapper;
import com.shop.hzq.service.ShopService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商家 前端控制器
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@RestController
@RequestMapping("/api/shop")
public class ShopController {

    @Autowired
    ShopMapper shopMapper;
    @Autowired
    ShopService shopService;

    @GetMapping("/list")
    public IPage<Shop> findAllShop(Integer pageNum,Integer pageSize){
        return shopMapper.selectPage(new Page<>(pageNum,pageSize),new QueryWrapper<Shop>().orderByDesc(true,"create_time"));
    }

    @GetMapping("/{keyword}/list")
    public IPage<Shop> findShopByParam(@PathVariable(name = "keyword")String keyword,Integer pageNum, Integer pageSize){
        return shopMapper.selectPage(new Page<>(pageNum,pageSize),new QueryWrapper<Shop>()
                .like("shop_name",keyword)
                .orderByDesc("create_time"));
    }

    @PostMapping("/add")
    public void addOneShop(Shop shop){
        shopService.addOneShop(shop);
    }

    @PostMapping("/{shopId}/disable")
    public void setShopDisable(@PathVariable(name = "shopId")String shopId){
        shopService.disableShop(shopId);
    }

    @PostMapping("/{shopId}/delete")
    public void deleteShop(@PathVariable(name = "shopId")String shopId){
        shopService.deleteShop(shopId);
    }

    @PostMapping("/update")
    public void updateShop(Shop shop){
        shopService.updateShop(shop);
    }

}

