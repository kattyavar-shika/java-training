package com.kattyavar.shika.main.java.live_session.feb18.anonymouseclass2;

public class AnonymouseClassExample {

  private static String name = "Static value";

  private String privateStr = " private values";

  public static void main(String[] args) {

    Greeting obj = new Greeting() {
      @Override
      public void greet() {

        //System.out.println("yes i can -> " + privateStr); // you can't access this...
        System.out.println("yes i can -> " + name);
        System.out.println("In Anonymous class");
      }
    };


    obj.greet();
  }


  void testme() {

    String input = "fdfd";

    Greeting obj = new Greeting() {
      @Override
      public void greet() {

        System.out.println(input);
        System.out.println("yes i can -> " + privateStr);
        System.out.println("yes i can -> " + name);
        System.out.println("In Anonymous class");
      }
    };

  }
}


interface Greeting {
  void greet();
}