package com.wewe.designpattern.simplefactory.client;


import com.wewe.designpattern.simplefactory.factory.CarFactory2;
import com.wewe.designpattern.simplefactory.product.Car;
import com.wewe.designpattern.simplefactory.factory.CarFactory2;
import com.wewe.designpattern.simplefactory.product.Car;

public class Driver4 {

	public static void main(String[] args) {
		Car car = CarFactory2.newCar();
		car.drive();
	}

}
