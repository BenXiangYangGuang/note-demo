package com.wewe.designpattern.adapterPattern.client;

import com.wewe.designpattern.adapterPattern.targetEx.Adapter;
import com.wewe.designpattern.adapterPattern.targetEx.ConcreteTarget;
import com.wewe.designpattern.adapterPattern.targetEx.ITarget;

public class AdapterClient {

  public static void main(String[] args) {
    ITarget adapter = new Adapter();
    adapter.request();

    ITarget target = new ConcreteTarget();
    target.request();
  }

}
