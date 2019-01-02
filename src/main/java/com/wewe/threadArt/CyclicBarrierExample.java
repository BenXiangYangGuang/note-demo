package com.wewe.threadArt;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: fei2
 * Date:  18-10-9 下午8:22
 * Description:
 * Refer To:http://www.cnblogs.com/hithlb/p/4286659.html
 */
public class CyclicBarrierExample {
    private static AtomicInteger i = new AtomicInteger(0);
    /**
     * 4 个线程；分2 组
     * 可重用
     */
    public static void main(String[] args){
        CyclicBarrier cb = new CyclicBarrier(4,new Runnable() {
            //主任务汇集计算结果
            public void run() {
                System.out.println("-------最后一个线程执行完毕前执行-------");
                System.out.println("结果为" + i.get());
            }
        });
        ExecutorService es = Executors.newFixedThreadPool(5);
        es.submit(new SubTask(cb, "线程一"));
        es.submit(new SubTask(cb, "线程二"));
        es.submit(new SubTask(cb, "线程三"));
        es.submit(new SubTask(cb, "线程四"));
        es.shutdown();
    }

    //子任务计算
    private static class SubTask implements Runnable{
        private CyclicBarrier cb;
        private String msg;
        public SubTask(CyclicBarrier cb, String msg){
            this.cb = cb;
            this.msg = msg;
        }
        public void run() {
            try {
                System.out.println(msg + " enter");
                i.incrementAndGet();
                Thread.sleep(1000l);
                cb.await();
                System.out.println(msg + " quit");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

