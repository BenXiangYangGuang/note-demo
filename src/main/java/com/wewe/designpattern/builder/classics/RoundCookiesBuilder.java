package com.wewe.designpattern.builder.classics;

/**
 * Created by fei2 on 2018/5/17.
 * 描述：
 */
public class RoundCookiesBuilder implements Builder{
    private Cookies cookies;
    
    public RoundCookiesBuilder(){
        this.cookies = new Cookies();
    }
    
    @Override
    public void setShape(){
        this.cookies.setShape("圆形");
    }
    
    @Override
    public Cookies getCookies(){
        return this.cookies;
    }

}
