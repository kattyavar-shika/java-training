package com.kattyavar.shika.main.java.live_session.mar11.finalkeyword;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

  public static void main(String[] args) {

    Person obj = new Person();
    //AM : 17, 26, 22     //SS : 22     //    //HS: 22, 17, 26
  }
}

class Person {

  private final String name;
  private static String surName;

  public Person() {
    System.out.println("We are in Person default constructor...");
  }

  public Person(String name) {
    surName = "dfdfd";
  }

  public Person(String name, Integer age) {

    List<String> list = new ArrayList<>();

    for (String item : list) {
      System.out.println(item);
    }

  }


  {
    System.out.println("This is init block....");
    name = "Default value";
    surName = "dfdfd";
  }

  {
    System.out.println("What do you think about me.. by when i will get executed...");
  }
}
