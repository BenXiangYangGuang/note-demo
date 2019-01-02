package com.wewe.dynamicProxyExample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author: fei2
 * Date:  18-9-12 下午7:34
 * Description:
 * Refer To:
 */
public class MainApp1 {
    public static void main(String[] args) {
        ClassLoader loader = MainApp1.class.getClassLoader();
        Class[] cs = {Waiter.class};
        Waiter target = new MyWaiter();
        MyInvocationHandler h = new MyInvocationHandler(target);
        Waiter waiter = (Waiter) Proxy.newProxyInstance(loader, cs, h);
        waiter.serve();
    }
}

class MyInvocationHandler implements InvocationHandler {
    public Waiter target;

    public MyInvocationHandler(Waiter target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("您好！");
        Object result = method.invoke(target, args);
        System.out.println("很高兴为您服务！");
        return result;
    }
}
