package com.wewe.thredExample;

/**
 * Author: wewe
 * Date:  18-8-11 下午7:33
 * Description:  synchronized 代码块
 *  锁住代码块是对 对象的锁,每一个对象都有一个 monitor 对象;一旦线程持有了这个对象,其他线程只能等待.
 *  这个关键字有特殊的意义,他会在代码编译时期,赋予同步线程的标志
 *  synchronized(this)中的this是指调用者;同一个调用者调用不同 的 synchronized 的方法也是同步执行
 *  代码块 方法 锁的是对象
 *  静态方法 锁的是类对象吧
 * Refer To:http://www.cnblogs.com/paddix/p/5367116.html
 */
public class SynchronizedTest {
    public void method1(){
        System.out.println("Method 1 start");
        try {
            synchronized (this) {
                System.out.println("Method 1 execute");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public void method2(){
        System.out.println("Method 2 start");
        try {
            synchronized (this) {
                System.out.println("Method 2 execute");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }

    public synchronized void method3(String name){
        System.out.println("Method 2 start : " + name);
        try {
            if (name.equals("name1")){
            System.out.println("Method 2 execute :" + name);
                Thread.sleep(2000);

            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end : " + name);
    }

    public static void main(String[] args) {
        final SynchronizedTest test = new SynchronizedTest();
        final SynchronizedTest test2 = new SynchronizedTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method3("name1");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test2.method3("name2");
            }
        }).start();
    }
}
