package com.wewe.masterworker;

import java.util.Map;
import java.util.Set;

/**
 * Author: fei2
 * Date:  19-3-11 上午10:38
 * Description:
 * Refer To:https://blog.csdn.net/zmx729618/article/details/78499285
 */
public class Main {
    /**
     * 一个master拥有一个任务队列,和一个结果集,还有维护了一个存储worker线程的map;
     * 只有同一种类型的任务,所以需要相同的一个worker,5个线程,每个线程包含的worker是一样的;
     * worker引用master的任务队列,从里面取出任务进行计算;然后将结果存入,master的结果集;
     * 最后,当结果集为空 或者 所有的线程结束为止,期间master一直汇总各个worker产生的结果;
     */

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Master m = new Master(new PlusWorker(), 5);
        for(int i = 0; i < 10; i++){
            m.submit(i);
        }

        m.execute();

        int ret = 0;

        Map<String, Object> resultMap =m.getResultMap();

        while(resultMap.size() > 0 || !m.isComplete()){

            Set<String> keys = resultMap.keySet();

            String key = null;
            for(String k : keys){
                key = k;
                break;
            }

            Integer i = null;

            if(key != null){
                i = (Integer)resultMap.get(key);

                if(i != null) ret += i;

                resultMap.remove(key);
            }

        }

        System.out.println("ret = " + ret);

    }
}
