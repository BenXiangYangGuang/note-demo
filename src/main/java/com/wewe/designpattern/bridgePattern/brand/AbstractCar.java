package com.wewe.designpattern.bridgePattern.brand;


import com.wewe.designpattern.bridgePattern.transmission.Transmission;

public abstract class AbstractCar {

  protected Transmission gear;
  
  public abstract void run();
  
  public void setTransmission(Transmission gear) {
    this.gear = gear;
  }
  
}
