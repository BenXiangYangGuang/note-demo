package com.wewe;

import org.junit.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: fei2
 * Date:  18-9-10 上午11:18
 * Description:
 * Refer To:
 */
public class TestMain {
    public static void main(String[] args) {
        Integer a =10;
        Integer b = new Integer(10);
        System.out.println(a.equals(b));
        System.out.println(a == b);
        int [] ab = {1,2};
        int[][] array = {{1,2,3},{4,5,6}};
        System.out.println(array.length);

        System.out.println(a.hashCode());
    }
    @Test
    public void hashMapTest(){
        HashMap<String,String> map = new HashMap<>();
        String ss = map.put("key1","value1");
        System.out.println(ss);
        String s = map.put("key2","value2");
        System.out.println(s);
        //此方法为map的hashCode(),对map中的每一个entry进行hash相加对到的值；
        map.hashCode();
        map.forEach((index,e) -> {
            System.out.println(e);
        });
        System.out.println(map.toString());
        System.out.println(map.toString().split(" ").length);

        List<String> list = new ArrayList<>();
        list.add("ad,afds");
        list.add("ade,uu");
        list.toString();
        System.out.println(list.size());
        for (int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println(list.toString());
    }
    //ConcurrentHashMap 支持一遍遍历一遍删除；HashMap不支持一遍遍历一遍删除
    @Test
    public void concurrentHashMapRemoveTest(){
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        map.put("key1","value1");
        map.put("key2","value1");
        map.put("key3","value1");
        map.put("key4","value1");

        for (Map.Entry<String,String> entry:map.entrySet()){
            if ("key1".equals(entry.getKey())){
                map.remove(entry.getKey());
            }
            if ("key2".equals(entry.getKey())){
                map.remove(entry.getKey());
            }
            for (Map.Entry<String,String> entry2:map.entrySet()){

                System.out.println(entry2.getKey());
            }

        }
        System.out.println("------------");
        for (Map.Entry<String,String> entry:map.entrySet()){

            System.out.println(entry.getKey());
        }

    }
    @Test
    public void hashMapRemoveTest(){
        HashMap<String,String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value1");
        map.put("key3","value1");
        map.put("key4","value1");

        for (Map.Entry<String,String> entry:map.entrySet()){
            if ("key1".equals(entry.getKey())){
                map.remove(entry.getKey());
            }
            if ("key2".equals(entry.getKey())){
                map.remove(entry.getKey());
            }
            System.out.println(entry.getKey());

        }
        System.out.println("------------");
        for (Map.Entry<String,String> entry:map.entrySet()){

            System.out.println(entry.getKey());
        }

    }

    /**
     * 多线程不会有代码错误
     * 存在线程安全问题
     */
    @Test
    public void TreeSetRemoveTest(){
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("key3");
        treeSet.add("key4");
        treeSet.add("key2");
        treeSet.add("key1");
        treeSet.add("key7");
        treeSet.add("key8");
        treeSet.add("key9");

        for (int i = 0; i < 4; i++){
            new Thread(){
                @Override
                public void run() {
                    treeSet.pollFirst();
                }
            }.start();
        }
        treeSet.add("key5");
        treeSet.add("key6");

        treeSet.pollFirst();
        for (String set : treeSet){
            System.out.println(set);
        }

    }

    /**
     * pollFirst()从队列中删除元素
     * first() 返回第一个元素；不删除从队列中
     */
    @Test
    public void treeSetPoll(){
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("key3");
        treeSet.add("key4");
        treeSet.add("key2");
        treeSet.add("key1");
        treeSet.add("key5");
        treeSet.add("key6");
        treeSet.add("key7");
        treeSet.add("key8");
        treeSet.add("key9");

        treeSet.pollFirst();
        treeSet.first();
        treeSet.size();
        for (String set : treeSet) {
            System.out.println(set);
        }
        System.out.println("-------------------");
        System.out.println("first");
        treeSet.first();
        for (String set : treeSet){
            System.out.println(set);
        }

    }
    @Test
    public void printColonTest(){
        String colon = ":";
        System.out.println(colon);
        System.out.print("a b c  ".replace(" ",""));
        System.out.print("sdf");
    }

    @Test
    public void newHashMapRepeatTest(){
        Map<String,Object> map = new HashMap<>();
        List<Map<String,Object>> list = new ArrayList<>();
        for (int j = 0; j < 3; j++){
            for (int i = 0; i < 5; i++){
                map.put(i+"",i+j);
            }
            list.add(map);
        }

        for (int k = 0; k < list.size(); k++){
            Map<String,Object> map2 = list.get(k);
            for (Map.Entry<String,Object> mm : map2.entrySet()){
                System.out.println(mm.getKey() +":"+ mm.getValue());
            }
        }
    }
    //同一个map的元素输出顺序一定
    @Test
    public void hashMapOrder(){
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("zhang",1);
        hashMap.put("wang",2);
        hashMap.put("li",3);
        hashMap.put("zhao",4);
        hashMap.put("sun",5);
        hashMap.put("c",6);
        hashMap.put("a",7);
        for (Map.Entry<String,Integer> entry : hashMap.entrySet()){
            System.out.println("key:" + entry.getKey() + ";value:" + entry.getValue());
        }
    }
    @Test
    public void longAndDoubleToStringTest(){
        long time = System.currentTimeMillis();

        System.out.println("long:"+time);

        double timeDouble = System.currentTimeMillis();
        System.out.println("double:" + Double.toString(timeDouble));
        System.out.println("string" + String.valueOf(timeDouble) );

        Double double1 = 123456789.123456789;
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");//格式化设置
        System.out.println(decimalFormat.format(double1));
        System.out.println(double1);
        System.out.println("-----------------");
        BigDecimal bigDecimal = new BigDecimal(Math.floor(double1));
        String result = bigDecimal.toString();
        System.out.println(result);
        System.out.println(Long.valueOf(result) instanceof Long);
        System.out.println(Long.valueOf(result).toString());

        System.out.println("-----------------");
        long first = 66L;
        System.out.println((double) first);

    }
    @Test
    public void mapToString(){
        HashMap<String,Object> hashMap = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        String str = "str";
        hashMap.put("zhang",1);
        hashMap.put("wang",2);
        hashMap.put("li",str);
        for (Map.Entry<String,Object> entry : hashMap.entrySet()){
            sb.append("key:" + entry.getKey() +" value: " + entry.getValue());
//            System.out.println("key:" + entry.getKey() +" value: " + entry.getValue());
            System.out.println(sb.toString());
        }
    }
    @Test
    public void ListMaxTest(){
        List<Long> list = new ArrayList();
        list.add(1L);
        list.add(2L);
        list.add(4L);
        System.out.println(Collections.max(list));
        System.out.println(Collections.max(list));
    }

    @Test
    public void equalsTest(){
        boolean flag = false;
        boolean flag2 = false;
        System.out.println((true == flag) == flag2);
    }

    @Test
    public void testSwitchTest(){
        int i = 1;
        switch(i) {
            case 0:
                System.out.println("0");
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3");
            default:
                System.out.println("default");
        }
    }

    @Test
    public void printList(){
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(8);
        list.add(5);
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }




}
