package com.wewe.spring.bean;

import com.wewe.spring.bean.utils.SpringContextUtil;
import com.wewe.spring.bean.utils.SpringContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by fei2 on 2018/4/17.
 */
public class MainApp {
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames){
            System.out.println(beanName);
        }
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.printMessage();
        HelloWorld2 obj2 = (HelloWorld2) SpringContextUtil.getBean("helloWorld2");
        obj2.printMessage();
        
        /**
         * new 出来的一个对象，不会去获得它的里面注入的对象，依赖注入是通过第一个对象就注入，
         * 然后其他的对象才能依次通过遍历注入到这个对象中，提供对象服务，
         * 否则报对象的空指针异常，java.lang.NullPointerException
         *
         *  HelloWorld2 helloWorld2 = new HelloWorld2();
         *  helloWorld2.printMsg();
         */
       
    }
}
