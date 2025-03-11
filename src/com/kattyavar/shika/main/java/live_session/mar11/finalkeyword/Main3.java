package com.kattyavar.shika.main.java.live_session.mar11.finalkeyword;

public class Main3 {

  public static void main(String[] args) {

    Student obj = new Student();
    Student obj2 = new Student();

    // AM: 19 33 29, | 29
  }
}

class Student {

  private static String name = "dfdfdf";

  static {
    System.out.println("Hello I am in static block");
    name = "dfdfdfd";




  }


  public Student(String name) {
    this.name = name;
    System.out.println("I am in parameter constructor...");
  }

  public Student() {
    System.out.println("I am in default constructor...");
  }

  static {
    System.out.println("What to do think about me...");
  }
}


