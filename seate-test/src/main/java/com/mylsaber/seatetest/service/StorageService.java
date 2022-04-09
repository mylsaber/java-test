package com.mylsaber.seatetest.service;

/**
 * @author jfw
 */
public interface StorageService {
    /**
     * 扣除存储数量
     */
    void deduct(String commodityCode, int count);
}
