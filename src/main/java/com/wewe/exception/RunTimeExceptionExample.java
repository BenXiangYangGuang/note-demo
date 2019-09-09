package com.wewe.exception;

/**
 * RuntimeException 可以不被 try catch 捕获
 * @author zhangpanwei@motie.com
 * @create 2019-09-09 13:52
 **/
public class RunTimeExceptionExample {
    public static void main(String[] args) {

        try {
            testException();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("return main method");
    }

    public static void testException() throws RuntimeException{
        for (int i = 0; i < 10 ; i++){
            if (i == 3) {
                throw new RuntimeException("error");
            }

            System.out.println(i);
        }
    }
}
