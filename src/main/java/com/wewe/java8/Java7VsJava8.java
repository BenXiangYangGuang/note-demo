package com.wewe.java8;

import java.util.*;

/**
 * Created by fei2 on 2018/5/19.
 * 描述：http://www.runoob.com/java/java8-new-features.html
 */
public class Java7VsJava8 {
    
    public static void main(String[] args) {
    
        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");
    
        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");
    
        Java7VsJava8 tester = new Java7VsJava8();
        System.out.println("使用 Java 7 语法: ");
    
        tester.sortUsingJava7(names1);
        System.out.println(names1);
        System.out.println("使用 Java 8 语法: ");
    
        tester.sortUsingJava8(names2);
        System.out.println(names2);
    
    
        //使用Collections的sort方法，并且重写compare方法
//        listSort2();
        //a.compareTo(b) 比较字符串的Unicode值， a 大于b 返回 1；a 等于 b,返回 0；a 小于 b 返回 -1；
        String a = "1";
        String b = "2";
        String c = "3";
        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(b));
        System.out.println(c.compareTo(b));
    
    
        /**
         * Lambda表达式有返回值，返回值的类型也由编译器推理得出。
         * 如果Lambda表达式中的语句块只有一行，则可以不用使用return语句，下列两个代码片段效果相同：
         */
//        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
//            int result = e1.compareTo( e2 );
//            return result;
//        } );
        Arrays.asList( "a", "b", "d" ).sort( (e1, e2 ) -> e1.compareTo( e2 ) );
        
    }
    
    private void sortUsingJava8(List<String> names) {
        Collections.sort(names,(s1,s2) -> s1.compareTo(s2));
    }
    
    private void sortUsingJava7(List<String> names){
        
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    
    }
}
