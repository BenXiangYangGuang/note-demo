package com.wewe.gengeral;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fei2 on 2018/5/21.
 * 描述：mapper 解析字符串到对象
 * 参考：https://blog.csdn.net/newnessayuan/article/details/8442212
 */
public class JSONConfig {
    
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String configuration = "{\"name\": \",\",\"isFalse\": false,\"address\": {\"city\": {\"city\": \"shanghai\"}},\"node\": {\"age\": 11,\"company\": \"公司\"}}";
        String conf = "{\"name\": \"123\",\"age\": 20}";
        String childStr = "{\"name\":\"zhang\",\"age\":20}";
        
        try {
            Config config = mapper.readValue(configuration, Config.class);
            System.out.println("name :" + config.getName());
            System.out.println("isFalse :" + config.getIsFalse());
            System.out.println("city :" + config.getAddress().getCity().city);
            System.out.println("node:" + config.getNode() );
            
            System.out.println("--------------------------");
            
            String configStr = mapper.writeValueAsString(config);
            Config config2 = mapper.readValue(configStr, Config.class);
            System.out.println("name :" + config2.getName());
            System.out.println("isFalse :" + config2.getIsFalse());
            System.out.println("city :" + config2.getAddress().getCity().city);
            System.out.println("node:" + config2.getNode() );
            
            System.out.println("------------------------------");
            
            Child child1 = mapper.readValue(childStr.toString(),Child.class);
            System.out.println("age:" + child1.getAge());
            
            System.out.println("------------------------------");
            
            List<Dog> list = new ArrayList<>();
            Dog dog = new Dog();
            dog.setAge(10);
            list.add(dog);
            System.out.println(list.get(0).getAge());
            
            System.out.println("------------------------------");
            //读取一个数组，直接转化为list
            String jsonArray = "[{\"name\":\"zhang\"},{\"name\":\"lisi\"}]";
    
            List<People> peopleList = mapper.readValue(jsonArray, new TypeReference<List<People>>(){});
            System.out.println(peopleList.get(0).getName());
    
            System.out.println("------------------------------");
            //读取一个数组，直接转化为list
            String jsonArray2 = "[{\"name\": \",111\",\"isFalse\": false,\"address\": {\"city\": {\"city\": \"shanghai\"}},\"node\": {\"age\": 11,\"company\": \"公司\"}},{\"name\": \",\",\"isFalse\": false,\"address\": {\"city\": {\"city\": \"shanghai\"}},\"node\": {\"age\": 11,\"company\": \"公司\"}}]";
    
            List<Config> configList = mapper.readValue(jsonArray2, new TypeReference<List<Config>>(){});
            System.out.println(configList.get(0).getName());

            //字符串直接转换为 枚举类型
            /**
             * {
                 "name": "zhang",
                 "sex": "MALE"
               }
             */
            String str1 = "{\n" +
                    "\t\"name\": \"zhang\",\n" +
                    "\t\"sex\": \"MALE\"\n" +
                    "}";
            Cat cat = mapper.readValue(str1,Cat.class);
            System.out.println(cat.getSex());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    static class Config{
        private String name = ",";
        private Address address;
        private boolean isFalse;
        private JsonNode node;
    
        public JsonNode getNode() {
            return node;
        }
    
        public void setNode(JsonNode node) {
            this.node = node;
        }
    
        public boolean getIsFalse(){
            return isFalse;
        }
        public void setFalse(boolean aFalse) {
            isFalse = aFalse;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public Address getAddress() {
            return address;
        }
    
        public void setAddress(Address address) {
            this.address = address;
        }
    }
    static class Address{
        private City city;
    
        public City getCity() {
            return city;
        }
    
        public void setCity(City city) {
            this.city = city;
        }
    }
    static class City{
        private String city;
    
        public String getCity() {
            return city;
        }
    
        public void setCity(String city) {
            this.city = city;
        }
    }
    
    static class People{
        private String name;
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    }
    static class Child extends People{
        int age;
    
        public int getAge() {
            return age;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    }
    
    static class Dog<T extends Face>{
        int age;
    
        public int getAge() {
            return age;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    }
    static class Face{
        private String color;
    }

    static class Cat{
        private String name;
        private Sex sex;
        private Integer age;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Sex getSex() {
            return sex;
        }

        public void setSex(Sex sex) {
            this.sex = sex;
        }
    }
    enum Sex{
        MALE,FEMALE
    }

}
