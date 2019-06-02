package com.wewe.setExample;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author: fei2
 * Date:  19-6-1 下午11:53
 * Description:基于LinkedList的LRU简单实现
 * Refer To:https://segmentfault.com/a/1190000012964859
 */
public class SimpleCache<K, V> extends LinkedHashMap<K, V> {

    private static final int MAX_NODE_NUM = 100;

    private int limit;

    public SimpleCache() {
        this(MAX_NODE_NUM);
    }

    public SimpleCache(int limit) {
        //指定 accessOrder 参数为 true，即可让它按访问顺序维护链表
        super(limit, 0.75f, true);
        this.limit = limit;
    }

    public V save(K key, V val) {
        return put(key, val);
    }

    public V getOne(K key) {
        return get(key);
    }

    public boolean exists(K key) {
        return containsKey(key);
    }

    /**
     * 判断节点数是否超限
     * @param eldest
     * @return 超限返回 true，否则返回 false
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limit;
    }
}