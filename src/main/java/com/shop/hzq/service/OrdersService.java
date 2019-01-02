package com.shop.hzq.service;

import com.shop.hzq.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
public interface OrdersService extends IService<Orders> {

    void addOneOrder(Orders order);

    void updateOrder(Orders order);

    void cancelOrder(String orderId);

    void deleteOrder(String[] orderIds);
}
