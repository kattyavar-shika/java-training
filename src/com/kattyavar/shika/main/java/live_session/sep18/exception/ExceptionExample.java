package com.kattyavar.shika.main.java.live_session.sep18.exception;

import java.io.*;

public class ExceptionExample {

  static void finallyExample() {

    Emp obj = new Emp("e1", 11);
    //Emp obj = null;
    try {

      System.out.println("In Try block start");
      //We may have null pointer exception here.
      obj.name = "test";

      // we may have divide by zero error here..
      divide(2, 0);
      System.out.println("Try block end..");
    } catch (ArithmeticException e) {
      throw new InvalidAgeException("Age should be grether than zero");
      //throw new RuntimeException();
      //System.out.println("We have some error " + e.toString());
    } catch (NullPointerException ne) {
      System.out.println(ne);
    } catch (Exception ar) {
      System.out.println("We have got AR exception " + ar.toString());
    } finally {
      System.out.println("This will get executed in any case...");
    }
  }

  static void letCheckAnotherExample() {
    File file = new File("inputfile.txt");

    //divide(2, 0);
    try {
      FileReader fr = new FileReader(file);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

  }

  static void anotherFileExample() {

    String fileName = "inputfile.txt";
    BufferedReader br = null;
    try {
      FileReader fileReader = new FileReader(fileName);

      br = new BufferedReader(fileReader);

      String line;
      while ((line = br.readLine()) != null) {
        System.out.println("File line = " + line);
      }

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      //We need to make sure we need to close the BufferReader...
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

    }


  }

  static void anotherFileExampleUsingTryResource() {

    String fileName = "inputfile.txt";

    //Below will give you compiler error.
    /***
     *     try (String name = "Test") {
     *     }
     */

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println("File line = " + line);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  public static void main(String[] args) {
    finallyExample();

  }

  static int divide(int a, int b) {
    return a / b;
  }
}

class Emp {
  String name;
  Integer age;

  public Emp(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Emp{" +
      "name='" + name + '\'' +
      ", age=" + age +
      '}';
  }
}

class InvalidAgeException extends RuntimeException {
  public InvalidAgeException(String message) {
    super(message);
  }
}