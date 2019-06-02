package com.wewe.timeLoggerExample;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Author: fei2
 * Date:  2018/11/7 17:12
 * Description: 定时日志
 * Refer To:
 */
public class DemoExample {
    public static void main(String[] args) {

        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);

        KafkaDealDataIndicator kafkaDealDataIndicator = new KafkaDealDataIndicator(new AtomicLong(0L),new AtomicLong(0L),new AtomicLong(0L));
       /* AtomicLong atomicLong = new AtomicLong(0L);
        kafkaDealDataIndicator.setFailureRow(atomicLong);
        kafkaDealDataIndicator.setPollDataRow(atomicLong);
        kafkaDealDataIndicator.setSuccessRow(atomicLong);*/


        executor.scheduleAtFixedRate(new KafkaDealDataStatistics(kafkaDealDataIndicator) , 0,2 , TimeUnit.SECONDS);
        GroupKafka groupKafka = new GroupKafka(kafkaDealDataIndicator);
        groupKafka.increase();
   /*     try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
*/

    }
}
