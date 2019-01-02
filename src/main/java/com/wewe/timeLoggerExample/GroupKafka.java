package com.wewe.timeLoggerExample;

/**
 * Author: fei2
 * Date:  2018/11/7 17:51
 * Description:
 * Refer To:
 */
public class GroupKafka {
    private KafkaDealDataIndicator kafkaDealDataIndicator;
    public GroupKafka(KafkaDealDataIndicator kafkaDealDataIndicator){
        this.kafkaDealDataIndicator = kafkaDealDataIndicator;
    }

    public void increase(){
        for (int i = 0; i < 10; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0 ; j < 5; j++){
                        kafkaDealDataIndicator.getFailureRow().incrementAndGet();
                    }
                    for (int j = 0 ; j < 7; j++){
                        kafkaDealDataIndicator.getPollDataRow().incrementAndGet();
                    }
                    for (int j = 0 ; j < 7; j++){
                        kafkaDealDataIndicator.getSuccessRow().incrementAndGet();
                    }
                    /*System.out.print("failure:" + kafkaDealDataIndicator.getFailureRow());
                    System.out.print(" success:" + kafkaDealDataIndicator.getSuccessRow());
                    System.out.print(" poll:" + kafkaDealDataIndicator.getPollDataRow());
                    System.out.println();*/
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0 ; j < 5; j++){
                        kafkaDealDataIndicator.getFailureRow().incrementAndGet();
                    }
                    for (int j = 0 ; j < 7; j++){
                        kafkaDealDataIndicator.getPollDataRow().incrementAndGet();
                    }
                    for (int j = 0 ; j < 7; j++){
                        kafkaDealDataIndicator.getSuccessRow().incrementAndGet();
                    }
                }
            });
            thread.start();
        }

    }
}
