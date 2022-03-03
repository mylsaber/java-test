package com.mylsaber.mybatis02.version2.Interceptor.impl;

import com.mylsaber.mybatis02.version2.Interceptor.Interceptor2;

public class LogInterceptorImpl2 implements Interceptor2 {
    @Override
    public void before() {
        System.out.println("logBefore");
    }

    @Override
    public void after() {
        System.out.println("logAfter");
    }
}
