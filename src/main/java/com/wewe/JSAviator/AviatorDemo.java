package com.wewe.JSAviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.junit.Assert;
import org.junit.Test;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fei2 on 2018/5/21.
 * 描述：
 * https://www.cnblogs.com/csguo/p/7614893.html
 */
public class AviatorDemo {
    public static void main(String[] args) {
        String expression = " a + b +c ";
        Map<String,Object> params = new HashMap<>();
        params.put("a",1);
        params.put("b",2);
        params.put("c",3);
        
        long result = (long) AviatorEvaluator.execute(expression,params);
        
        System.out.println("result :" + result);
        
        //表达式：进行过滤
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("email", "killme2008@gmail.com");
        String username = (String) AviatorEvaluator.execute("email=~/([\\w0-8]+)@\\w+[\\.\\w+]+/ ? $1:'unknow'", env);
        
        System.out.println("username :" + username);

//        emptyExpression();
        testStringBigger();
    }
    // Blank expression 表达式为空报错
    public static void emptyExpression(){
        String expression = "";
        Map<String,Object> params = new HashMap<>();
        params.put("a",100);

        boolean result = (boolean) AviatorEvaluator.execute(expression);

        System.out.println("result :" + result);
    }
    //测试String类型能比较大小吗;不能
    public static void testStringBigger(){
        String expression = " a > 10 ";
        Map<String,Object> params = new HashMap<>();
        params.put("a",100);

        boolean result = (boolean) AviatorEvaluator.execute(expression,params);

        System.out.println("result :" + result);
    }

    @Test
    public void testRegular(){
        Pattern pattern = Pattern.compile("^-?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0)$");
        Matcher matcher = pattern.matcher("-12.213");
        boolean b= matcher.matches();
        Assert.assertEquals(true,b);
    }

    /**
     * long 类型数据进行计算；输出结果只会是long类型,内部强制转换为long
     */
    @Test
    public void LongTest(){
        HashMap<String,Object> hashMap = new HashMap<>();
        String aa = "1";
        String bb = "2";
        hashMap.put("col1",aa);
        hashMap.put("col2",bb);
        Expression expr = AviatorEvaluator.compile("col1 + col2",true);
        Object o = expr.execute(hashMap);
        System.out.println(o);
        Object result = AviatorEvaluator.execute("1+2+3");
        System.out.println(result instanceof Long);


        System.out.println("-------------------");
        long time = System.currentTimeMillis();
        hashMap.put("col3",1026783637646L);
        hashMap.put("col4",1026783637646L);
        Expression expr2 = AviatorEvaluator.compile("(col3 + col4)/3");
        Object re2 = expr2.execute(hashMap);
        System.out.println(re2);
        System.out.println(re2 instanceof Long);
        System.out.println(re2 instanceof Double);
        System.out.println("-------------------");
        long ll = 5L;
        System.out.println(ll /2);

        System.out.println("-------------------");
        long l2 = 6L;


        System.out.println("-----------------");
        String name = "dennis";
        System.out.println(AviatorEvaluator.exec(" ss + xx ", ll,l2)); // hello dennis
        //字符串变成数字，是通过进制数和每一个字符串的数组进行操作的
        String str = "12";
        Long.parseLong(str);

        double timeDouble = 1026783637646D;
        BigDecimal bigDecimal = new BigDecimal(timeDouble);
        String result2 = bigDecimal.toString();
        System.out.println(Long.parseLong(result2));

    }

}
