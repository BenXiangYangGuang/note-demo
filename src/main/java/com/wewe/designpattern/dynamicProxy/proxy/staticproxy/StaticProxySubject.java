package com.wewe.designpattern.dynamicProxy.proxy.staticproxy;

import com.wewe.designpattern.dynamicProxy.subject.ConcreteSubject;
import com.wewe.designpattern.dynamicProxy.subject.ISubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticProxySubject implements ISubject {

  private static final Logger LOG = LoggerFactory.getLogger(StaticProxySubject.class);

  private ISubject subject;

  public StaticProxySubject() {
    subject = new ConcreteSubject();
  }

  @Override
  public void action() {
    preAction();
    subject.action();
    postAction();
  }

  public void preAction() {
    LOG.info("StaticProxySubject.preAction()");
  }

  public void postAction() {
    LOG.info("StaticProxySubject.postAction()");
  }

}
