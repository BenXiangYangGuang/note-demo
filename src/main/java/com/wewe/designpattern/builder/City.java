package com.wewe.designpattern.builder;

/**
 * Created by fei2 on 2018/5/17.
 * 描述：
 */
public class City {
    private final String cityName;
    
    public City(final String newCityName) {
        this.cityName = newCityName;
    }
    
    public String getCityName() {
        return this.cityName;
    }
    
    @Override
    public String toString() {
        return this.cityName;
    }
}
