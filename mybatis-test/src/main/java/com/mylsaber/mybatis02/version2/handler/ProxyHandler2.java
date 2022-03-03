package com.mylsaber.mybatis02.version2.handler;

import com.mylsaber.mybatis02.version2.Interceptor.Interceptor2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jfw
 */
public class ProxyHandler2 implements InvocationHandler {
    private Object target;
    private Interceptor2[] interceptor2s;

    public ProxyHandler2(Object target, Interceptor2[] interceptor2s) {
        this.target = target;
        this.interceptor2s = interceptor2s;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (Interceptor2 interceptor2 : interceptor2s) {
            interceptor2.before();
        }
        final Object invoke = method.invoke(target, args);
        for (Interceptor2 interceptor2 : interceptor2s) {
            interceptor2.after();
        }
        return invoke;
    }

    public static <T> T wrap(T target,Interceptor2... interceptor2s) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new ProxyHandler2(target, interceptor2s));
    }
}
