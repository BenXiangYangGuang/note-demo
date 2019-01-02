package com.wewe.thredExample.notifyExample;

import com.wewe.threadArt.utils.SleepUtils;
import com.wewe.threadArt.utils.SleepUtils;
import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * Author: wewe
 * Date:  18-9-16 下午9:15
 * Description: 测试自定义双胞胎锁
 * Refer To:
 */
public class TwinsLockTest {
    @Test
    public void test(){
        final Lock lock = new TwinsLock();

        class Worker extends Thread{
            public void run(){
                while (true){
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++){
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        for (int i = 0; i < 10; i++){
            SleepUtils.second(i);
            System.out.println();
        }
    }
}
