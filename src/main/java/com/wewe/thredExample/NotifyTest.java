package com.wewe.thredExample;

/**
 * Author: wewe
 * Date:  18-8-12 上午10:43
 * Description: notify notifyall 唤醒 wait 线程
 *  wait()方法与wait(0)等效
 *  一个唤醒线程被执行:
 *      1.线程被唤醒
 *      2.线程竞争到锁
 * Refer To:
 */
public class NotifyTest {
    public synchronized void testWait(){
        System.out.println(Thread.currentThread().getName() +" Start-----");
        try {
            wait(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" End-------");
    }

    public static void main(String[] args) throws InterruptedException {
        final NotifyTest test = new NotifyTest();
        for(int i=0;i<5;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.testWait();
                }
            }).start();
        }

        synchronized (test) {
            test.notify();
        }
        Thread.sleep(3000);
        System.out.println("-----------分割线-------------");

        synchronized (test) {
            test.notifyAll();
        }
    }
}
