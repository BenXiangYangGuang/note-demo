package com.wewe.java8.lambda;

/**
 * Created by fei2 on 2018/5/22.
 * 描述：
 */
public class Java8Tester {
    
    public static void main(String[] args) {
        Java8Tester tester = new Java8Tester();
        
        MathOperation addition = (int a, int b) -> a+b;
        
        MathOperation subtraction = (a,b) -> a - b;
        
        MathOperation multiplication = (int a, int b) -> {return a * b;};
        
        MathOperation division = (int a, int b) -> a/b;
        
        System.out.println("10+5 = " + tester.operation(10,5,addition));
        System.out.println("10-5 = " + tester.operation(10,5,subtraction));
        System.out.println("10*5 = " + tester.operation(10,5,multiplication));
        System.out.println("10/5 = " + tester.operation(10,5,division));
        
        GreetingService greetingService1 = message -> System.out.println("Hello " + message);
        
        GreetingService greetingService2 = (message) -> System.out.println("Hello " +message);
    
        greetingService1.sayMessage("Runoob");
        greetingService2.sayMessage("Google");
        
    }
    
    interface MathOperation {
        int operation (int a, int b);
    }
    
    interface GreetingService {
        void sayMessage(String message4);
    }
    
    private int operation(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }
}
