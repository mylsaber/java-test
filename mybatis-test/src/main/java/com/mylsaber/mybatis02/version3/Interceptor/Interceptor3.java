package com.mylsaber.mybatis02.version3.Interceptor;

import com.mylsaber.mybatis02.version3.handler.ProxyHandler3;

public interface Interceptor3 {
    void before();

    void after();

    default <T> T plugin(T target) {
        return ProxyHandler3.wrap(target, this);
    }
}
