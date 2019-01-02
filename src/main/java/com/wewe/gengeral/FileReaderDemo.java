package com.wewe.gengeral;

import java.io.*;

/**
 * @Author: fei2
 * @Date:2018/6/20 19:20
 * @Description:  java读取资源文件  非 jar 包，jar 包有自己的文件系统不能被识别的路径
 * 记得 maven clean install maven 插件 copy conf 文件
 * @Refer To:
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        String path = FileReaderDemo.class.getClassLoader().getResource("").getPath();
        System.out.println(path);
        String filestr = path + "/conf/krb5.conf";
        String str = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filestr)));
            while((str = br.readLine()) != null){
                System.out.println(str);//此时str就保存了一行字符串
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
