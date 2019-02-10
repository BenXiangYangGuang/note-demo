package com.wewe.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: fei2
 * Date:  19-1-4 下午3:57
 * Description:
 * Refer To:
 */
public class JedisclusterTest {

    private static final int DEFAULT_TIMEOUT = 2000;
    private static final int DEFAULT_REDIRECTIONS = 5;
    private static final JedisPoolConfig DEFAULT_CONFIG = new JedisPoolConfig();

    public static JedisCluster getJc(){
        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();

        jedisClusterNode.add(new HostAndPort("172.24.4.66", 7000));
        jedisClusterNode.add(new HostAndPort("172.24.4.66", 7001));
        jedisClusterNode.add(new HostAndPort("172.24.4.66", 7002));

        JedisCluster jc = new JedisCluster(jedisClusterNode, DEFAULT_TIMEOUT, DEFAULT_TIMEOUT,
                DEFAULT_REDIRECTIONS, null, DEFAULT_CONFIG);
        return jc;
    }

    public static void testcluster(){

        JedisCluster jc = getJc();

        jc.set("testkey4", "testkey hello");
        //
//        jc.expire("testkey3", 100);
        System.out.println(jc.get("testkey4"));

        try {
            jc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testcluster();
    }
}
