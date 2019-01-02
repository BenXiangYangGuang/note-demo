package com.wewe.spring.bean.postprocessorbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by fei2 on 2018/5/17.
 * 描述：注入bean -> postProcessBeforeInitialization -> 初始化(init-method)  -> postProcessAfterInitialization
 */
public class PostProcessor implements BeanPostProcessor {
    
    //bean 已经注入，init-method之前
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("narCodeService".equals(beanName)) {//过滤掉bean实例ID为narCodeService
            return bean;
        }
        System.out.println("后置处理器处理bean=【"+beanName+"】开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bean;
    }
    //init-method 之后
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("narCodeService".equals(beanName)) {
            return bean;
        }
        System.out.println("后置处理器处理bean=【"+beanName+"】完毕!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
