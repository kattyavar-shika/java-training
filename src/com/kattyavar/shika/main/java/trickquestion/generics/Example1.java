package com.kattyavar.shika.main.java.trickquestion.generics;

import java.util.ArrayList;
import java.util.List;

public class Example1 {
  List<String> lst;

  public static void main(String[] args) {
    Derived<String> derivedVar = new Derived<>();
    derivedVar.remove("1");

    Base<String> baseVar = new Derived<>();
    baseVar.remove("1");


    //List<Integer> integers = new ArrayList<>();  // As List has remove(Object) and remove(int)
    //Collection<Integer> integers = new ArrayList<>(); // but here we have only remove(Object)
    var integers = new ArrayList<>(); // var integers type is here ..java.util.ArrayList. Note. This give the type of actual object.

    System.out.println("Data type " + integers.getClass().getName());

    integers.add(5);
    integers.add(10);
    integers.add(11);
    integers.add(1);

    System.out.println("Array :" + integers);
    integers.remove(1);
    System.out.println("After remove array " + integers);


  }


}


class Base<T> {
  private T name;


  void remove(T obj) {
    System.out.println("in Base remove...");
  }


  @Override
  public String toString() {
    return "Base{" +
      "name=" + name +
      '}';
  }
}

class Derived<T> extends Base<T> {

  @Override
  void remove(T obj) {
    System.out.println(" in Derived removed ...");
  }
}