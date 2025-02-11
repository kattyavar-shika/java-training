package com.kattyavar.shika.main.java.live_session.feb11.staticandvar;

public class Main {
  public static void main(String[] args) {

    Base obj = new Derived();

    obj.display(); // H : 14, S :14 , A: 14
  }
}

class Base {
  static public void display() {
    System.out.println("In Base :: display...");
  }

  public void calcuateDiscount() {
    //TODO implement this...
  }
}

class Derived extends Base {

  static public void display() {
    System.out.println("In Derived :: display...");
  }

  @Override
  public void calcuateDiscount() {
    super.calcuateDiscount();
  }
}
