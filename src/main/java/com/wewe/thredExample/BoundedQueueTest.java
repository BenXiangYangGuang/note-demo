package com.wewe.thredExample;


/**
 * Author: wewe
 * Date:  18-9-16 下午9:48
 * Description: 有界队列 测试
 * Refer To:
 */
public class BoundedQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BoundedQueue boundedQueue = new BoundedQueue(3);

        for (int i = 0; i < 5; i++){
            boundedQueue.add(i);
        }

    }
}
