package com.mylsaber.mybatis02.version4.handler;

import com.mylsaber.mybatis02.version4.interceptor.Interceptor4;

/**
 * @author jfw
 */
public class TxInterceptorImpl4 implements Interceptor4 {
    @Override
    public void before() {
        System.out.println("TxBefore");
    }

    @Override
    public void after() {
        System.out.println("TxAfter");
    }
}
