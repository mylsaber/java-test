package com.mylsaber.mybatis02.version4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jfw
 */
public class Invocation {
    private Object target;

    private Method method;

    private Object[] args;

    public Invocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    public Object process() {
        try {
            return method.invoke(target, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
