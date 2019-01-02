package com.wewe.dynamicProxyExample;

/**
 * Author: fei2
 * Date:  18-9-12 下午7:35
 * Description:
 * Refer To:
 */
/*
 * 目标是让目标对象和增强都可以切换！
 */
public class Demo3 {

    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();//创建工厂
        factory.setTargetObject(new ManWaiter());//设置目标对象
        factory.setBeforeAdvice(new BeforeAdvice() {//设置前置增强
            public void before() {
                System.out.println("您好不好！");
            }
        });

        factory.setAfterAdvice(new AfterAdvice() {//设置后置增强
            public void after() {
                System.out.println("再见不见！");
            }
        });
        Waiter waiter = (Waiter)factory.createProxy();
        waiter.serve();
        waiter.shouQian();
    }
}

