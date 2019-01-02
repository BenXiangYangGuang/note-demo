package com.wewe.thredExample;

/**
 * Author: wewe
 * Date:  18-8-12 上午11:54
 * Description:volatile 只能保证单次读写操作的原子性
 * volatile 三个作用
 *  1.内存屏障保持代码的有序性
 *  2.将最新值从工作区缓存写入到共享主存
 *  3.使其他工作区缓存内容失效
 * Refer To:
 */
public class VolatileTest {
   volatile int a = 1;
   volatile int b = 2;

    public void change(){
        a = 3;
        b = a;
    }

    public void print(){
        System.out.println("b="+b+";a="+a);
//        System.out.println(a);
    }

    public static void main(String[] args) {
        while (true){
            final VolatileTest test = new VolatileTest();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.change();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();

        }
    }
}
