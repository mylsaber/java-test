package com.mylsaber.mybatis02.version1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jfw
 */
public class ProxyHandler1 implements InvocationHandler {
    private Object target;

    public ProxyHandler1(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置通知");
        final Object invoke = method.invoke(target, args);
        System.out.println("后置通知");
        return invoke;
    }

    public static <T> T wrap(T target) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new ProxyHandler1(target));
    }
}
