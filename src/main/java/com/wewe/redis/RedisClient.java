package com.wewe.redis;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.Set;

/**
 * Directions: Redis的集群连接
 * package com.zjenergy.Name: com.zjenergy.redis.
 * ProjectName: CompressData.
 * Creator: itdeer.
 * CreationTime: 2018/10/16 17:43.
 */

@Slf4j
public class RedisClient {

    private static JedisCluster jedisCluster;
    private static Set<HostAndPort> hostAndPorts_set;
    private JedisClusterPipeline jedisClusterPipeline;

    static {
        hostAndPorts_set = RedisConfig.getRedisConfig();
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMinIdle(30);
        poolConfig.setMaxIdle(100);
        poolConfig.setMaxTotal(200);
        jedisCluster = new JedisCluster(hostAndPorts_set, 3 * 60 * 1000,poolConfig);
    }

    /**
     * 获取Redis集群管道连接
     *
     * @return jedisClusterPipeline
     */
    public JedisClusterPipeline getRedisClusterPipeline() {
        return jedisClusterPipeline;
    }


    public RedisClient() {
        this.jedisClusterPipeline = new JedisClusterPipeline(jedisCluster);
        jedisClusterPipeline.refreshCluster();
    }

}
