package com.wewe.okhttp;

import com.squareup.okhttp.*;

import java.io.IOException;

/**
 * @Author: fei2
 * @Date:2018/6/25 11:50
 * @Description:
 * @Refer To:
 */
public class PostString {
    
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/plain");
        //提交字符串
       /* String postBody = "Hello World";
        Request request = new Request.Builder()
            .url("http://www.baidu.com")
            .post(RequestBody.create(MEDIA_TYPE_TEXT,postBody))
            .build();
        */
        //提交form 表单
        RequestBody formBody = new FormEncodingBuilder()
            .add("query", "Hello")
            .build();
        Request request = new Request.Builder()
            .url("http://www.baidu.com")
            .post(formBody)
            .build();
    
        
    
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()){
            throw new IOException("服务器端错误：" + response);
        }
    
        System.out.println(response.body().string());
    }
}
