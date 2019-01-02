package com.wewe.designpattern.builder.classics;

/**
 * Created by fei2 on 2018/5/17.
 * 描述：https://www.jianshu.com/p/1ddb69f1f67e
 */
public class BuilderMain {
    public static void main(String[] args) {
        //获取圆形饼干
        Director roundDirector = new Director(new SquareCookiesBuilder());
        roundDirector.createCookies();
        Cookies roundCookie = roundDirector.getCookies();
        System.out.println(roundCookie);
        //获取方形饼干
        Director squareDirector = new Director(new SquareCookiesBuilder());
        roundDirector.createCookies();
        Cookies squareCookie = roundDirector.getCookies();
        System.out.println(squareCookie);
    }
}
