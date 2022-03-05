package com.mylsaber.Theard;

/**
 * @author jfw
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("通过继承Thread方式开启线程");
    }
}
