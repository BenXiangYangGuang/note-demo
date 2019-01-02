package com.wewe.designpattern.proxyVSPattern.proxy;

import com.wewe.designpattern.proxyVSPattern.subject.ConcreteSubject;
import com.wewe.designpattern.proxyVSPattern.subject.ISubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;


public class ProxySubject implements ISubject {

  private static final Logger LOG = LoggerFactory.getLogger(ProxySubject.class);

  private ISubject subject;

  public ProxySubject() {
    subject = new ConcreteSubject();
  }

  @Override
  public void action() {
    preAction();
    if((new Random()).nextBoolean()){
      subject.action();
    } else {
      LOG.info("Permission denied");
    }
    postAction();
  }

  private void preAction() {
    LOG.info("StaticProxySubject.preAction()");
  }

  private void postAction() {
    LOG.info("StaticProxySubject.postAction()");
  }

}
