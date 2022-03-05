package com.mylsaber.Theard.pool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jfw
 */
public class ThreadPoolTest {
    public ThreadPoolExecutor getExecutor() {
        return new ThreadPoolExecutor(10,
                20,
                10,
                TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(10),
                getExecutor().getThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }
}
