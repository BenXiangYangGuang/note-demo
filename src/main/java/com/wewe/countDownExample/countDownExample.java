package com.wewe.countDownExample;

import java.util.concurrent.CountDownLatch;

/**
 * Author: fei2
 * Date:  18-9-12 下午8:13
 * Description: countDownLatch  程序计数器
 * Refer To:
 * https://blog.csdn.net/asdasd3418/article/details/77172473
 * https://www.cnblogs.com/catkins/p/6021992.html
 */
public class countDownExample {
    public static void main(String[] args) {

        //所有线程阻塞，然后统一开始
        CountDownLatch begin = new CountDownLatch(1);

        //主线程阻塞，直到所有分线程执行完毕
        CountDownLatch end = new CountDownLatch(5);

        for(int i = 0; i < 5; i++){
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        begin.await();
                        System.out.println(Thread.currentThread().getName() + " 起跑");
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + " 到达终点");
                        end.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });

            thread.start();
        }

        try {
            System.out.println("1秒后统一开始");
            Thread.sleep(1000);
            begin.countDown();

            end.await();
            System.out.println("停止比赛");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
