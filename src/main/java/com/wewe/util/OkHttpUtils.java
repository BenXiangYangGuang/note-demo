package com.wewe.util;

import com.squareup.okhttp.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

/**
 * @Author: fei2
 * @Date:2018/6/25 16:14
 * @Description:
 * @Refer To:
 */
@Slf4j
public class OkHttpUtils {
    
    //单例模式
    private static OkHttpClient okHttpClient = null;

    /**
     * 得到OkHttpUtils实例对象
     *
     * @return
     */
    private OkHttpUtils(){}
    public static OkHttpClient getInstance(){
        if(null==okHttpClient){
            synchronized (OkHttpClient.class){
                if(null==okHttpClient){
                    okHttpClient = new OkHttpClient();
                }
            }
        }
        return okHttpClient;
    }
    
    /**
     *
     * @param path url
     * @param map 请求参数
     * @return 返回结果
     */
    
    public String doGet(String path, Map<String,String> map){
        StringBuffer sb = new StringBuffer();
        sb.append(path);
        //判断path是否包含一个
        if(sb.indexOf("?")!=-1){
            //判断"?"是否在最后一个
            if(sb.indexOf("?")!=sb.length()-1){
                sb.append("&");
            }
            
        }else{
            sb.append("?");
        }
        //遍历map集合中所有请求参数
        for(Map.Entry<String, String> entry:map.entrySet()){
            sb.append(entry.getKey())
                .append("=")
                .append(entry.getValue())
                .append("&");
        }
        
        if(sb.lastIndexOf("&")!=-1){
            sb.deleteCharAt(sb.length()-1);
        }
        
        //构建请求项
        Request request=new Request.Builder()
            .get()
            .url(sb.toString())
            .build();
        return doExeucuteQequestAndParseRespone(request);
    }
    
    /**
     *
     * @param path url
     * @param map 请求参数
     * @return 返回结果
     * @throws IOException
     */
    
    public String doPost(String path,Map<String,String> map) throws IOException {

        //构建参数的对象
        FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
        //遍历map集合，获取用户的key/value
        for(String key:map.keySet()){
            formEncodingBuilder.add(key,map.get(key));
        }
        //构建请求项
        Request request=new Request.Builder()
            .post(formEncodingBuilder.build())
            .url(path)
            .build();

        return doExeucuteQequestAndParseRespone(request);
        
    }
    public String doExeucuteQequestAndParseRespone(Request request){

        OkHttpClient okHttpClient=OkHttpUtils.getInstance();

        try {
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()){
                log.error("服务器端错误：{}" , response);
            }else {
                return response.body().string();
            }
        } catch (IOException e) {
            log.error("出现IOException");
        }
        return null;

    }

    
}
