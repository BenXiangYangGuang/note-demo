package com.wewe.designpattern.simplefactory.product;

import com.wewe.designpattern.simplefactory.annotation.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Vehicle(type="Land Rover")
public class LandRoverCar extends Car {
	
	private static Logger LOG = LoggerFactory.getLogger(LandRoverCar.class);
	
	public LandRoverCar() {
		this.name = "Land Rover";
	}

	@Override
	public void drive() {
		LOG.info("My name is {}. I'm on my way", name);
	};

}
