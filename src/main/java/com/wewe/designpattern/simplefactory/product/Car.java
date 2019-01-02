package com.wewe.designpattern.simplefactory.product;

/**
 * Author: fei2
 * Date:  18-8-9 下午7:24
 * Description:
 * Refer To:
 */
public abstract class Car {

    protected String name;

    public abstract void drive();

    public String getName(){
        return this.name;
    }
}
