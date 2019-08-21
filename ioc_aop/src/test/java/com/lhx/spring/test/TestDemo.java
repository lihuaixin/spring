package com.lhx.spring.test;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by lihuaixin on 2019/8/14 10:42
 */
public class TestDemo {
    @Test
    public void testCallable() throws ExecutionException, InterruptedException {
        TestCallable testCallable = new TestCallable();
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<Long> submit = threadPool.submit(testCallable);
        System.out.println(submit.get());
        threadPool.shutdown();
        BlockingQueue blockingQueue = new LinkedBlockingQueue();
        blockingQueue.put(1);
        blockingQueue.put(2);
        blockingQueue.put(3);

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());


    }

    class TestCallable implements Callable<Long> {

        public Long call() throws Exception {
            return 1L;
        }
    }
}
