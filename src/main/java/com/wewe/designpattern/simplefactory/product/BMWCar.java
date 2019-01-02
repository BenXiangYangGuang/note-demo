package com.wewe.designpattern.simplefactory.product;

import com.wewe.designpattern.simplefactory.annotation.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: fei2
 * Date:  18-8-9 下午7:26
 * Description:
 * Refer To:
 */
@Vehicle(type="BMW")
public class BMWCar extends Car {

    private static Logger LOG = LoggerFactory.getLogger(BMWCar.class);

    public BMWCar() {
        this.name = "BMW";
    }

    @Override
    public void drive() {
        LOG.info("My name is {}. I'm on my way", name);
    };

}
