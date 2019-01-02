package com.wewe.designpattern.builder.classics;

/**
 * Created by fei2 on 2018/5/17.
 * 描述：
 */
public class Director {
    private Builder builder;
    
    public Director(Builder builder){
        this.builder = builder;
    }
    
    public void createCookies(){
        this.builder.setShape();
    }
    
    public Cookies getCookies(){
        return this.builder.getCookies();
    }
    
}
