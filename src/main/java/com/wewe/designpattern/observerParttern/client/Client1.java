package com.wewe.designpattern.observerParttern.client;


import com.wewe.designpattern.observerParttern.observer.ITalent;
import com.wewe.designpattern.observerParttern.observer.JuniorEngineer;
import com.wewe.designpattern.observerParttern.observer.Architect;
import com.wewe.designpattern.observerParttern.observer.SeniorEngineer;
import com.wewe.designpattern.observerParttern.subject.AbstractHR;
import com.wewe.designpattern.observerParttern.subject.HeadHunter;

/**
 * 观察者模式:一个主题发生了变化,自动通知每一个观察者做update(),实现不同的观察者操作
 */
public class Client1 {

  public static void main(String[] args) {
    ITalent juniorEngineer = new JuniorEngineer();
    ITalent seniorEngineer = new SeniorEngineer();
    ITalent architect = new Architect();
    
    AbstractHR subject = new HeadHunter();
    subject.addTalent(juniorEngineer);
    subject.addTalent(seniorEngineer);
    subject.addTalent(architect);
    
    subject.publishJob("Top 500 big data position");
  }

}
