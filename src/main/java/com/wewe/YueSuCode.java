package com.wewe;

import java.util.*;

/**
 * Author: fei2
 * Date:  19-4-21 下午12:04
 * Description:
 * Refer To:
 */
public class YueSuCode {

    public static void testMap(){

        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map =  new HashMap<Integer,Integer>();
        String temp = sc.nextLine();
        String[] ss = temp.trim().split(" ");
        for (int i =0;i < ss.length; i++){
            if(map.get(Integer.valueOf(ss[i])) ==null){
                map.put(Integer.valueOf(ss[i]),1);
            } else {
                map.put(Integer.valueOf(ss[i]),map.get(Integer.valueOf(ss[i]))+1);
            }
        }
        Set<Integer> arrayIndexSet = new TreeSet<>();
        int k =0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue() ==1){
                for (int j = 0; j < ss.length; j++){
                    if (entry.getKey() == Integer.valueOf(ss[j])){
                        arrayIndexSet.add(j);
                        break;
                    }
                }
            } else {
                if (entry.getValue() > 1 ){
                    k ++;
                    if (k == map.size()){
                        System.out.println("empty");
                    }
                }
            }
        }
        Iterator it = arrayIndexSet.iterator();
        while(it.hasNext()){
            System.out.print(ss[(Integer) it.next()] + " ");
        }
    }
}
