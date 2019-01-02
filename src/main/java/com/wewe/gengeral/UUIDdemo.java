package com.wewe.gengeral;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by fei2 on 2018/4/25.
 */
public class UUIDdemo {
    public static void main(String[] args) {
        // creating UUID
        UUID uid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d1");
        // checking UUID value
        System.out.println("UUID value is: "+uid);
        String str = "3fd94f10-574b-11e8-bd11-79a91b60e0c0";
        String  id = str.substring(15, 18) + str.substring(9, 13) + str.substring(0, 8) + str.substring(19, 23) + str.substring(24);
        System.out.println("id--------------"+id);
        String uuid = UUIDConverter.fromString("1e848751275e590b07ae7b48922ff96").toString();
        System.out.println("uuid----"+uuid);
    
    
        Map<String,String> map = new HashMap<>();
        map.put("age","10");
        map.put("age","20");
        map.forEach((k,v) -> {
                System.out.println("key : " + k + "value : " +v);
            }
        );
    }
}
