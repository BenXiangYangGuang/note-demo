package com.wewe.designpattern.simplefactory.client;

import com.wewe.designpattern.simplefactory.factory.CarFactory1;
import com.wewe.designpattern.simplefactory.product.Car;
import com.wewe.designpattern.simplefactory.factory.CarFactory1;
import com.wewe.designpattern.simplefactory.product.Car;

public class Driver3 {

	public static void main(String[] args) {
		Car car = CarFactory1.newCar();
		car.drive();
	}

}
