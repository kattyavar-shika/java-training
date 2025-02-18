package com.kattyavar.shika.main.java.live_session.feb18.anonymousinnerclass;

public class AnonymousInnerClass {
  public static void main(String[] args) {

    Greeting iObj = new Derived();
    iObj.greet();


    Base baseObj = new Base();


    baseObj = new Base() {
      @Override
      void display() {
        System.out.println("I am here .... with concere example...");

      }
    };

    AbstructGreeting obj3 = new AbstructGreeting() {

      @Override
      void greet() {
        System.out.println("In Abstruct Anonymous class...");
      }
    };


    Greeting iObj2 = new Greeting() {
      @Override
      public void greet() {

      }

      @Override
      public void greet1() {

      }

      @Override
      public void greet2() {

      }
    };

  }
}


class Base {

  void display() {
    System.out.println("In Base class... display method...");
  }
}


abstract class AbstructGreeting {
  abstract void greet();
}

interface Greeting {
  void greet();

  void greet1();

  void greet2();
}


class Derived implements Greeting {
  @Override
  public void greet() {

    System.out.println("In derived ...");
  }

  @Override
  public void greet1() {

  }

  @Override
  public void greet2() {

  }
}