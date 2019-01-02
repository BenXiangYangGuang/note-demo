package com.wewe.designpattern.builder.classics;

/**
 * Created by fei2 on 2018/5/17.
 * 描述：
     * 经典Buider模式分为四块：
         Product:被构造的复杂对象。
         Builder:抽象接口。
         BuilderImpl:抽象接口的具体实现。
         Director:接口的构造者和使用者。
 */
public interface Builder {
    public void setShape();
    public Cookies getCookies();
}
