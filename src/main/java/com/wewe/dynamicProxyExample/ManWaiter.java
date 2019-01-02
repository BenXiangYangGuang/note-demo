package com.wewe.dynamicProxyExample;

/**
 * Author: fei2
 * Date:  18-9-12 下午7:36
 * Description:
 * Refer To:
 */
public class ManWaiter implements Waiter {
    public void serve() {
        System.out.println("服务中...");
    }

    public void shouQian() {
        System.out.println("混蛋，给我钱！");
    }
}
