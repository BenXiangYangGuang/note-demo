package com.wewe.setExample;

/**
 * Author: fei2
 * Date:  18-9-6 下午5:54
 * Description:计算机生产currentTimeMIlls
 * 同一个System.currentTimeMillis() 大约可以生产处30个记录
 * Refer To:
 */
public class CurrentTimeMillsProduct {
    public static void main(String[] args) {


        System.out.println("bb");
        try {
            cc();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("mian");


    }
    public static void cc() throws Exception {
        int a = 0;
        if (a == 0){
           throw new Exception("除数为0");
        }
        System.out.println("---------");
    }
}
