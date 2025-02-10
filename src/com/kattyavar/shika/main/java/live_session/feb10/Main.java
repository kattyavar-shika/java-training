package com.kattyavar.shika.main.java.live_session.feb10;

public class Main {
  public static void main(String[] args) {


    A obj = new B();


    A objB = new B();

    objB.display(); // ---  AJ : 18, H: 31, S : error 31
    //objB.onlyWithClassA(); // --- 23
    // objB.onlyWithClassB(); // --- AJ: C Error,  H:C Error, S: R time error, P:  Compile time error..

  }
}

class A {
  void display() {
    System.out.println("Class A :: display --"); // he / she tring to save to to flat file...
  }

  void display(Integer input) {
    System.out.println("A display... with Integer input...");
  }

  void onlyWithClassA() {
    System.out.println("Class A :: onlyWithClassA");
  }
}

class B extends A {

  @Override
  void display() {
    System.out.println("Class B :: display --"); // I will store in db.. , cloud..., will it other service...
  }

  void onlyWithClassB() {
    System.out.println("Class B :: onlyWithClass B");
  }
}


class C extends B {



  @Override
  void display(Integer input) {

    System.out.println("In c :: display (Integer)..");
  }

  @Override
  void onlyWithClassB() {
    System.out.println("in C :: onlyWithClassB ");
  }

  void onlyWithClassC() {
    System.out.println("in C :: onlyWithClassC");
  }
}





class AA {
  void display() {}

}
class BB extends AA {
 void display(Integer a){}
}


















