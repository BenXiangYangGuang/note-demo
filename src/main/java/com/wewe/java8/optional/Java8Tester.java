package com.wewe.java8.optional;

import java.util.Optional;

/**
 * Created by fei2 on 2018/5/23.
 * 描述：
 */
public class Java8Tester {
    
    public static void main(String[] args) {
        Java8Tester java8Tester = new Java8Tester();
        
        Integer value1 = null;
        Integer value2 = new Integer(10);
    
        Optional<Integer> a = Optional.ofNullable(value1);
        
        Optional<Integer> b = Optional.of(value2);
        
        System.out.println(java8Tester.sum(a,b));
    }
    
    public Integer sum(Optional<Integer> a,Optional<Integer> b){
        System.out.println("第一个参数值存在" + a.isPresent());
        System.out.println("第二个参数值存在" + b.isPresent());
        
        Integer value1 = a.orElse(new Integer((10)));
        
        Integer value2 = b.get();
        
        return value1 + value2;
    }
}
