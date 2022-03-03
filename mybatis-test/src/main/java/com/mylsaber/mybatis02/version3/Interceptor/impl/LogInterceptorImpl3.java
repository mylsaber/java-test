package com.mylsaber.mybatis02.version3.Interceptor.impl;

import com.mylsaber.mybatis02.version3.Interceptor.Interceptor3;

public class LogInterceptorImpl3 implements Interceptor3 {
    @Override
    public void before() {
        System.out.println("logBefore");
    }

    @Override
    public void after() {
        System.out.println("logAfter");
    }
}
