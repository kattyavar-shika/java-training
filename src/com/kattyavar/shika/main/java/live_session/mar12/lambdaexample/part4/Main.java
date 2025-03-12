package com.kattyavar.shika.main.java.live_session.mar12.lambdaexample.part4;

public class Main {
  public static void main(String[] args) {

    System.out.println("Lets start ....");
    OneParameter oneParameter = (input) -> {
      System.out.println("I am in lambda with input parameter as -> " + input);
    };

    oneParameter.harendra("");


    System.out.println("We are done with our job...");

    // AM : 6, 8, 11
    // HS, SS : 6, 11
    // AM : 6, 11

  }

  static void test(String input){
    System.out.println("I am in lambda with input parameter as -> " + input);
  }
}

interface OneParameter {

  void harendra(String input);
}
