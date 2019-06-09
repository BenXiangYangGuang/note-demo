package com.wewe.designpattern.singlePattern.singleton4;

/**
 * 懒加载推荐;线程安全
 *
 * http://ifeve.com/double-checked-locking-with-delay-initialization/
 *
 * volatile 关键字防止 INSTANCE = new Singleton(); 重新排序
 */
public class Singleton {

  private static volatile Singleton INSTANCE;

  private Singleton() {};

  public static Singleton getInstance() {
    if (INSTANCE == null) {
      synchronized(Singleton.class){
        if(INSTANCE == null) {
          INSTANCE = new Singleton();
        }
      }
    }
    return INSTANCE;
  }

}
