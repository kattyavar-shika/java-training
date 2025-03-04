package com.kattyavar.shika.main.java.live_session.mar4.exception;

public class Main2 {


  public static void main(String[] args) {

    System.out.println("Before calling function ...");
    testMe();
    System.out.println("After calling function...");
  }


  static void testMe() {
    try {
      System.out.println("In try bock");
      System.exit(0);
      throw new RuntimeException("");
    }catch (Exception ex){

    }
    finally {
      System.out.println("In finally block...");
    }

  }
}
