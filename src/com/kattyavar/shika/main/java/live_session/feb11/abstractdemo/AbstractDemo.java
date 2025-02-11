package com.kattyavar.shika.main.java.live_session.feb11.abstractdemo;

public class AbstractDemo {
  public static void main(String[] args) {

    Base obj = new Derived();

    obj.display();





  }
}

abstract class Base {

  Integer calculateDiscount() {

    return 0;
  }

  void display(){
    System.out.println("I am in displayl... ");
    System.out.println("I can add anything over here.. ");
  }

}

class Derived extends Base {

}
