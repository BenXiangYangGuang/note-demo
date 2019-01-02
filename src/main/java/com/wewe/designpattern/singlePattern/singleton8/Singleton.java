package com.wewe.designpattern.singlePattern.singleton8;

/**
 * 懒加载;线程安全;强烈推荐
 */
public class Singleton {

  private Singleton() {};

  public static Singleton getInstance() {
    return InnerClass.INSTANCE;
  }
  
  private static class InnerClass {
    private static final Singleton INSTANCE = new Singleton();
  }

}
