package com.wewe.dynamicProxyExample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author: fei2
 * Date:  18-9-12 下午7:16
 * Description:动态代理简单版
 * Refer To:https://www.cnblogs.com/fengmingyue/p/6092151.html
 */
public class ProxyDemo2 {
    public static void main(String[] args) {
        Class[] cs = {MyInterface.class};
        ClassLoader loader = MyInterface.class.getClassLoader();
        InvocationHandler h = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("当前调用的方法是：" + method.getName());
                return null;
            }
        };
        MyInterface mi = (MyInterface) Proxy.newProxyInstance(loader, cs, h);
        //并不会真正的去执行fun1();而是执行 invoke() 方法
        mi.fun1();
        mi.fun2();
    }

}

interface MyInterface {
    void fun1();

    void fun2();
}

class MyInterfaceImpl implements MyInterface {
    public void fun1() {
        System.out.println("fun1()");
    }

    public void fun2() {
        System.out.println("fun2()");
    }
}
