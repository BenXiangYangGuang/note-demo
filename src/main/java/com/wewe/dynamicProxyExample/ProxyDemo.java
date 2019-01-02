package com.wewe.dynamicProxyExample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author: fei2
 * Date:  18-9-12 下午6:55
 * Description:动态代理
 * Refer To:
 */
public class ProxyDemo {
    public static void main(String[] args) throws IllegalArgumentException {
        InvocationHandler handler = new SampleInvocationHandler() ;
        SampleInterface proxy = (SampleInterface) Proxy.newProxyInstance(
                SampleInterface.class.getClassLoader(),
                new Class[] { SampleInterface.class },
                handler);
        Class invocationHandler = Proxy.getInvocationHandler(proxy).getClass();

        System.out.println(invocationHandler.getName());
        proxy.showMessage();
    }
}

class SampleInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("Welcome to TutorialsPoint");
        return null;
    }
}

interface SampleInterface {
    void showMessage();
}

class SampleClass implements SampleInterface {
    public void showMessage(){
        System.out.println("Hello World");
    }
}
