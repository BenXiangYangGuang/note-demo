package com.wewe.okhttp;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * @Author: fei2
 * @Date:2018/6/25 15:05
 * @Description: 异步调用
 * @Refer To:
 */
public class AsyncGet {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
    
        Request request = new Request.Builder()
            .url("http://www.baidu.com")
            .build();
        
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }
    
            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()){
                    throw new IOException("服务器端错误：" +response);
                }
                System.out.println(response.body().string());
            }
        });
    }
}
