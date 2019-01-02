package com.wewe.util;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: fei2
 * @Date:2018/6/25 17:14
 * @Description:
 * @Refer To:
 */
public class OkHttpUtilsTest extends TestCase {

    public void testDoGet() throws Exception {
        Map<String ,String> paramMap = new HashMap<>();
        paramMap.put("is_template","0");
        String resultStr =  OkHttpUtils.getInstance().doGet("http://localhost:2018/api/v1/base/rule",paramMap);
        System.out.println(resultStr);
        
    }
    
    public void testDoPost() throws Exception {
    
        Map<String ,String> paramMap = new HashMap<>();
        paramMap.put("name","name0");
        paramMap.put("id","id0");
        String resultStr =  OkHttpUtils.getInstance().doPost("http://localhost:8080/users/postUser",paramMap);
        System.out.println(resultStr);
    }
    
}