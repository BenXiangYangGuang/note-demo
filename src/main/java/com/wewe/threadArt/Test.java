package com.wewe.threadArt;

/**
 * Author: wewe
 * Date:  18-9-9 下午6:45
 * Description: 一个线程一个ThreadLocalMap对象;一个map对象可以存放过ThreadLocal对象;一个ThreadLocal对象,是一个key,只能你对有一个value;
 * Refer To:https://www.cnblogs.com/dolphin0520/p/3920407.html
 */
public class Test {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final Test test = new Test();


        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());


        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
