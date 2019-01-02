package com.wewe.kafka.producer;

import com.wewe.kafka.configure.KafkaProperties;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by fei2 on 2018/6/4.
 * 描述：kafka producer
 */
public class ProducerDemo extends Thread{
    
    private final KafkaProducer<Integer,String> producer;
    private final String topic;
    private final Boolean isAsync;
    
    public static void main(String[] args) {
        new ProducerDemo(KafkaProperties.TOPIC_a,true).start();
    }
    
    public ProducerDemo(String topic,Boolean isAsync){
        Properties props = new Properties();
        props.put("bootstrap.servers", KafkaProperties.BOOTSTRAP_SERVERS);
        props.put("client.id", "DemoProducer");
        props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    
        props.put("acks", "all");
        props.put("retries", 3);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1); // it will failed when set this to 10000.
        props.put("buffer.memory", 133333);
//        props.put("advertised.host.name", "172.24.4.184");
//        props.put("advertised.port", "9092");
    
        producer = new KafkaProducer<>(props);
        System.out.println(producer.partitionsFor(topic)
            + "\n" + producer.metrics().toString());
        this.topic = topic;
        this.isAsync = isAsync;
    }
    
    @Override
    public void run() {
        Random ran1 = new Random();
        int key = 1;
        
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            String value = "Suct_Pres_Status=" +ran1.nextInt(100)+"";
            long startTime = System.currentTimeMillis();
            //异步发送
            if(isAsync){
                System.out.println("send message :" +key + ":" +value);
                producer.send(new ProducerRecord<Integer, String>(topic,key,value),new DemoCallBack(startTime,key,value));
            }else {
                System.out.println("send message : key :" + key + " value : " + value);
                Future<RecordMetadata> a = producer.send(new ProducerRecord<Integer, String>(topic,key,value));
                try {
                    Thread.sleep(1000);
                    key++;
                    //发送数据成功
                    System.out.println(a.isDone() + ", topic = " + a.get().topic() + ", partition = " + a.get().partition() + " offset = " + a.get().offset());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
    
            }
        }
        
    }
    class DemoCallBack implements Callback{
        private final long startTime;
        private final int key;
        private final String message;
        
        
        @Override
        public void onCompletion(RecordMetadata metadata, Exception exception) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            if(metadata != null){
                //发送消息成功
                System.out.println("message( " +key + "," + message + " ) send to partition ( " + metadata.partition() + " ), " + "offset ( " + metadata.offset() + " ) in " +elapsedTime + "ms");
            }else {
                exception.printStackTrace();
            }
        }
        
        public DemoCallBack(long startTime,int key, String message){
            this.startTime = startTime;
            this.key = key;
            this.message = message;
        }
    }
}
