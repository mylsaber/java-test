package com.mylsaber.seatetest.service;

/**
 * @author jfw
 */
public interface AccountService {
    /**
     * 从用户账户中借出
     */
    void debit(String userId, int money);
}
