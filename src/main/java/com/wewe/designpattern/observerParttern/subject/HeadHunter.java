package com.wewe.designpattern.observerParttern.subject;

public class HeadHunter extends AbstractHR {

  @Override
  public void publishJob(String job) {
    allTalents.forEach(talent -> talent.newJob(job));
  }

}
