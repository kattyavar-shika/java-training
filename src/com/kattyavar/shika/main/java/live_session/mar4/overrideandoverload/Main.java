package com.kattyavar.shika.main.java.live_session.mar4.overrideandoverload;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {


  }
}

class Test1 extends Base {

}

class Test {

  Base obj;

  void setObj(Base obj) {
    this.obj = obj;
  }

}

class Base {

  void testMe() {
    System.out.println("In Base class testMe without parameter ");
  }

  void testMe(String a) {
    System.out.println("In Base class testMe with string parameter ");

  }
}

class Derived extends Base {

  @Override
  void testMe() {
    System.out.println("Derived no parameter ");
  }

}