package com.wewe.executorpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by fei2 on 2018/5/28.
 * 描述：源码解读
 * 参考：https://www.jianshu.com/p/87bff5cc8d8c
 */
public class ExecutorCase {
    
    private static Executor executor = Executors.newFixedThreadPool(10);
    
    public static void main(String[] args) {
        for (int i =0;i < 20; i++){
            executor.execute(new Task());
        }
    }
    
    static class Task implements Runnable{
    
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
    
}
