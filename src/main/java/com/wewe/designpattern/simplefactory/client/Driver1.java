package com.wewe.designpattern.simplefactory.client;

import com.wewe.designpattern.simplefactory.product.BenzCar;
import com.wewe.designpattern.simplefactory.product.BenzCar;

/**
 * Author: wewe
 * Date:  18-8-18 下午12:03
 * Description:最简单的创建工程的方法
 * Refer To:
 */
public class Driver1 {


    public static void main(String[] args) {
        BenzCar car = new BenzCar();
        car.drive();
    }
}
