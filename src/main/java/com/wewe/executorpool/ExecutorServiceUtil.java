package com.wewe.executorpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by fei2 on 2018/5/29.
 * 描述：
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
    
    public static void shutdown() {
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }
}
