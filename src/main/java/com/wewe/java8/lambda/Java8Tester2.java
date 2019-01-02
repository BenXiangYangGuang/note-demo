package com.wewe.java8.lambda;

/**
 * Created by fei2 on 2018/5/22.
 * 描述：
 */
public class Java8Tester2 {
    
    final static String salutation = "Hello!";
    
    public static void main(String[] args) {
        GreetingService greetingService1 = message -> System.out.println(salutation +message);
        greetingService1.sayMessage("Runoob");
    
    
        final int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);  // 输出结果为 3
        
    }
    
    interface GreetingService {
        void sayMessage(String message);
    }
    
    public interface Converter<T1, T2> {
        void convert(int i);
    }
}
