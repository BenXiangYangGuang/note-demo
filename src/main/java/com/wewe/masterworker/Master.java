package com.wewe.masterworker;

/**
 * Author: fei2
 * Date:  19-3-11 上午10:32
 * Description:
 * Refer To:
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {

    // worker的任务队列
    protected Queue<Object> workQueue = new ConcurrentLinkedQueue<Object>();

    // worker进程队列
    protected Map<String, Thread> threadMap = new HashMap<String, Thread>();

    //
    protected Map<String, Object> resultMap = new HashMap<String, Object>();

    // 是否所有的子任务都结束了
    public boolean isComplete(){
        for(Map.Entry<String, Thread> entry : threadMap.entrySet()){
            if(entry.getValue().getState() != Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }

    public Master(Worker worker, int countWorker){
        worker.setWorkQueue(workQueue);
        worker.setResultMap(resultMap);

        for(int i = 0; i < countWorker; i++){
            threadMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
        }
    }


    public void submit(Object job){
        workQueue.add(job);
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }


    public void execute(){
        for(Map.Entry<String, Thread> entry : threadMap.entrySet()){
            entry.getValue().start();
        }
    }

}
