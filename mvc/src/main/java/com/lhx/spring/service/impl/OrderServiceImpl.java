package com.lhx.spring.service.impl;

import com.lhx.spring.annotation.EnjoyService;
import com.lhx.spring.service.OrderService;

/**
 * Created by lihuaixin on 2019/8/5 16:38
 */
@EnjoyService("orderService")
public class OrderServiceImpl implements OrderService {
    @Override
    public String queryOrder(String orderId) {
        return "orderId:" + orderId;
    }
}
