package com.wewe.spring.bean;


/**
 * Created by fei2 on 2018/4/17.
 */
public class HelloWorld {
    private String message;
    
    public void setMessage(String message){
        this.message  = message;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    public void printMessage(){
        System.out.println("Your Message : " + message);
    }
    
    public void printMsg(){
        System.out.println("-----------获得依赖注入HelloWorld----------");
    }
}
