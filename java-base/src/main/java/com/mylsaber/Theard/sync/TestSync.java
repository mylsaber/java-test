package com.mylsaber.Theard.sync;

/**
 * @author jfw
 */
public class TestSync {
    public synchronized void instanceLock() {
        System.out.println("锁当前实例对象");
    }

    public static synchronized void classLock() {
        System.out.println("锁Class对象");
    }

    public void blockLock() {
        final Object o = new Object();
        synchronized (o) {
            System.out.println("锁括号对象");
        }
    }
}
