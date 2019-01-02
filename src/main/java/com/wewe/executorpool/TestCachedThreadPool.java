package com.wewe.executorpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by fei2 on 2018/5/28.
 * 描述：
 * 参考：https://www.oschina.net/question/565065_86540
 */
public class TestCachedThreadPool {
    
    public static void main(String[] args) {
        
        //创建一个可重用固定线程数的线程池
        
        ExecutorService pool = Executors.newCachedThreadPool();
        
        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        MyRunnable r1 = new MyRunnable();
        /*Runnable r2 = new MyRunnable();
        Runnable r3 = new MyRunnable();
        Runnable r4 = new MyRunnable();
        Runnable r5 = new MyRunnable();*/
        
        
        
        
        //将线程放入池中进行执行
        
        pool.execute(r1);
    
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r1.setFlag(false);
        
       /* pool.execute(r2);
        
        pool.execute(r3);
        
        pool.execute(r4);
        
        pool.execute(r5);*/
        
        //关闭线程池
        
        pool.shutdown();
        
    }
    
}
