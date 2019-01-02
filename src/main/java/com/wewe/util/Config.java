package com.bigdata.common;


import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public enum Config {
    INSTANCE;

    private Lock lock = new ReentrantLock();
    private boolean init = false;
    private Properties props = null;

    public String get(String key) {
        return props.getProperty(key);
    }

    public String get(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }

    public void init(Properties props) {
        if (this.init) {
            return;
        }
        lock.lock();
        try {
            if (!init) {
                this.props = props;
                this.init = true;
            }
        } finally {
            lock.unlock();
        }
    }
}
