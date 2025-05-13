package com.kattyavar.shika.main.java.live_session.apr28.clone.part1;

public class Main {

  public static void main(String[] args) throws CloneNotSupportedException {
    MyClass obj1 = new MyClass(10);
    MyClass obj2 = obj1.clone();

    obj2.value = 20;
    System.out.println(obj1);
    System.out.println(obj2);
  }
}

class MyClass   implements Cloneable {
  int value;

  public MyClass(int value) {
    this.value = value;
  }


  @Override
  protected MyClass clone() throws CloneNotSupportedException {
    return  (MyClass) super.clone();
  }

  @Override
  public String toString() {
    return "MyClass{" +
      "value=" + value +
      '}';
  }
}
