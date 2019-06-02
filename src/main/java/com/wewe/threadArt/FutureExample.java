package com.wewe.threadArt;

import java.util.concurrent.*;

/**
 * 一个future的例子
 */

public class FutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<String> future
                = executor.submit(new Callable<String>() {
            public String call() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "test-future";
            }
        });
        try {
            String result = future.get();
            System.out.println(result);
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
