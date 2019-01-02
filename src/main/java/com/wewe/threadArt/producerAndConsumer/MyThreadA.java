package com.wewe.threadArt.producerAndConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: wewe
 * Date:  18-9-9 下午10:38
 * Description:
 * 等待/通知机制 最经典的应用就是 生产者-消费者模型;
 * 多个生产者和多个消费者背景;
 *  Lock+Condition模式实现 wait-notify 机制
 *
 * Refer To:https://blog.csdn.net/justloveyou_/article/details/54929949
 */
// 线程A
class MyThreadA extends Thread {

    private MyService myService;

    public MyThreadA(MyService myService, String name) {
        super(name);
        this.myService = myService;
    }

    @Override
    public void run() {
        while (true)
            myService.set();
    }
}

// 线程B
class MyThreadB extends Thread {

    private MyService myService;

    public MyThreadB(MyService myService, String name) {
        super(name);
        this.myService = myService;
    }

    @Override
    public void run() {
        while (true)
            myService.get();
    }
}

// 资源类
class MyService {

    private ReentrantLock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();   // 生产线程
    private Condition conditionB = lock.newCondition();  // 消费线程
    private boolean hasValue = false;

    public void set() {
        lock.lock();
        try {
            while (hasValue == true) {
                System.out.println("[生产线程] " + " 线程"
                        + Thread.currentThread().getName() + " await...");
                conditionA.await();
            }
            System.out.println("[生产中] " + " 线程" + Thread.currentThread().getName() + " 生产★");
            Thread.sleep(1000);
            hasValue = true;
            System.out.println("线程" + Thread.currentThread().getName() + " 生产完毕...");
            System.out.println("[唤醒所有消费线程] " + " 线程"
                    + Thread.currentThread().getName() + "...");
            conditionB.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        lock.lock();
        try {
            while (hasValue == false) {
                System.out.println("[消费线程] " + " 线程"
                        + Thread.currentThread().getName() + " await...");
                conditionB.await();
            }
            System.out.println("[消费中] " + " 线程"
                    + Thread.currentThread().getName() + " 消费☆");
            Thread.sleep(1000);
            System.out.println("线程" + Thread.currentThread().getName() + " 消费完毕...");
            hasValue = false;
            System.out.println("[唤醒所有生产线程] " + " 线程"
                    + Thread.currentThread().getName() + "...");
            conditionA.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Run3 {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();

        MyThreadA[] threadA = new MyThreadA[10];
        MyThreadB[] threadB = new MyThreadB[10];

        for (int i = 0; i < 10; i++) {
            threadA[i] = new MyThreadA(service, "ThreadA-" + i);
            threadB[i] = new MyThreadB(service, "ThreadB-" + i);
            threadA[i].start();
            threadB[i].start();
        }
    }
}
