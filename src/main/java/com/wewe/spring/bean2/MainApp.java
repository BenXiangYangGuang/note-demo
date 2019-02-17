package com.wewe.spring.bean2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fei2 on 2018/4/17.
 */
public class MainApp {
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        HelloWorldSingle objSingleOne = (HelloWorldSingle) context.getBean("helloWorldSingle");
        HelloWorldSingle objSingleTwo = (HelloWorldSingle) context.getBean("helloWorldSingle");
        HelloWorldPrototype HelloWorldPrototypeOne = (HelloWorldPrototype) context.getBean("helloWorldPrototype");
        HelloWorldPrototype HelloWorldPrototypeTwo = (HelloWorldPrototype) context.getBean("helloWorldPrototype");

    }
}
