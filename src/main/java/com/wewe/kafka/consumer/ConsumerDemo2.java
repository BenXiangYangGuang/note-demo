package com.wewe.kafka.consumer;

import com.wewe.kafka.configure.KafkaProperties;
import com.wewe.kafka.configure.KafkaProperties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * Created by fei2 on 2018/6/4.
 * 描述：
 */
public class ConsumerDemo2 {
    public static void main(String[] args) {
        startConsumer();
    }
    public static void  startConsumer(){
        KafkaConsumer<Integer,String> consumer;
        Properties props = new Properties();
    
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test2");
        props.put(ConsumerConfig.CLIENT_ID_CONFIG,"clientId");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
    
        props.put("auto.commit.interval.ms", "1000");
    
        props.put("linger.ms", 1); // it will failed when set this to 10000.
    
    
        consumer = new KafkaConsumer<>(props);
        
        consumer.subscribe(Collections.singletonList(KafkaProperties.TOPIC_a));
        
        System.out.println("" + consumer.listTopics().toString());
    
        while (true) {
            ConsumerRecords<Integer, String> records = consumer.poll(10);
//            System.out.println(records.count());
            try {
                Thread.sleep(500);
                System.out.println("Received message:");
                for (ConsumerRecord<Integer, String> record : records) {
                    System.out.println("-----------------2----------------------");
                    System.out.println("Received message: (" + record.key() + " : " + record.value() + ") at offset " + record.offset());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
        }
    }
}
