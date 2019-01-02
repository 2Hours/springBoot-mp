package com.shop.hzq.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.hzq.entity.Orders;
import com.shop.hzq.mapper.OrdersMapper;
import com.shop.hzq.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    OrdersService ordersService;

    @GetMapping("/{orderId}/items")
    public Orders findOrderById(@PathVariable(name = "orderId")String orderId){
        return ordersMapper.selectById(orderId);
    }

    @GetMapping("/list")
    public IPage<Orders> orderlist(Integer pageNum,Integer pageSize){
        return ordersMapper.selectPage(new Page<>(pageNum,pageSize),new QueryWrapper<Orders>().orderByDesc(true,"create_time"));
    }

    @PostMapping("/add")
    public void addOneOrder(Orders order){
        ordersService.addOneOrder(order);
    }

    @PostMapping("/delete")
    public void deleteOneOrder(String orderId){
        ordersService.deleteOrder(orderId.split(","));
    }

}

