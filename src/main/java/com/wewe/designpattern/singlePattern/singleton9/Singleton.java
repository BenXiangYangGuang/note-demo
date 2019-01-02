package com.wewe.designpattern.singlePattern.singleton9;

public enum Singleton {

  INSTANCE;
  
  public void whatSoEverMethod() { }

  // 该方法非必须，只是为了保证与其它方案一样使用静态方法得到实例
  public static Singleton getInstance() {
    return INSTANCE;
  }
}
