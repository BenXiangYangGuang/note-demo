package com.wewe.setExample;

import java.util.LinkedList;

/**
 * Author: fei2
 * Date:  18-10-10 上午9:09
 * Description:
 * Refer To:
 */
public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10 ; i++){
            //在队列尾部插入元素
            linkedList.offer(i);
        }
        for (int j = 0; j < 3; j++){
            //队列头部得到元素，并不移除元素
            linkedList.peek();
        }
        for (Integer integer :linkedList){
            System.out.println(integer);
        }
        for (int j = 0; j < 3; j++){
            //队列头部得到元素，移除元素
            linkedList.pop();
        }
        for (Integer integer :linkedList){
            System.out.println(integer);
        }

    }
}
