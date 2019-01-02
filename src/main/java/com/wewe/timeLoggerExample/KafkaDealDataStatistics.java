package com.wewe.timeLoggerExample;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Author: fei2
 * Date:  2018/11/7 17:45
 * Description:kafka 处理数据统计监控
 * Refer To:
 */
public class KafkaDealDataStatistics implements Runnable {
    private KafkaDealDataIndicator kafkaDealDataIndicator;

    public KafkaDealDataStatistics(KafkaDealDataIndicator kafkaDealDataIndicator){
        this.kafkaDealDataIndicator = kafkaDealDataIndicator;
    }
    @Override
    public void run() {
        System.out.print("failure:"+kafkaDealDataIndicator.getFailureRow());
        System.out.print(" success:" + kafkaDealDataIndicator.getSuccessRow());
        System.out.print(" poll:" + kafkaDealDataIndicator.getPollDataRow());
        System.out.println();
        System.out.println("----------清空------------");
        kafkaDealDataIndicator.setFailureRow(new AtomicLong(0L));
        kafkaDealDataIndicator.setSuccessRow(new AtomicLong(0L));
        kafkaDealDataIndicator.setPollDataRow(new AtomicLong(0L));
    }
}
