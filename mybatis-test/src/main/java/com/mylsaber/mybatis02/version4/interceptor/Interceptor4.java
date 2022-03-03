package com.mylsaber.mybatis02.version4.interceptor;

import com.mylsaber.mybatis02.version4.Invocation;
import com.mylsaber.mybatis02.version4.handler.ProxyHandler4;

public interface Interceptor4 {
    default void before() {

    }

    default void after() {

    }

    default Object intercept(Invocation invocation) {
        this.before();
        final Object process = invocation.process();
        this.after();
        return process;
    }

    default <T> T plugin(T target) {
        return ProxyHandler4.wrap(target, this);
    }
}
