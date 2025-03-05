package com.kattyavar.shika.main.java.live_session.mar5.generic;

import java.util.List;

public class GenericsExample {
  public static void main(String[] args) {

    String input1 = "fdfd";
    Integer input2 = 10;
    //Person personObj = new Person("dfdf");

    Utitlty.useThis(null);

  }
}


class Utitlty {

  static public <T extends DemoInterface> T useThis(T input) {

    //business logic..
    System.out.println("In genric method..");
    return input;
  }

  public static void addValue(List<? super Integer> box) {


  }
}

class Base {

}

class Derived extends Base {

}

class Person {
  private String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

interface DemoInterface {
  void display();

  void display2();
}

class DemoInterfaceImpl implements DemoInterface {
  @Override
  public void display() {

  }

  @Override
  public void display2() {

  }
}


class Box<T extends DemoInterface> {
  private T value;

  public void setValue(T value) {
    value.display();

    this.value = value;
  }

}

