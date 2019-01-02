package com.shop.hzq.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.hzq.entity.ShopType;
import com.shop.hzq.entity.SysConfig;
import com.shop.hzq.mapper.ShopTypeMapper;
import com.shop.hzq.mapper.SysConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 系统配置表 前端控制器
 * </p>
 *
 * @author hzq
 * @since 2018-12-28
 */
@RestController
@RequestMapping("/api/sysConfig")
public class SysConfigController {

    @Autowired
    SysConfigMapper sysConfigMapper;
    @Autowired
    ShopTypeMapper shopTypeMapper;

    @GetMapping("/{type}/get")
    public List<ShopType> getConfig(@PathVariable(name = "type")Integer type) throws Exception {
        List<SysConfig> configs = sysConfigMapper.selectList(new QueryWrapper<SysConfig>().eq("config_type",type));
        if (StringUtils.isEmpty(configs)){
            return shopTypeMapper.selectList(new QueryWrapper<ShopType>().orderByDesc(true,"create_time"));
        }else {
            List list = new ArrayList();
            for (SysConfig sysConfig : configs) {
                ShopType shopType = shopTypeMapper.selectById(sysConfig.getRelationId());
                list.add(shopType);
            }
            return list;
        }
    }

}

