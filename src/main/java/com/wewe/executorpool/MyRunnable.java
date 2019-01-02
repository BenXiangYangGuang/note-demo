package com.wewe.executorpool;

import lombok.extern.slf4j.Slf4j;
import com.wewe.spring.bean.utils.SpringContextUtil;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * Created by fei2 on 2018/5/29.
 * 描述：
 */
@Slf4j
public class MyRunnable implements Runnable {
    
    private KafkaConsumer<Integer, String> consumer;
    
    public static volatile boolean flag = true;
    
    public boolean isFlag() {
        return flag;
    }
    
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
   
    public void sayHello(){
        System.out.println("----------hello------------------");
    }
    
    @Override
    public void run() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
    
        props.put("auto.commit.interval.ms", "1000");

//        props.put("linger.ms", 1); // it will failed when set this to 10000.
    
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("Suct_Data"));
    
        collectData();
    }
    public void collectData(){
        
        
            while (true) {
                if(flag){
                    ConsumerRecords<Integer, String> records = consumer.poll(100);
                    try {
                        Thread.sleep(1000);
                        
                        for (ConsumerRecord<Integer, String> record : records) {
                            log.info("Received message: (" + record.value() + ")   offset:" + record.offset());
                            System.out.println("Received message: (" + record.value() + ")   offset:" + record.offset());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("----------flag 为false---------------");
                    System.out.println("------------------flag 为false---------------------------");
                }
    
    
            }
       
        
    }
}
