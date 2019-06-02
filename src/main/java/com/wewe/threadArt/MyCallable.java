package com.wewe.threadArt;

import java.util.concurrent.Callable;

/**
 * Author: fei2
 * Date:  19-6-2 下午8:05
 * Description:
 * Refer To:
 */
public class MyCallable implements Callable<String> {

    private long waitTime;

    public MyCallable(int timeInMillis){
        this.waitTime=timeInMillis;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
    }

}
