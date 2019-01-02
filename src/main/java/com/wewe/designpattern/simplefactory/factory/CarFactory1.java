package com.wewe.designpattern.simplefactory.factory;

/**
 * Author: wewe
 * Date:  18-8-18 下午12:45
 * Description:
 * Refer To:
 */
import com.wewe.designpattern.simplefactory.product.BMWCar;
import com.wewe.designpattern.simplefactory.product.BenzCar;
import com.wewe.designpattern.simplefactory.product.Car;
import com.wewe.designpattern.simplefactory.product.LandRoverCar;
import com.wewe.designpattern.simplefactory.product.BMWCar;
import com.wewe.designpattern.simplefactory.product.BenzCar;
import com.wewe.designpattern.simplefactory.product.Car;
import com.wewe.designpattern.simplefactory.product.LandRoverCar;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarFactory1 {

    private static final Logger LOG = LoggerFactory.getLogger(CarFactory1.class);

    public static Car newCar() {
        Car car = null;
        String name = null;
        try {
            XMLConfiguration config = new XMLConfiguration("car.xml");
            name = config.getString("factory1.name");
        } catch (ConfigurationException ex) {
            LOG.error("parse xml configuration file failed", ex);
        }

        switch (name) {
            case "Land Rover":
                car = new LandRoverCar();
                break;
            case "BMW":
                car = new BMWCar();
                break;
            case "Benz":
                car = new BenzCar();
                break;
            default:
                car = null;
                break;
        }
        LOG.info("Created car name is {}", name);
        return car;
    }

}

