package com.mylsaber.mybatis02.version4.interceptor.impl;

import com.mylsaber.mybatis02.version4.interceptor.Interceptor4;

/**
 * @author jfw
 */
public class LogInterceptorImpl4 implements Interceptor4 {
    @Override
    public void before() {
        System.out.println("logBefore");
    }

    @Override
    public void after() {
        System.out.println("logAfter");
    }
}
