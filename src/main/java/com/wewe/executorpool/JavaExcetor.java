package com.wewe.executorpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by fei2 on 2018/5/28.
 * 描述：java 自带的threadPoolExecutor
 */
public class JavaExcetor {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,15,60, TimeUnit.MICROSECONDS,new LinkedBlockingDeque<Runnable>());
        
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("------执行任务1-----");
        
            }
        });
    }
}
