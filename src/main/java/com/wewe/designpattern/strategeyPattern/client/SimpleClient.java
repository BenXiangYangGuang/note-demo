package com.wewe.designpattern.strategeyPattern.client;
import com.wewe.designpattern.strategeyPattern.context.SimpleContext;
import com.wewe.designpattern.strategeyPattern.strategy.ConcreteStrategyA;
import com.wewe.designpattern.strategeyPattern.context.SimpleContext;
import com.wewe.designpattern.strategeyPattern.strategy.ConcreteStrategyA;
import com.wewe.designpattern.strategeyPattern.strategy.Strategy;

public class SimpleClient {

  public static void main(String[] args) {
    Strategy strategy = new ConcreteStrategyA();
    SimpleContext context = new SimpleContext(strategy);
    context.action("Hellow, world");
  }

}
