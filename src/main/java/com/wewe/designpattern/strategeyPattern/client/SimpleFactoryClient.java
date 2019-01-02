package com.wewe.designpattern.strategeyPattern.client;


import com.wewe.designpattern.strategeyPattern.context.SimpleFactoryContext;

public class SimpleFactoryClient {

  public static void main(String[] args) {
    SimpleFactoryContext context = new SimpleFactoryContext();
    context.action("Hellow, world");
  }

}
