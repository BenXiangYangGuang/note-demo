package com.wewe.threadArt.threadpoolExample;

/**
 * Author: fei2
 * Date:  19-5-21 下午5:53
 * Description:
 * Refer To:
 */
public interface ThreadPool<Job extends Runnable> {

    void execute(Job job);

    void shutdown();

    void addWorkers(int num);

    void removeWorker(int num);

    int getJobSize();
}
