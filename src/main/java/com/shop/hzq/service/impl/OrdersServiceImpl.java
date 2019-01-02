package com.shop.hzq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shop.hzq.entity.Orders;
import com.shop.hzq.mapper.OrdersMapper;
import com.shop.hzq.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.hzq.utils.EmptyUtils;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Autowired
    OrdersMapper ordersMapper;


    @Override
    @Transactional
    public void addOneOrder(Orders order) {
        if (EmptyUtils.isEmpty(order.getUserId())){
            throw new UnsupportedOperationException("userId不能为空！");
        }
        else if (EmptyUtils.isEmpty(order.getUserAddressId())){
            throw new UnsupportedOperationException("userAddressId不能为空!");
        }else {
            order.setOrderId(UUID.randomUUID().toString().replaceAll("-",""));
            order.setStatus(Orders.normal);
            order.setOrderStatus(Orders.unpaid);
            order.setCreateTime(LocalDateTime.now());
            ordersMapper.insert(order);
        }
    }

    @Override
    public void updateOrder(Orders order) {
        if (EmptyUtils.isEmpty(order.getOrderId())){
            throw new UnsupportedOperationException("orderId不能为空！");
        }else{
            ordersMapper.updateById(order);
        }
    }

    @Override
    public void cancelOrder(String orderId) {
        if (EmptyUtils.isEmpty(orderId)){
            throw new UnsupportedOperationException("orderId不能为空！");
        }else{
            Orders orders = new Orders();
            orders.setOrderId(orderId);
            orders.setStatus(Orders.cancel);
            ordersMapper.updateById(orders);
        }
    }

    @Override
    public void deleteOrder(String[] orderIds) {
        Orders orders = new Orders();
        for (String id:orderIds) {
            orders.setOrderId(id);
            ordersMapper.updateById(orders);
        }
    }
}
