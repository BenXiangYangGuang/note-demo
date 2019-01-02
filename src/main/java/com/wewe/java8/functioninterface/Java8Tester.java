package com.wewe.java8.functioninterface;

import javax.lang.model.type.IntersectionType;
import javax.swing.plaf.PanelUI;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by fei2 on 2018/5/23.
 * 描述：
 */
public class Java8Tester {
    
    public static void main(String[] args) {
    
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        
        
        //p
        System.out.println("输出所有数据：");
        
        eval(list,n -> true);
        
        System.out.println("输出所有偶数");
        
        eval(list ,n -> n%2 ==0 );
        
        System.out.println("输出所有大于 3 的数字");
        
        eval(list,n -> n >3 );
    
        
    }
    public static void eval(List<Integer> list , Predicate<Integer> predicate){
        for (Integer n:list){
            
            if(predicate.test(n)){
                System.out.println(n + "");
            }
            
        }
    }
}
