package com.wewe;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: fei2
 * Date:  18-8-31 上午9:34
 * Description:
 * Refer To:
 */
public class ListTestExample {

    @Test
    public void testLinkedListTraTraverseRemove(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("111");
        linkedList.add("222");
        linkedList.add("333");
        linkedList.add("444");
        // remove element output error print 111 333 444
        //index = 1 delete;list move   222(0) 333(1) 444(4)
        for (int i = 0; i < linkedList.size(); i++){
            System.out.println(linkedList.get(i));
            if (i ==  0){
                linkedList.remove("111");
            }
        }

        System.out.println("--删除数据之后：");
        for (int i = 0; i < linkedList.size(); i++){
            System.out.println(linkedList.get(i));
        }
    }

    // iterator is not suitable remove
    // it.next() index next;not recover
    @Test
    public void testLinkedListTraTraverseRemoveIterator(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("111");
        linkedList.add("222");
        linkedList.add("333");
        linkedList.add("444");

        Iterator it = linkedList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            if (it.next().equals("222"))
                it.remove();
        }

        System.out.println("--删除数据之后：");
        for (int i = 0; i < linkedList.size(); i++){
            System.out.println(linkedList.get(i));
        }
    }

    @Test
    public void testLinkedListTraTraverseRemoveAll(){
        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("111");
        linkedList.add("222");
        linkedList.add("333");
        linkedList.add("444");

        //移除的对象不能是他本身的子集
        LinkedList<String> linkedList2 = new LinkedList();
        linkedList2.add("111");
        linkedList2.add("222");
        linkedList.removeAll(linkedList2);

        System.out.println("--删除数据之后：");
        for (int i = 0; i < linkedList.size(); i++){
            System.out.println(linkedList.get(i));
        }
    }
}


