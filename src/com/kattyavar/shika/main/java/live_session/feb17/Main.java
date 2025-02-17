package com.kattyavar.shika.main.java.live_session.feb17;

public class Main {
  public static void main(String[] args) {

    A obj = new Derived(); /// Derived + A + B
    obj.withAOnly(); // 43
   // obj.withBOnly(); // Compiler ...

    B bobj = (B) obj;

    bobj.withBOnly(); // 54
    //bobj.withAOnly(); // compiler error...


    Derived dObj = new Derived();

    dObj.withAOnly(); // 55
    dObj.withBOnly(); //64




  }
}























interface A {
  default void hello() {
    System.out.println("In Interface A hello method");
  }

 default void withAOnly(){
    System.out.println("With A only ");
  }
}

interface B {
  default void hello() {
    System.out.println("In Interface B hello method");
  }
  default void withBOnly(){
    System.out.println("With B only...");
  }
}
class Derived implements A, B {
  @Override
  public void hello() {
    B.super.hello();
    //A.super.hello();
    //System.out.println("I will take charge and i will do anything what is want...");
  }
}






















