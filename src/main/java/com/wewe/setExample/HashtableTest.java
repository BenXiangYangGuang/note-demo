package com.wewe.setExample;

import java.util.*;

/**
 1) HashMap和Hashtable的效率大致相同，因为它们的实现机制几乎完全一样。但HashMap通常比Hashtable要快一点，因为Hashtable需要额外的线程同步控制
 2) TreeMap通常比HashMap、Hashtable要慢(尤其是在插入、删除key-value对时更慢)，因为TreeMap底层采用红黑树来管理key-value对
 3) 使用TreeMap的一个好处就是： TreeMap中的key-value对总是处于有序状态，无须专门进行排序操作

 */
class AA {
    int count;

    public AA(int count) {
        this.count = count;
    }

    //根据count的值来判断两个对象是否相等。
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj != null &&
                obj.getClass() == AA.class) {
            AA a = (AA) obj;
            return this.count == a.count;
        }
        return false;
    }

    //根据count来计算hashCode值。
    public int hashCode() {
        return this.count;
    }
}

class BB {
    //重写equals()方法，B对象与任何对象通过equals()方法比较都相等
    public boolean equals(Object obj) {
        return true;
    }
}

public class HashtableTest {
    public static void main(String[] args) {
        Hashtable ht = new Hashtable();
        ht.put(new AA(60000), "疯狂Java讲义");
        ht.put(new AA(87563), "轻量级Java EE企业应用实战");
        ht.put(new AA(1232), new BB());
        System.out.println(ht);

        //只要两个对象通过equals比较返回true，
        //Hashtable就认为它们是相等的value。
        //由于Hashtable中有一个B对象，
        //它与任何对象通过equals比较都相等，所以下面输出true。
        System.out.println(ht.containsValue("测试字符串"));  //①

        //只要两个A对象的count相等，它们通过equals比较返回true，且hashCode相等
        //Hashtable即认为它们是相同的key，所以下面输出true。
        System.out.println(ht.containsKey(new AA(87563)));   //②

        //下面语句可以删除最后一个key-value对
        ht.remove(new AA(1232));    //③

        //通过返回Hashtable的所有key组成的Set集合，
        //从而遍历Hashtable每个key-value对
        for (Object key : ht.keySet()) {
            System.out.print(key + "---->");
            System.out.print(ht.get(key) + "\n");
        }
    }
}