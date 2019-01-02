package com.wewe.thredExample;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Author: wewe
 * Date:  18-9-16 下午9:26
 * Description: 缓存示例 说明读写锁的使用方式
 * Refer To:
 */
public class Cache {
    static Map<String,Object> map = new HashMap<String,Object>();

    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    static Lock r = rwl.readLock();

    static Lock w = rwl.writeLock();
    //获取一个key值对应的value
    public static final Object get(String key){
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }
    //设置key对应的value,并返回旧的value
    public static final Object put(String key,Object value){
        w.lock();
        try {
            return  map.put(key,value);
        } finally {
            w.unlock();
        }
    }

    //清空所有内容
    public static final void clear(){
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }
}
