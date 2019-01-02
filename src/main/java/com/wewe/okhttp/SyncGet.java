package com.wewe.okhttp;


import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * @Author: fei2
 * @Date:2018/6/25 11:28
 * @Description: http网络请求请求
 * @Refer To:https://www.ibm.com/developerworks/cn/java/j-lo-okhttp/index.html
 */
public class SyncGet {
    
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        //添加请求拦截器
        client.interceptors().add(new LoggingInterceptor());
        
        Request request = new Request.Builder().url("http://www.baidu.com").build();
        
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()){
            throw new IOException("服务器端错误：" + response);
        }
    
        Headers responseHeaders = response.headers();
        
        for (int i = 0; i < responseHeaders.size(); i++){
            System.out.println(responseHeaders.name(i) + ":" + responseHeaders.value(i));
        }
        System.out.println("返回消息内容主体: \n " + response.body().string());
    }
}
