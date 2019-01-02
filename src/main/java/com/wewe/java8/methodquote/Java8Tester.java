package com.wewe.java8.methodquote;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fei2 on 2018/5/22.
 * 描述：
 */
public class Java8Tester {
    
    
    public static void main(String[] args) {
        
        
        List names = new ArrayList();
    
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
    
        names.forEach(System.out::println);
    }
    
}
