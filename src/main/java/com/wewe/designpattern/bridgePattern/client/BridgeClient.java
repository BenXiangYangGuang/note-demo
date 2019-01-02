package com.wewe.designpattern.bridgePattern.client;


import com.wewe.designpattern.bridgePattern.brand.AbstractCar;
import com.wewe.designpattern.bridgePattern.brand.BMWCar;
import com.wewe.designpattern.bridgePattern.brand.BenZCar;
import com.wewe.designpattern.bridgePattern.transmission.Auto;
import com.wewe.designpattern.bridgePattern.transmission.Manual;
import com.wewe.designpattern.bridgePattern.transmission.Transmission;

/**
 * 一个对象里面有一个对象,从而实现了桥接;代替了继承的复杂性
 */
public class BridgeClient {

  public static void main(String[] args) {
    Transmission auto = new Auto();
    AbstractCar bmw = new BMWCar();
    bmw.setTransmission(auto);
    bmw.run();
    

    Transmission manual = new Manual();
    AbstractCar benz = new BenZCar();
    benz.setTransmission(manual);
    benz.run();
  }

}
