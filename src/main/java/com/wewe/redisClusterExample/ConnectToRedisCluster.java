package com.wewe.redisClusterExample;

import com.google.common.collect.Lists;
import io.lettuce.core.LettuceFutures;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisStringCommands;
import io.lettuce.core.cluster.ClusterClientOptions;
import io.lettuce.core.cluster.ClusterTopologyRefreshOptions;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Author: fei2
 * Date:  2018/12/19 15:33
 * Description:
 * Refer To:
 */
public class ConnectToRedisCluster {




    public static void clusterExample(){
        RedisURI node1 = RedisURI.create("10.154.96.93", 7001);
        RedisURI node2 = RedisURI.create("10.154.96.93", 7002);
        RedisURI node3 = RedisURI.create("10.154.96.93", 7003);

        RedisClusterClient clusterClient = RedisClusterClient.create(Arrays.asList(node1, node2,node3));
        StatefulRedisClusterConnection<String, String> connection = clusterClient.connect();
        RedisAdvancedClusterAsyncCommands<String, String> syncCommands = connection.async();

        // disable auto-flushing
        syncCommands.setAutoFlushCommands(false);

        // perform a series of independent calls
        List<RedisFuture<?>> futures = Lists.newArrayList();
        for (int i = 0; i < 10000; i++) {
            futures.add(syncCommands.set("key-" + i, "value-" + i));
        }

        // write all commands to the transport layer
        syncCommands.flushCommands();

        // synchronization example: Wait until all futures complete
        boolean result = LettuceFutures.awaitAll(5, TimeUnit.SECONDS,
                futures.toArray(new RedisFuture[futures.size()]));

        // later
        connection.close();

        clusterClient.shutdown();

    }

    public static void main(String[] args) {
        RedisURI node1 = RedisURI.create("10.154.96.93", 7001);
        RedisURI node2 = RedisURI.create("10.154.96.93", 7002);
        RedisURI node3 = RedisURI.create("10.154.96.93", 7003);

        RedisClusterClient clusterClient = RedisClusterClient.create(Arrays.asList(node1, node2,node3));
        StatefulRedisClusterConnection<String, String> connection = clusterClient.connect();
        RedisAdvancedClusterAsyncCommands<String, String> syncCommands = connection.async();

        // disable auto-flushing
        syncCommands.setAutoFlushCommands(false);

        // perform a series of independent calls
        List<RedisFuture<?>> futures = Lists.newArrayList();
        for (int i = 0; i < 10000; i++) {
            futures.add(syncCommands.set("key-" + i, "value-" + i));
        }

        // write all commands to the transport layer
        syncCommands.flushCommands();

        // synchronization example: Wait until all futures complete
        boolean result = LettuceFutures.awaitAll(5, TimeUnit.SECONDS,
                futures.toArray(new RedisFuture[futures.size()]));

        // later
        connection.close();

//        clusterClient.shutdown();


/*        RedisClient client = RedisClient.create("redis://localhost");
        StatefulRedisConnection<String, String> connection = client.connect();
        RedisAsyncCommands<String, String> commands = connection.async();

        // disable auto-flushing
        commands.setAutoFlushCommands(false);

        // perform a series of independent calls
        List<RedisFuture<?>> futures = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            futures.add(commands.set("key-" + i, "value-" + i);
        }

        // write all commands to the transport layer
        commands.flushCommands();

        // synchronization example: Wait until all futures complete
        boolean result = LettuceFutures.awaitAll(5, TimeUnit.SECONDS,
                futures.toArray(new RedisFuture[futures.size()]));

        // later
        connection.close();*/
    }
}
