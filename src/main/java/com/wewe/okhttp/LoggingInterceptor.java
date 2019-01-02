package com.wewe.okhttp;


import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * @Author: fei2
 * @Date:2018/6/25 15:32
 * @Description:
 * @Refer To:
 */
public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        
        long t1 = System.nanoTime();
        System.out.println(String.format("发送请求：[%s] %s%n%s",
            request.url(),chain.connection(),request.headers()));
    
        System.out.println("request headers :" + request.headers());
        Response response = chain.proceed(request);
        
        long t2 = System.nanoTime();
    
        System.out.println(String.format("接收响应：[%s] %.1fms%n%s",
            response.request().url(),(t2-t1)/1e6d,response.headers()));
        System.out.println("response headers :" + response.headers());
    
        return response;
    }
}
