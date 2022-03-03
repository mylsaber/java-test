package com.mylsaber.mybatis02.version3.handler;

import com.mylsaber.mybatis02.version3.Interceptor.Interceptor3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler3 implements InvocationHandler {
    private Object target;
    private Interceptor3 interceptor3;

    public ProxyHandler3(Object target, Interceptor3 interceptor3) {
        this.target = target;
        this.interceptor3 = interceptor3;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        interceptor3.before();
        final Object invoke = method.invoke(target, args);
        interceptor3.after();
        return invoke;
    }

    public static <T> T wrap(T target, Interceptor3 interceptor3) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new ProxyHandler3(target, interceptor3));
    }
}
