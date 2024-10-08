package com.kattyavar.shika.main.java.live_session.oct4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NullCheckExample {

  public static void main(String[] args) {
    System.out.println("I am about to die....");
    System.out.println(getPrototypeCar().getTimeStamp());

    System.out.println("I am still alive ");
  }


  static protected PrototypeCar getPrototypeCar() {
    return null;
  }
}


class PrototypeCar {
  private final String timeStamp;

  public PrototypeCar() {
    this.timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }

  public String getTimeStamp() {
    return timeStamp;
  }
}
