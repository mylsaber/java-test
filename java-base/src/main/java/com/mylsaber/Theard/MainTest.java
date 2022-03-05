package com.mylsaber.Theard;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author jfw
 */
public class MainTest {
    @Test
    public void test1() throws InterruptedException {
        final MyThread myThread = new MyThread();
        myThread.start();
        final MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
        final Thread testThread = new Thread(() -> {
            System.out.println("java8方式开启线程");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        testThread.start();
        System.out.println("-----常用方法-------");
        System.out.println(Thread.currentThread());
        testThread.join();
        System.out.println("main方法结束");
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        final MyCallable myCallable = new MyCallable();
        final FutureTask<String> stringFutureTask = new FutureTask<>(myCallable);
        stringFutureTask.run();
        System.out.println(stringFutureTask.get());

        System.out.println("---------------------------------");
        final ExecutorService executorService = Executors.newCachedThreadPool();
        final Future<String> submit = executorService.submit(new MyCallable());
        System.out.println(submit.get());

        System.out.println("---------------------------------");
        final FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        executorService.submit(futureTask);
        System.out.println(futureTask.get());
    }

    @Test
    public void test3() throws InterruptedException {
        System.out.println("当前线程组名称");
        final ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.getName());
        System.out.println("复制线程组");
        final Thread[] threads = new Thread[threadGroup.activeCount()];
        final int enumerate = threadGroup.enumerate(threads);
        System.out.println(enumerate);
        System.out.println("---------线程组统一异常处理----------");
        ThreadGroup groupTest = new ThreadGroup("groupTest") {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ":" + e.getMessage());
            }
        };
        Thread test = new Thread(groupTest,()->{
            int i = 1/0;
        });
        test.start();
        test.join();
    }
}
