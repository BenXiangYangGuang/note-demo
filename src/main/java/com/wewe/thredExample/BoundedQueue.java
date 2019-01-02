package com.wewe.thredExample;

import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;
import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: wewe
 * Date:  18-9-16 下午9:34
 * Description: 有界队列 示例 Condition 的使用方式
 * 队列为空时,队列的获取操作将会阻塞获取线程,直到队列中有新增元素
 * 当队列已满时,队列的插入操作将会阻塞插入线程,直到队列出现"空位"
 * Refer To:
 */
public class BoundedQueue<T> {
    private Object[] items;
    //添加的下标,删除的下标, 数组当前的数量
    private int addIndex,removeIndex,count;

    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public BoundedQueue(int size){
        items = new Object[size];
    }

    //添加一个元素,如果数组满,则添加线程进入等待状态,直到有"空位"
    public void add(T t) throws InterruptedException{
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[addIndex] = t;
            if (++addIndex == items.length)
                addIndex = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    //由头部删除一个元素,如果数组为空,则删除线程进入等待状态,直到有新添加的元素
    public T remove() throws InterruptedException{
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object x = items[removeIndex];

            if (++removeIndex == items.length)
                removeIndex = 0;
            --count;
            notFull.signal();
            return (T) x;
        } finally {
            lock.unlock();
        }
    }
}
