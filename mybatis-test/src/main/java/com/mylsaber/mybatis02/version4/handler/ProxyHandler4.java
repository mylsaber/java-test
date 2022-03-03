package com.mylsaber.mybatis02.version4.handler;

import com.mylsaber.mybatis02.version4.Invocation;
import com.mylsaber.mybatis02.version4.interceptor.Interceptor4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jfw
 */
public class ProxyHandler4 implements InvocationHandler {
    private Object target;
    private Interceptor4 interceptor4;

    public ProxyHandler4(Object target, Interceptor4 interceptor4) {
        this.target = target;
        this.interceptor4 = interceptor4;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        final Invocation invocation = new Invocation(target, method, args);
        return interceptor4.intercept(invocation);
    }

    public static <T> T wrap(T target, Interceptor4 interceptor4) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new ProxyHandler4(target, interceptor4));
    }
}
