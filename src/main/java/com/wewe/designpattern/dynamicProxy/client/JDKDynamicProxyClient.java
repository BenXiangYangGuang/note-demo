package com.wewe.designpattern.dynamicProxy.client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.wewe.designpattern.dynamicProxy.proxy.jdkproxy.SubjectProxyHandler;
import com.wewe.designpattern.dynamicProxy.subject.ConcreteSubject;
import com.wewe.designpattern.dynamicProxy.subject.ISubject;
import com.wewe.designpattern.dynamicProxy.proxy.jdkproxy.SubjectProxyHandler;
import com.wewe.designpattern.dynamicProxy.subject.ConcreteSubject;
import com.wewe.designpattern.dynamicProxy.subject.ISubject;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import sun.misc.ProxyGenerator;

public class JDKDynamicProxyClient {

  private static final Logger LOG = LoggerFactory.getLogger(JDKDynamicProxyClient.class);
  
  public static void main(String[] args) throws IOException {
    InvocationHandler handler = new SubjectProxyHandler(ConcreteSubject.class);
    ISubject subject =
        (ISubject) Proxy.newProxyInstance(JDKDynamicProxyClient.class.getClassLoader(),
            new Class[] {ISubject.class}, handler);
    subject.action();
    LOG.info("Proxy class name {}", subject.getClass().getName());
    byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy17", ConcreteSubject.class.getInterfaces());
    try(OutputStream outputStream = new FileOutputStream("$Proxy17.class")){
      IOUtils.write(classFile, outputStream);
    }
  }

}
