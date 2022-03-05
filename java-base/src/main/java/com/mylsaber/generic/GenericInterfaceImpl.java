package com.mylsaber.generic;

/**
 * @author jfw
 */
public class GenericInterfaceImpl<T> implements GenericInterface<T> {
    @Override
    public T next() {
        return null;
    }
}

class GenericInterfaceImpl2 implements GenericInterface<String> {

    @Override
    public String next() {
        return "hello";
    }
}