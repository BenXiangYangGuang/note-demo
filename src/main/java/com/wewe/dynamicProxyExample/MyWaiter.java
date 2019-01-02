package com.wewe.dynamicProxyExample;

/**
 * Author: fei2
 * Date:  18-9-12 下午7:33
 * Description:
 * Refer To:
 */
public class MyWaiter implements Waiter{

    @Override
    public void serve() {
        System.out.println("服务....");
    }

    @Override
    public void shouQian() {

    }
}
