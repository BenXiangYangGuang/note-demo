package com.wewe.setExample;

import java.util.*;

/**
 * Author: fei2
 * Date:  18-9-6 下午4:07
 * Description: list 字段进行paixu
 * Refer To:
 */
public class SortListExample {

    public static void main(String[] args) {
        List<String[]> list = new ArrayList<String[]>();

        String time = String.valueOf(System.currentTimeMillis());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String time2 = String.valueOf(System.currentTimeMillis());

        String[] o1 = new String[]{time,"col1","1"};
        String[] o2 = new String[]{time,"col2","2"};
        String[] o3 = new String[]{time,"col3","3"};
        String[] o4 = new String[]{time2,"col1","4"};
        String[] o5 = new String[]{time2,"col1","5"};
        String[] o6 = new String[]{time2,"col2","6"};
        String[] o7 = new String[]{time2,"col3","7"};
        String[] o8 = new String[]{time2,"col3","8"};

        list.add(o1);
        list.add(o7);
        list.add(o5);
        list.add(o3);
        list.add(o4);
        list.add(o8);
        list.add(o6);
        list.add(o2);

        for (String[] object : list){
            System.out.println(object[0]+":"+object[2]);
        }
        System.out.println("--sort--");
        Collections.sort(list,new SortComparatorExample());
        for (String[] object : list){
            System.out.println(object[0]+":"+object[2]);
        }
        int size = new HashSet<String[]>(list).size();
        System.out.println("list no repeat:" + size);

        System.out.println("--car排序之前--");
        List<Car[]> listCar = new ArrayList<>();
        Car car1 = new Car(1);
        Car car2 = new Car(11);
        Car car3 = new Car(111);
        Car car11 = new Car(2);
        Car car22 = new Car(22);
        Car car33 = new Car(222);

        Car[] cc1 = new Car[]{car1,car2,car3};
        Car[] cc2 = new Car[]{car11,car22,car33};
        listCar.add(cc2);
        listCar.add(cc1);

        for (Car[] cc:listCar){
            System.out.println(cc[0].toString());
        }
        Collections.sort(listCar,new CarCompartor());

        System.out.println("--car排序之后--");
        for (Car[] cc:listCar){
            System.out.println(cc[0].toString());
        }

    }

}
class Car {
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Car{" +
                "age=" + age +
                '}';
    }

    public Car(int age) {
        this.age = age;
    }
}
class CarCompartor implements Comparator<Car[]>{

    @Override
    public int compare(Car[] cars1 , Car[] cars2) {
        Car o1 = cars1[0];
        Car o2 = cars2[0];
        return o1.getAge() - o2.getAge();
    }
}
