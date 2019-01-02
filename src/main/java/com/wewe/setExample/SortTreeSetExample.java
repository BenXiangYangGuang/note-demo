package com.wewe.setExample;

import java.util.*;

/**
 * Author: fei2
 * Date:  18-9-7 下午5:55
 * Description:
 * TreeSet 的去重是根据compareTo的大小；如果相等则被判断相等；不能添加到TreeSet中去；
 * HashSet去重是根据1.hashCode;2equals 相同；equals相同，hashCode一定相同。反之不成立。
 * //https://blog.csdn.net/yxb_yingu/article/details/52194988
 * Refer To:
 */
public class SortTreeSetExample {

    public static void main(String[] args) {
        TreeSet<String[]> list = new TreeSet<String[]>(new SortComparatorExample());

        HashSet<String[]> listHash = new HashSet<>();

        String time = String.valueOf(System.currentTimeMillis());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String time2 = String.valueOf(System.currentTimeMillis());

        String[] o1 = new String[]{time, "col1", "1"};
        String[] o2 = new String[]{time, "col2", "2"};
        String[] o3 = new String[]{time, "col3", "3"};
        String[] o4 = new String[]{time2, "col1", "4"};
        String[] o5 = new String[]{time2, "col1", "5"};
        String[] o6 = new String[]{time2, "col2", "6"};
        String[] o7 = new String[]{time2, "col3", "7"};
        String[] o8 = new String[]{time2, "col3", "8"};

        list.add(o1);
        list.add(o7);
        list.add(o5);
        list.add(o3);
        list.add(o4);
        list.add(o8);
        list.add(o6);
        list.add(o2);

        listHash.add(o1);
        listHash.add(o7);
        listHash.add(o5);
        listHash.add(o3);
        listHash.add(o4);
        listHash.add(o8);
        listHash.add(o6);
        listHash.add(o2);

        for(Iterator iter = list.iterator(); iter.hasNext(); ) {
            String[] str = (String[])iter.next();
            System.out.println(str[0]+":"+str[1]+":"+str[2]);
            iter.remove();
        }

        System.out.println("--------hashSet--------");
        for (String[] object : listHash) {
            System.out.println(object[0] + ":"+object[1] + ":" + object[2]);
        }
        System.out.println(listHash.remove(o1));

        for (String[] object : listHash) {
            System.out.println(object[0] + ":"+object[1] + ":" + object[2]);
        }
    }
}
