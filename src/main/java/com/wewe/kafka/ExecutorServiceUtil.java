package com.wewe.kafka;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: fei2
 * @Date:2018/6/14 13:33
 * @Description:
 * @Refer To:
 */
public class ExecutorServiceUtil {
    private static ExecutorService executorService = Executors
        .newCachedThreadPool();
//    private static ExecutorService executorService = Executors
//        .newFixedThreadPool(3);
    
    /**
     * 获取线程池实例
     *
     * @return
     */
    public static ExecutorService getExecutorInstance() {
        return executorService;
    }
    public static void execute(Runnable command) {
        if (executorService != null && !executorService.isShutdown()) {
            executorService.execute(command);
        }
    }
    public static void shutdownNow() {
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdownNow();
        }
    }
}
