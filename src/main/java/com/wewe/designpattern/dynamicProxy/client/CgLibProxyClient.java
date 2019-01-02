package com.wewe.designpattern.dynamicProxy.client;

import com.wewe.designpattern.dynamicProxy.proxy.cglibproxy.SubjectInterceptor;
import com.wewe.designpattern.dynamicProxy.subject.ConcreteSubject;
import com.wewe.designpattern.dynamicProxy.subject.ISubject;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class CgLibProxyClient {

  public static void main(String[] args) {
    MethodInterceptor methodInterceptor = new SubjectInterceptor();
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(ConcreteSubject.class);
    enhancer.setCallback(methodInterceptor);
    ISubject subject = (ISubject)enhancer.create();
    subject.action();
  }

}
