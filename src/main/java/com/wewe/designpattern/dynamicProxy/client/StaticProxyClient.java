package com.wewe.designpattern.dynamicProxy.client;

import com.wewe.designpattern.dynamicProxy.proxy.staticproxy.StaticProxySubject;
import com.wewe.designpattern.dynamicProxy.subject.ISubject;

public class StaticProxyClient {

  public static void main(String[] args) {
    ISubject subject = new StaticProxySubject();
    subject.action();
  }

}
