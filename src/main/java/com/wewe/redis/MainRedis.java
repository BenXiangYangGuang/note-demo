package com.wewe.redis;

import java.util.List;

/**
 * Author: fei2
 * Date:  19-1-4 下午3:48
 * Description:
 * Refer To:
 */
public class MainRedis {
    public static void main(String[] args) {
        JedisClusterPipeline jedisClusterPipeline = new RedisClient().getRedisClusterPipeline();
        for (int i = 0; i < 10; i++){
            jedisClusterPipeline.set("name"+i,"value"+i);
        }
        jedisClusterPipeline.sync();
        for (int i = 0; i < 10; i++){
            jedisClusterPipeline.get("name"+i);
        }
        List<Object> batchResult = jedisClusterPipeline.syncAndReturnAll();
        for (int i = 0; i < 10; i++){
            System.out.println(batchResult.get(i));
        }
    }
}
