package com.wewe.designpattern.proxyVSPattern.decorator;

import com.wewe.designpattern.proxyVSPattern.subject.ISubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubjectPreDecorator implements ISubject {

  private static final Logger LOG = LoggerFactory.getLogger(SubjectPreDecorator.class);

  private ISubject subject;

  public SubjectPreDecorator(ISubject subject) {
    this.subject = subject;
  }

  @Override
  public void action() {
    preAction();
    subject.action();
  }

  private void preAction() {
    System.out.println("SubjectPreDecorator.preAction()");
    LOG.info("SubjectPreDecorator.preAction()");
  }

}
