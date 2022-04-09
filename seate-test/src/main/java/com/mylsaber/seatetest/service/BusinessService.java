package com.mylsaber.seatetest.service;

/**
 * @author jfw
 */
public interface BusinessService {
    /**
     * 采购
     *
     * @param userId 用户id
     * @param commodityCode
     * @param orderCount
     */
    void purchase(String userId, String commodityCode, int orderCount);

}
