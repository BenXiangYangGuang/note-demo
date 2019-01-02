package com.wewe.executorpool;

import java.util.LinkedList;

/**
 * Created by fei2 on 2018/5/28.
 * 描述：
 *
 * 另一个完善的参考：https://yq.aliyun.com/wenji/70129?spm=a2c4e.11155472.0.0.cf3a1d11ssmyiC
 */
public class ThreadPool {
    
    int threadPoolSize;
    
    LinkedList<Runnable> tasks = new LinkedList<Runnable>();
    
    public ThreadPool(){
        threadPoolSize = 10;
        synchronized (tasks){
            for (int i = 0 ;i < threadPoolSize ; i++){
                new TaskConsumerThread("任务消费者线程" + i).start();
            }
        }
    }
    public void add (Runnable r){
        synchronized (tasks){
            tasks.add(r);
            tasks.notifyAll();
        }
    }
    class TaskConsumerThread extends Thread{
        public TaskConsumerThread(String name){
            super(name);
        }
        
        Runnable task;
        
        public void run(){
            System.out.println("启动：" + this.getName());
            
            while (true){
                synchronized (tasks){
                    while (tasks.isEmpty()){
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = tasks.removeLast();
                    tasks.notifyAll();
                }
                System.out.println(this.getName() + "获取到任务，并执行");
                task.run();
            }
        }
    }
}
