package com.kattyavar.shika.main.java.live_session.feb11;


public class Main {

  public static void main(String[] args) {

    Base obj = new Base();
    obj.readJava();
  }
}

class Base {

  protected String testMe(String input) {
    System.out.println("test me in base classs...");
    return input;
  }

  Human getPersonData() {
    return new Human();
  }

  final public String readJava() {
    return null;
  }

}

class Derived extends Base {

  @Override
  Human getPersonData() {
    //return new Male();
    return new FeMale();
  }

  @Override
  public String testMe(String x) {
    System.out.println(" i have override the testme function...");
    return null;
  }
  // The function should be present in base or any parent... it should be accessible...
  // access specifier...
  //return type should be the same.
  //Function should be the same
  //arg type should be the same

  //it should have same access specifier ...
}


class Human {

}

class Male extends Human {
}

class FeMale extends Human {
}



























