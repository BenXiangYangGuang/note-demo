package com.wewe.thredExample;

/**
 * Author: wewe
 * Date:  18-8-12 上午11:13
 * Description: 等待子线程结束,再去执行主线程
 * Refer To:
 */
public class JoinTest implements Runnable{
    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName() + " start-----");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<5;i++) {
            Thread test = new Thread(new JoinTest());
            test.start();
            try {;
                //join(1000) 为1000秒后执行主线程的后续操作;和另起线程的处理时间无关;
                //主线程的执行和两个时间有关;1.join的时间;2.线程的执行时间;如果,线程执行时间已经结束了,join的长时间也在不用等待了;
                test.join(10000); //调用join方法
//                test.join(); //调用join方法
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Finished~~~");
    }
}
