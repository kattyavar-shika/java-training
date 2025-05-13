package com.kattyavar.shika.main.java.live_session.apr28.clone.part2;

public class Main {
  public static void main(String[] args) {

    Person obj = new Person("Person name 1");

    //if i doing operation here it mean i am out side the class of person
    System.out.println(obj);

  }
}

class Person {
  private String name;

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
