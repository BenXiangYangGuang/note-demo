package com.wewe.masterworker;

/**
 * Author: fei2
 * Date:  19-3-11 上午10:37
 * Description:
 * Refer To:
 */
import java.util.Map;
import java.util.Queue;

public class Worker implements Runnable {

    protected Queue<Object> workQueue = null;

    protected Map<String, Object> resultMap = null;


    public void setWorkQueue(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }


    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }


    public Object handle(Object input){
        return input;
    }


    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true){
            Object  input = workQueue.poll();
            if(input == null) break;

            Object re = handle(input);

            resultMap.put(Integer.toString(input.hashCode()), re);
        }
    }

}

