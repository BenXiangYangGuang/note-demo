package com.wewe.designpattern.simplefactory.client;

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

/**
 * Author: wewe
 * Date:  18-8-18 下午12:04
 * Description:读取文件配置进行新建对象
 * Refer To:
 */
public class Driver2 {
    private static final Logger LOG = LoggerFactory.getLogger(Driver2.class);

    public static void main(String[] args) {
        try {
            XMLConfiguration configuration = new XMLConfiguration("car.xml");
            String name = configuration.getString("driver2.name");
            Car car;
            switch (name){
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
            car.drive();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }


    }
}
