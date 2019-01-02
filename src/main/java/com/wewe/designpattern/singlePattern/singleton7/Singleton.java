package com.wewe.designpattern.singlePattern.singleton7;

/**
 * 常量静态;推荐
 */
public class Singleton {

  private static Singleton INSTANCE;

  static{
    INSTANCE = new Singleton();
  }

  private Singleton() {};

  public static Singleton getInstance() {
    return INSTANCE;
  }

}
