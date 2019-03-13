package com.wewe.masterworker;

/**
 * Author: fei2
 * Date:  19-3-11 上午10:37
 * Description:
 * Refer To:
 */
public class PlusWorker extends Worker{
    public Object handle(Object input){
        Integer i = (Integer)input;
        return i * i * i;
    }

}
