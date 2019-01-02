package com.wewe.designpattern.strategeyPattern.context;


import com.wewe.designpattern.strategeyPattern.strategy.Strategy;

public class SimpleContext {

  private Strategy strategy;
  
  public SimpleContext(Strategy strategy) {
    this.strategy = strategy;
  }
  
  public void action(String input) {
    strategy.strategy(input);
  }
  
}
