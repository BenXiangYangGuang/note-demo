package com.wewe.okhttp;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * @Author: fei2
 * @Date:2018/6/25 11:42
 * @Description:
 * @Refer To:
 */
public class Headers {
    
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
            .url("http://www.baidu.com")
            .header("User-Agent","My super agent")
            .addHeader("Accept","text/html")
            .build();
    
        Response response = client.newCall(request).execute();
        if(!response.isSuccessful()){
            throw new IOException("服务器端错误：" + response);
        }
    
        System.out.println(response.header("Server"));
        System.out.println(response.headers("Set-Cookie"));
        
    }
}
