package com.wewe.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fei2 on 2018/4/17.
 */
@Service
public class HelloWorld2 {
    
    
    @Autowired
    private HelloWorld helloWorld;
    
    public void printMessage(){
        System.out.println("Your Message : HelloWorld2" );
    }
    
    public void printMsg(){
        helloWorld.printMsg();
    }
}
