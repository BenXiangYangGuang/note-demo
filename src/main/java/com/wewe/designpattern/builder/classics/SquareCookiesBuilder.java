package com.wewe.designpattern.builder.classics;

/**
 * Created by fei2 on 2018/5/17.
 * 描述：
 */
public class SquareCookiesBuilder implements Builder {
    private Cookies cookies;

    public SquareCookiesBuilder(){
        this.cookies = new Cookies();
    }
    
    @Override
    public void setShape(){
        this.cookies.setShape("方形");
    }
    
    @Override
    public Cookies getCookies(){
        return this.cookies;
    }
    
}
