package com.wewe.designpattern.builder;

/**
 * Created by fei2 on 2018/5/17.
 * 描述：
 */
public class Name {
    
    private final String name;
    
    public Name(final String newName) {
        this.name = newName;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
