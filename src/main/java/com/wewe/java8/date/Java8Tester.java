package com.wewe.java8.date;

import java.time.*;

/**
 * Created by fei2 on 2018/5/24.
 * 描述：
 */
public class Java8Tester {
    
    public static void main(String[] args) {
        Java8Tester java8Tester = new Java8Tester();
        java8Tester.testLocalDateTime();
        java8Tester.testZonedDateTime();
    }
    
    public static void testLocalDateTime(){
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间："+currentTime );
    
        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1:" + date1);
    
        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();
        
        System.out.println("月：" +month + ", 日 ：" +day + ", 秒 ：" + seconds);
        
        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        
        System.out.println("date2 :" + date2);
        
        LocalDate date3 = LocalDate.of(2014,Month.DECEMBER,12);
        
        System.out.println("date3 :" + date3);
    
        LocalTime date4 = LocalTime.of(22,15);
        
        System.out.println("date4 :" + date4);
        
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5 :" + date5);
        
    }
    
    public static void testZonedDateTime(){
    
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        
        System.out.println("date1 :" + date1);
        
        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId:" + id);
        
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当前时区：" + currentZone);
    }
}
