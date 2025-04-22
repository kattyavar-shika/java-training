package com.kattyavar.shika.main.java.live_session.apr22.ref.part1;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Main {
  public static void main(String[] args) {

    Person obj = new Person("p1");
    SoftReference<Person> weakReference = new SoftReference<>(obj);


    System.out.println("Original object => " + obj);
    System.out.println(weakReference.get());

    obj = null;

    System.gc(); // suggestion to jvm to run GC ...

    System.out.println("Now try to access weak ref " + weakReference.get());


  }

}

class Person {
  String name;

  public Person(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person{" +
      "name='" + name + '\'' +
      '}';
  }
}
