package com.kattyavar.shika.main.java.live_session.feb18;

public class Main {

  public static void main(String[] args) {

    Outer outObj = new Outer();

    Outer.Inner innerObj = outObj.new Inner();

    Derived derivedObj = new Derived(outObj);

    derivedObj.display();


  }
}

class Base {
}

interface IA {

  class IABase {

    interface IC {}

    void display() {
      class InsideClass {

      }
      System.out.println("I am in side the interface....");
    }
  }

  interface IB {

  }
}

class Outer {

  class Inner extends Outer {
    void display() {
      System.out.println("In outer Inner class");
    }
  }
}


class Derived extends Outer.Inner {

  public Derived(Outer outer) {
    outer.super();
  }

  @Override
  void display() {
    System.out.println("Outside the world...");
  }
}