package com.wewe.designpattern.proxyVSPattern.client;


import com.wewe.designpattern.proxyVSPattern.proxy.ProxySubject;
import com.wewe.designpattern.proxyVSPattern.subject.ISubject;

public class StaticProxyClient {

  public static void main(String[] args) {
    ISubject subject = new ProxySubject();
    subject.action();
  }

}
