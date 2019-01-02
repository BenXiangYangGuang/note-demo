package com.wewe.threadArt;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: fei2
 * Date:  18-10-9 下午8:53
 * Description:
 * Refer To:
 */
public class ExchangerTest {

    private static final Exchanger<String> exgr = new Exchanger<String>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A";// A录入银行流水数据
                    String BB = exgr.exchange(A);
                    System.out.println("A --  A和B数据是否一致：" + A.equals(BB) + ",A录入的是："
                            + A + ",B录入是：" + BB);
                } catch (InterruptedException e) {
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水B";// B录入银行流水数据
                    String A = exgr.exchange("B");
                    System.out.println("B --  A和B数据是否一致：" + A.equals(B) + ",A录入的是："
                            + A + ",B录入是：" + B);
                } catch (InterruptedException e) {

                }
            }
        });

        threadPool.shutdown();

    }
}
