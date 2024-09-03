package com.kattyavar.shika.main.java.reflections.sampleexampleofhowautowirework;

public class MyController {

  @Inject
  private MyService myService;

  public void printMessage() {
    System.out.println(myService.getServiceMessage());
  }
}
