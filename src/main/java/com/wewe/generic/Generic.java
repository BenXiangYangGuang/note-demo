package com.wewe.generic;

/**
 * Created by fei2 on 2018/5/9.
 * 泛型类
 * 参考：https://blog.csdn.net/s10461/article/details/53941091
 * 泛型上下界： https://www.cnblogs.com/drizzlewithwind/p/6100164.html
 *
 * Plate< ? extends Fruit > 上届通配符，盛放Fruit 和 继承Fruit 的子类。啥水果（苹果和梨）都能放的盘子
 * Plate< ? super Fruit   > 下届通配符，盛放Fruit 和 Fruit 继承的夫类
 *
 */
public class Generic<T> {
    
    private T key;
    
    public Generic(T key){
        this.key = key;
    }
    
    public T getKey(){
        return key;
    }
    
    public static void main(String[] args) {
        
        Generic<Integer> genericInteger = new Generic<Integer>(123456);
        
        Generic<String> genericString = new Generic<String>("key_value");
        
        System.out.println(genericInteger.getKey());
        
        System.out.println(genericString.getKey());
        
        Generic generic = new Generic("1111");
        
        System.out.println(generic.getKey());
    
        Generic<String> generic1 = new Generic<String>("11111");
        Generic<Integer> generic2 = new Generic<Integer>(2222);
        Generic<Float> generic3 = new Generic<Float>(2.4f);
        Generic<Double> generic4 = new Generic<Double>(2.56);
        
        //这一行代码编译器会提示错误，因为String类型并不是Number类型的子类
        //showKeyValue1(generic1);
    
        showKeyValue1(generic2);
        showKeyValue1(generic3);
        showKeyValue1(generic4);
        
    }
    
    public static void showKeyValue1(Generic<? extends Number> obj){
        System.out.println("key value is " + obj.getKey());
    }

}
