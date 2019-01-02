package com.wewe.gengeral;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by fei2 on 2018/5/29.
 * 描述：
 * 参考：https://blog.csdn.net/yang_yang_6666/article/details/77186106
 * ComputeIfAbsent: https://www.cnblogs.com/CarpenterLee/p/6507161.html
 */
public class ComputeIfAbsentDemo {
    
    static Map<Integer,Integer> cache = new ConcurrentHashMap<>();
    
    public static void main(String[] args) throws InterruptedException {
        cache.put(0,0);
        cache.put(1,1);
        
        //普通方法
        System.out.println("Fibonacci(7) = " + fibonacci(7));
        //采用java7的同步线程及java8的本地缓存方式
        System.out.println("FibonacciJava8(7) = " + fibonacciJava8(7));
        System.out.println("FibonacciJava7(7) = " + fibonacciJava7(7));
    
        /**
         *
         Map<Integer, Set<String>> map = new HashMap<>();
         // Java7及以前的实现方式
         if(map.containsKey(1)){
         map.get(1).add("one");
         }else{
         Set<String> valueSet = new HashSet<String>();
         valueSet.add("one");
         map.put(1, valueSet);
         }
         // Java8的实现方式
         map.computeIfAbsent(1, v -> new HashSet<String>()).add("yi");
         使用computeIfAbsent()将条件判断和添加操作合二为一，使代码更加简洁．
         
         *
         */
    
    
    
        Map<String,HashSet<String>> map1 = new HashMap<>();
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("apple");
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("orange");
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("pear");
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("banana");
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("water");
        System.out.println(map1);
        
        
        
        Map<String,String> map2 = new ConcurrentHashMap<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        
        for (int i =0 ; i < 5; i++){
            exec.execute(()->{
                map2.computeIfAbsent("name",k -> genValue2(k));
                map2.computeIfAbsent("addr",k -> genValue2(k));
                map2.computeIfAbsent("email",k -> genValue2(k));
                map2.computeIfAbsent("mobile",k -> genValue2(k));
            });
        }
        
        exec.shutdown();
        exec.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(map2);
        
    }
    static HashSet<String> genValue(String str){
        return new HashSet<String>();
    }
    static String genValue2(String str){
        System.out.println("===");
        return str + "2";
    }
    
    static int fibonacci(int n){
        if(n == 0 || n ==1)
            return n;
        
        System.out.println("calculatin Fibonacci("+ n +")");
        return fibonacci(n -2 ) + fibonacci( n - 1);
    }
    
    static int fibonacciJava8(int n){
        return cache.computeIfAbsent(n,(key) -> {
            System.out.println("calculating FibonacciJava8" + n);
            return fibonacciJava8(n -2 ) + fibonacciJava8(n -1 );
        });
    }
    
    static int fibonacciJava7(int n){
        if(n==0 || n == 1){
            return n;
        }
        
        Integer result = cache.get(n);
        
        if(result == null){
            synchronized (cache){
                result = cache.get(n);
                
                if (result == null){
                    System.out.println("calculating FibonacciJava7("+ n +")");
                    result = fibonacciJava7( n -2 )+ fibonacciJava7( n -1);
                    cache.put(n,result);
                }
            }
        }
        return result;
    }
}
