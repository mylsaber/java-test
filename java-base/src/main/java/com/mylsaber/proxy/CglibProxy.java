package com.mylsaber.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author jfw
 */
public class CglibProxy implements MethodInterceptor {
    private Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        final Object invoke = method.invoke(target, objects);
        System.out.println("after");
        return invoke;
    }

    public static <T> T getCglibProxy(T target) {
        final CglibProxy interceptor = new CglibProxy(target);
        final Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(interceptor);
        return (T) enhancer.create();
    }

    public static class Person {
        public String say() {
            System.out.println("say ...");
            return "say ...";
        }
    }
}
