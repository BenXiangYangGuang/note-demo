package com.wewe.blockingQueueExample;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Author: fei2
 * Date:  18-9-30 上午10:32
 * Description: DelayQueue 应用场景 具有过期时间的缓存 还包括关闭数据库空闲连接；超市任务处理；缓存对象过期
 * Refer To:http://www.cnblogs.com/sunzhenchao/p/3515085.html
 */

/**
 * ConcurrentHashMap作为存储元素的容器
 * Cache是一个守护线程；只需要时时刻刻检查是否有出队列元素(到达过期时间，自动出对)
 * DelayQueue 是存储元素的key队列；到达过期时间自动出队列
 */
public class Cache<K, V> {

    public ConcurrentHashMap<K, V> map = new ConcurrentHashMap<K, V>();
    public DelayQueue<DelayedItem<K>> queue = new DelayQueue<DelayedItem<K>>();


    public void put(K k,V v,long liveTime){
        V v2 = map.put(k, v);
        DelayedItem<K> tmpItem = new DelayedItem<K>(k, liveTime);
        if (v2 != null) {
            queue.remove(tmpItem);
        }
        queue.put(tmpItem);
    }

    public Cache(){
        Thread t = new Thread(){
            @Override
            public void run(){
                try {
                    daemonCheckOverDueKey();
                } catch (InterruptedException e) {
                    //TODO
                    e.printStackTrace();
                }
            }
        };
        t.setDaemon(true);
        t.start();
    }

    public void daemonCheckOverDueKey() throws InterruptedException {
        while (true) {
            DelayedItem<K> delayedItem = queue.take();
            if (delayedItem != null) {
                map.remove(delayedItem.getT());
                System.out.println("liveTime:"+delayedItem.getLiveTime()+"  removeTime:"+delayedItem.getRemoveTime()+" remove "+delayedItem.getT() +" from cache");
            }
            try {
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    /**
     * TODO
     * @param args
     * 2014-1-11 上午11:30:36
     * @author:孙振超
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int cacheNumber = 10;
        int liveTime = 0;
        Cache<String, Integer> cache = new Cache<String, Integer>();

        for (int i = 0; i < cacheNumber; i++) {
            liveTime = random.nextInt(3000000);
            System.out.println(i+"  "+liveTime);
            cache.put(i+"", i, random.nextInt(liveTime));
        }

        Thread.sleep(30000);
        System.out.println();
    }

}

class DelayedItem<T> implements Delayed {

    private T t;
    private long liveTime ;
    private long removeTime;

    public DelayedItem(T t,long liveTime){
        this.setT(t);
        this.liveTime = liveTime;
        this.removeTime = TimeUnit.NANOSECONDS.convert(liveTime, TimeUnit.NANOSECONDS) + System.nanoTime();
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == null) return 1;
        if (o == this) return  0;
        long diff = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return diff > 0 ? 1:diff == 0? 0:-1;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(removeTime - System.nanoTime(), unit);
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public long getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(long liveTime) {
        this.liveTime = liveTime;
    }

    public long getRemoveTime() {
        return removeTime;
    }

    public void setRemoveTime(long removeTime) {
        this.removeTime = removeTime;
    }
}
