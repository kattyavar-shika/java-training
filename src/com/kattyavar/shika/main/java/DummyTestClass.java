package com.kattyavar.shika.main.java;

public class DummyTestClass {
  public static void main(String[] args) {


  }

  static void testTryCatchWithSystemExit() {
    System.out.println("Calling method");
    testFinallyInCaseOfReturn();
    System.out.println("Method called");

  }

  static String testFinallyInCaseOfReturn() {

    try {
      System.out.println("In try block");
      System.exit(1);
      return null;
    } catch (Exception e) {
      System.out.println(" In Catch block");
    } finally {
      System.out.println("In finally block..");
    }

    return null;
  }
}
