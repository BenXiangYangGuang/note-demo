package com.wewe.generic.genericmethod2;

/**
 * Author: fei2
 * Date:  18-9-27 上午10:54
 * Description: 实现接口中的泛型方法；泛型方法的具体类型；由调用泛型方法时决定
 * Refer To:
 */
interface DemoI {
    <T> T fun(T str);
}
class Demo implements DemoI{
    //自己的泛型方法
    public <T> T fun2(T t){			// 可以接收任意类型的数据
        return t ;					// 直接把参数返回
    }
    //实现接口的泛型方法
    @Override
    public <T> T fun(T str) {
        return str;
    }
}
class GenericsDemo26{
    public static void main(String args[]){
        Demo d = new Demo()	;	// 实例化Demo对象
        String str = d.fun("李兴华") ; //	传递字符串
        int i = d.fun(30) ;		// 传递数字，自动装箱
        System.out.println(str) ;	// 输出内容
        System.out.println(i) ;		// 输出内容

        String str2 = d.fun2("李兴华") ; //	传递字符串
        int i2 = d.fun2(30) ;		// 传递数字，自动装箱
        System.out.println(str2) ;	// 输出内容
        System.out.println(i2) ;		// 输出内容
    }
}

