package com.mylsaber.Theard;

import java.util.concurrent.Callable;

/**
 * @author jfw
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        System.out.println("开启Callable线程");
        return "Callable线程返回值";
    }
}
