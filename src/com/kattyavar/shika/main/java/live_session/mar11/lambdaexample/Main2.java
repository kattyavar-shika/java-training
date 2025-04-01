package com.kattyavar.shika.main.java.live_session.mar11.lambdaexample;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

  String name;
  void testMe(){
    TestExample obj = (a, b) -> this.name;
  }
  public static void main(String[] args) {

    TestExample obj = (a, b) -> "";

    TestExample obj2 = new TestExample() {
      private String name;

      @Override
      public String applyOperation(String input, Integer input2) {
        return "helloo...." + this.name;
      }
    };

  }
}

class Test {
  // I hope you can read me ...

  List<String> list = new ArrayList();

  void test(){
    list.add("New string item");


  }

  void display(){
    System.out.println(list);
  }

}

interface TestExample {
  String applyOperation(String input, Integer input2);

  static void testMe() {

  }

  private void voidCanIHaveThis() {

  }

  default void canWeHaveDefaultmethod() {

  }
}

