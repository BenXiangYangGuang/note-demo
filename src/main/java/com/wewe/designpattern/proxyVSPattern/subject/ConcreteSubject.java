package com.wewe.designpattern.proxyVSPattern.subject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ConcreteSubject implements ISubject {

  private static final Logger LOG = LoggerFactory.getLogger(ConcreteSubject.class);

  @Override
  public void action() {
    System.out.println("ConcreteSubject action()");
    LOG.info("ConcreteSubject action()");
  }

}