package com.mylsaber.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jfw
 */
public class JdkProxy implements InvocationHandler {
    private Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        final Object invoke = method.invoke(target, args);
        System.out.println("after");
        return invoke;
    }

    public static <T> T getProxy(T target) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new JdkProxy(target));
    }

    public static interface Animal {
        String run();
    }

    public static class Monkey implements Animal{
        @Override
        public String run() {
            System.out.println("monkey run");
            return "monkey run";
        }
    }
}
