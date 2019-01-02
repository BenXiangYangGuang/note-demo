package com.wewe.okhttp;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @Author: fei2
 * @Date:2018/6/25 14:53
 * @Description: response相应内容缓存在 磁盘中
 * @Refer To:
 */
public class CacheResponse {
    
    public static void main(String[] args) throws IOException {
        int cacheSize = 100 * 1024 * 1024;
        File cacheDirectory = Files.createTempDirectory("cache").toFile();
        Cache cache = new Cache(cacheDirectory,cacheSize);
    
        OkHttpClient client = new OkHttpClient();
        client.setCache(cache);
    
        Request request = new Request.Builder()
            .url("http://www.baidu.com")
            .build();
    
        Response response = client.newCall(request).execute();
        if(!response.isSuccessful()){
            throw new IOException("服务器端错误：" + response);
        }
        System.out.println(response.cacheResponse());
        System.out.println(response.networkResponse());
    }
}
