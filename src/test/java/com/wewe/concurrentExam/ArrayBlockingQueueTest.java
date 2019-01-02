package com.wewe.concurrentExam;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Author: fei2
 * Date:  18-9-29 上午11:47
 * Description:
 *  blockingQueue接口提供的插入、移除方法方法都是阻塞式方法；
 *  add(O) remove(o) 抛异常：如果试图的操作无法立即执行，抛一个异常。
 *  offer(o) poll(0) 特定值：如果试图的操作无法立即执行，返回一个特定的值(常常是 true / false)。
 *  put(o) take(o) 阻塞：如果试图的操作无法立即执行，该方法调用将会发生阻塞，直到能够执行。
 *  offer(E e, long timeout, TimeUnit unit) pull(E e, long timeout, TimeUnit unit)
 *  超时：如果试图的操作无法立即执行，该方法调用将会发生阻塞，直到能够执行，但等待时间不会超过给定值。返回一个特定值以告知该操作是否成功(典型的是true / false)。
 *  多线程下应该使用take(),非poll();take 会 await(); poll() 是一直取；导致cpu使用过高。
 * Refer To:
 *  https://blog.csdn.net/chenchaofuck1/article/details/51660119
 *  https://www.jianshu.com/p/4028efdbfc35
 */
public class ArrayBlockingQueueTest {
    private ArrayBlockingQueue<Integer>  arrayBlockingQueue = null;
    @Before
    public void initArrayBlockingQueue(){

    }

    /**
     * 当插入元素个数等于余数组大小时；数组下标inputIndex = 0
     * 下标从0开始；但不会覆盖原来元素；一旦元素数组长度item.length和其中元素个数count相等时;
     * 不允许插入；直接返回false；
     */
    @Test
    public void offerElement(){
        arrayBlockingQueue = new ArrayBlockingQueue(3);
        for (int i = 0; i < 5; i++){
            arrayBlockingQueue.offer(i);
        }
    }

    /**
     * poll 从takeIndex = 0开始取出元素；并在数组中删除；
     * inputIndex 和 takeIndex 都是从0 开始，从而保证了先进先出
     */
    @Test
    public void pollElement(){
        arrayBlockingQueue = new ArrayBlockingQueue(10);
        for (int i = 0; i < 5; i++){
            arrayBlockingQueue.offer(i);
        }
        for (int i = 0; i < 6; i++){
            arrayBlockingQueue.poll();
        }
    }

    /**
     * 根据takeIndex 开始遍历元素；直到找到相等的元素；根据元素下标删除元素；
     * 删除过程中设计数组的移动；该删除元素后面的所有元素， 进行前移一位；
     */
    @Test
    public void removeElement(){
        arrayBlockingQueue = new ArrayBlockingQueue(10);
        for (int i = 0; i < 5; i++){
            arrayBlockingQueue.offer(i);
        }
        for (int i = 3; i < 7; i++){
            arrayBlockingQueue.remove(i);
        }
    }

    @Test
    public void continueAssign(){
        String a = "a";
        String b = "";
        String c = "";
        c = b = a;
        System.out.println(c);
        System.out.println(b);
    }
}
