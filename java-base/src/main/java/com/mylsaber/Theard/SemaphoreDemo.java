package com.mylsaber.Theard;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author jfw
 */
public class SemaphoreDemo extends Thread {
    private  int value;
    private Semaphore semaphore;

    public SemaphoreDemo(int value, Semaphore semaphore) {
        this.value = value;
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(String.format("当前线程是%d, 还剩%d个资源，还有%d个线程在等待",value,semaphore.availablePermits(),semaphore.getQueueLength()));
            final Random random = new Random();
            Thread.sleep(random.nextInt(1000));
            System.out.println(String.format("线程%d释放了资源", value));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new SemaphoreDemo(i,semaphore).start();
        }
    }
}
