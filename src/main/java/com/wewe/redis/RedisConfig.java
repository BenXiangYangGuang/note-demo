package com.wewe.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.HostAndPort;

import java.util.HashSet;
import java.util.Set;


@Slf4j
public class RedisConfig {

    private static Set<HostAndPort> hostAndPorts_set = new HashSet();

    /**
     * 加载Redis的配置 解析Redis的配置信息设置集群信息
     *
     * @return 返回HostAndPort的集合
     */
    public static Set<HostAndPort> getRedisConfig() {
        try {
            String hosts = "[172.24.4.66,7000],[172.24.4.66,7001],[172.24.4.66,7002]";
            if (!hosts.endsWith(",")) {
                hosts = hosts + ",";
            }
            String[] hosts_split = hosts.split("],");
            for (int i = 0; i < hosts_split.length; i++) {
                String host = hosts_split[i].substring(1, hosts_split[i].length());
                hostAndPorts_set.add(new HostAndPort(host.split(",")[0], Integer.parseInt(host.split(",")[1])));
            }
            log.info("resolver config message setup redis hostAndPorts finish");
        } catch (Exception e) {
            log.error("resolver config message setup redis hostAndPorts appear exception: " + e.getStackTrace());
        }
        return hostAndPorts_set;
    }

}
