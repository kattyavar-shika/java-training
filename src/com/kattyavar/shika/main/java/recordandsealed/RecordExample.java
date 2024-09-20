package com.kattyavar.shika.main.java.recordandsealed;

import com.sun.security.jgss.GSSUtil;

public class RecordExample {

  public static void main(String[] args) {

    final String nullString = null;
    Person obj1 = new Person("p1", 22);
    Person obj2 = new Person("p1", 22);

    System.out.println(obj1); //Record give the toString by default
    System.out.println(obj2);

    if (obj1.equals(obj2)) { // record give hashCode and equal method by default.
      System.out.println("Both object are same");
    } else {
      System.out.println("Both object are not same.");
    }

    //Now let give some values as null .

    Person obj3 = new Person(null, null);
    System.out.println(obj3);


    System.out.println(obj3.name()); //as generally we have method as getName. but incase of record we just need to use member variable name and ();

    //You can access static variable as
    System.out.println(Person.staticVar);
    System.out.println(obj3.staticVar); // not recommended you Person.staticVar
  }

}


//With the record we get following by default
// All arg Constructor This is canonical constructor.
//All the member variable are define as final.
//You we get getter method for all member variable. Note: you won't get any setter method as member variable is final.
//You also get hashcode and equal method
//You also get toString method.
//You can not create record to extend any record or class
// but you can implement the interface

//You can also have static method.

record Person(String name, Integer age) {
  public static String staticVar = "StaticVar Value";

  //You can have validation check here... this is call as compact constructor.
  Person {
    System.out.println("in compact constructor ...");
    if (age != null && age < 18) {
      throw new IllegalArgumentException("age");
    }
  }

  
  Person(String name) {
    this(name, 21);
    System.out.println(name);
//    this.name = name; // this is not allowed
 //   this.age = 0; // This is not allowed

  }

  void setName(String name) { // you can define your custom functions...
    //this.name = name; // This is not allowed... here...
  }

  class Test {
    private String name;
  }

}

