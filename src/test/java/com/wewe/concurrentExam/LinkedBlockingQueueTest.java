package com.wewe.concurrentExam;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author: fei2
 * Date:  18-9-29 下午2:52
 * Description:
 * Refer To:
 */
public class LinkedBlockingQueueTest {

    private LinkedBlockingQueue linkedBlockingQueue;

    @Before
    public void initQueue(){
        linkedBlockingQueue = new LinkedBlockingQueue();
    }

    /**
     * last = last.next = new Node<E>(x);
     * 封装新节点，并赋给当前的最后一个节点的下一个节点，然后在将这个节点设为最后一个节点
     */

    @Test
    public void offerElement(){
        for (int i = 2; i < 5; i++){
            linkedBlockingQueue.offer(i);
        }
    }
    @Test
    public void pollElement(){

        for (int i = 2; i < 5; i++){
            linkedBlockingQueue.offer(i);
        }
        for (int i = 2; i < 7; i++){
            linkedBlockingQueue.poll();
        }
    }
}
