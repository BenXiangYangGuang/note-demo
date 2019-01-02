package com.wewe.designpattern.builder;

/**
 * Created by fei2 on 2018/5/17.
 * 描述：
 */
public class StreetAddress {
    private final String address;
    
    public StreetAddress(final String newStreetAddress) {
        this.address = newStreetAddress;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    @Override
    public String toString() {
        return this.address;
    }
}
