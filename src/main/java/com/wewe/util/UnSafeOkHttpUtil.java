package com.wewe.util;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.Map;

/**
 * @Author: fei2
 * @Date:2018/6/25 16:14
 * @Description:
 * @Refer To:
 */
@Slf4j
public class UnSafeOkHttpUtil {

    //单例模式

    private static OkHttpClient okHttpClient = null;

    /**
     * 得到OkHttpUtils实例对象
     *
     * @return
     */
    private UnSafeOkHttpUtil(){}
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

     /*
     * This is very bad practice and should NOT be used in production.
     */

    public static void main(String[] args) {

        String requestURL = "https://apigw.yeseer.cn/bsj2/api/device?size=99999";

        OkHttpClient okHttpClient=getUnsafeOkHttpClient();
        //构建请求项
        Request request=new Request.Builder()
                .get()
                .url(requestURL)
                .header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjkyNTk1MzQwZjNmMmQ0M2YzMmQ1NGY3MzM3ZWM3Y2IyNjU0YTRiNjMxYjViNzc5NGQ1NzI3NGFhMzZhZmQ0Yjk1NjMyNjUzMzFiNTdkMjFiIn0.eyJhdWQiOiIxIiwianRpIjoiOTI1OTUzNDBmM2YyZDQzZjMyZDU0ZjczMzdlYzdjYjI2NTRhNGI2MzFiNWI3Nzk0ZDU3Mjc0YWEzNmFmZDRiOTU2MzI2NTMzMWI1N2QyMWIiLCJpYXQiOjE1NTc5OTI5NDQsIm5iZiI6MTU1Nzk5Mjk0NCwiZXhwIjoxNTU4MDc5MzQ0LCJzdWIiOiIxMDA4MyIsInNjb3BlcyI6WyIqIl19.Y9z1H3j0qbokR-j8OjKwR6nzAi-wB7cDxUZ5X1rwVmhqJFP-1sWty8LUkaZETTqdMwZZ59yAX51Pn88YL_DoR54_HpwsjgCWllM0D3-bkNcMRR0CFO1Lj0tzdX2WTmPu17uokYR-oymqXxruLZQSINkhR_35FMEoOBzGkuWZGZ3aUasmYPrxhKquFkVg-EAYrazB6KO7M_K1Klu0pKVymfpNrsASHSLeAlEV9N3gw7okDkA8uaJ6Ky7B9CRZpYWmGgpW5s5DBJyJz6Ky6i2FTAGQoBlB-3migNKEKpD9Xct7ZUtL9Ca34EAWwRcFzgggShR1pt0iglZrUvhpM4SUb_swVcffQaHksPvUEm1RyLhFBjrWFFgHDDr6XNIi2QLnOD_ucwA3MnhcS46_0UvlML2DXDP88rho6gW1q_ZU3s_VCLoiBVb6cI28a4AIn47voDRvYIH8Exa2O4ykq-SsgZzBetwA-uox2BZPmXGAkmQPYEWWltYOkGp9ozKd0Ywe5Y5PZfKUQV2pThUCpkGkLxUiz_AN75-_UCnebXbcMXg3-xKX1uzuutKEuy1eUuxYMYOLV9h8SkLZLhOrQXJw5eQH2MYmDOiY9dzAwD2ouQ_JlR7r_XI0PTEWtyqXxCx52rpFwx332I66M4qhIP271Bf3gsarFi2Utd7Qh1vKqHE")
                .build();
        String resultStr = "";
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()){
                log.error("服务器端错误：{}" , response);
            }else {
                resultStr = response.body().string();
            }
        } catch (IOException e) {
            log.error("出现IOException");
        }


    }
    private static OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient okHttpClient = UnSafeOkHttpUtil.getInstance();
            okHttpClient.setSslSocketFactory(sslSocketFactory);
            okHttpClient.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

        OkHttpClient okHttpClient=UnSafeOkHttpUtil.getInstance();

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
