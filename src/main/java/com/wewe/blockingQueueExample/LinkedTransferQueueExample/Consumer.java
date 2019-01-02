package com.wewe.blockingQueueExample.LinkedTransferQueueExample;

import java.util.concurrent.TransferQueue;

/**
 * Author: fei2
 * Date:  18-10-8 下午7:37
 * Description:
 * Refer To:
 */
public class Consumer implements Runnable {
    private final TransferQueue<String> queue;

    public Consumer(TransferQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(" Consumer " + Thread.currentThread().getName()
                    + queue.take());
        } catch (InterruptedException e) {
        }
    }
}
