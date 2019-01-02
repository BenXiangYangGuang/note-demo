package com.wewe.designpattern.observerParttern.subject;

import com.wewe.designpattern.observerParttern.observer.ITalent;
import com.wewe.designpattern.observerParttern.observer.ITalent;

import java.util.ArrayList;
import java.util.Collection;


public abstract class AbstractHR {

  protected Collection<ITalent> allTalents = new ArrayList<ITalent>();

  public abstract void publishJob(String job);

  public void addTalent(ITalent talent) {
    allTalents.add(talent);
  }

  public void removeTalent(ITalent talent) {
    allTalents.remove(talent);
  }

}
