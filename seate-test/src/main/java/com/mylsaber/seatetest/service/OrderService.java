package com.mylsaber.seatetest.service;

import com.mylsaber.seatetest.entity.Order;

/**
 * @author jfw
 */
public interface OrderService {

    /**
     * 创建订单
     */
    Order create(String userId, String commodityCode, int orderCount);
}
