package com.wewe.designpattern.simplefactory.client;

import com.wewe.designpattern.simplefactory.factory.CarFactory3;
import com.wewe.designpattern.simplefactory.product.Car;
import com.wewe.designpattern.simplefactory.factory.CarFactory3;
import com.wewe.designpattern.simplefactory.product.Car;

public class Driver5 {

	public static void main(String[] args) {
		Car car = CarFactory3.newCar();
		car.drive();
	}

}
