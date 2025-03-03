package com.kattyavar.shika.main.java.live_session.mar3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionExample {

  public static void main(String[] args) {

    Test obj = new Test();
    //obj.displayWillThrowRunTimeException();

//    obj.checkThisExample();

    try {
      obj.tryThis();
    } catch (StackOverflowError e) {

      System.out.println("We have message .... " + e.toString());
      System.out.println("Are you able to see this message...");
    }

/*
    System.out.println("Any how this will work...");
    //AM, HS, SS : above wll get executed ...
    // AS -- above line will not get executed...
    try {
      obj.display();
      System.out.println("Will this get executed assuming obj.display throws exception..."); //HS, AM, SS : NO
      //
    } catch (Exception ex) {
      System.out.println("We have exception here ..." + ex.toString());
    }

    System.out.println("This line will never get executed if you don't use try catch...");

 */
  }
}

class LetsTryItOutWithoutExceptionClass extends RuntimeException {

}

class MyCustomException1 extends RuntimeException {

  // Constructor that accepts a custom error message
  public MyCustomException1(String message) {
    super(message);
  }
}


class MyCustomException extends Exception {

  // Constructor that accepts a custom error message
  public MyCustomException(String message) {
    super(message);
  }
}

class Test {

  private String name;

  void tryThis() {
    while (true) {
      tryThis();
    }
  }

  void checkThisExample() {

    try {
      BufferedReader br = new BufferedReader(new FileReader("exampledfdfdf.txt"));
    } catch (FileNotFoundException e) {
      //just for loging purpose...

      // throw e;
      System.out.println("We have error " + e.getMessage());

      throw new LetsTryItOutWithoutExceptionClass();
      // throw new RuntimeException(e);

    }


  }

  void displayWillThrowRunTimeException() throws RuntimeException {

    try {
      int a = 1 / 0;
    } catch (ArithmeticException ex) {
      //throw  ex;
      System.out.println(ex.getMessage());
      throw new RuntimeException(ex.getMessage());
    }
  }


  void display() throws Exception {
    Exception mye;
    System.out.println("Will this get printed before access to lenght on nulll");

    try {
      System.out.println("Length ==> " + name.length());
    } catch (NullPointerException ex) {
      throw new MyCustomException(ex.getMessage());
      // name.length();
    }

    System.out.println("What about this... ????"); //HS: This will not get executed ..


    //AM : this will get executed ..
    //SS : This will get executed..
  }

}