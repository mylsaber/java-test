package com.mylsaber.seatetest.service.impl;

import com.mylsaber.seatetest.service.BusinessService;
import com.mylsaber.seatetest.service.OrderService;
import com.mylsaber.seatetest.service.StorageService;

/**
 * @author jfw
 */
public class BusinessServiceImpl implements BusinessService {

    private StorageService storageService;

    private OrderService orderService;

    @Override
    public void purchase(String userId, String commodityCode, int orderCount) {

    }
}
