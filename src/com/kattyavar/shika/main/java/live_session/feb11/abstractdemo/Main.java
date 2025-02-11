package com.kattyavar.shika.main.java.live_session.feb11.abstractdemo;

public class Main {
  public static void main(String[] args) {

    // Base1 obj = new Base1();
    //Derived1 obj = new Derived1();
    Base1 obj = new Derived1();

    obj.getVar();

    System.out.println(obj.abc); // 21

  }
}


class Base1 {
  public String abc = "From Base 1 var";

  String getVar(){
    return abc;
  }
}

class Derived1 extends Base1 {
  public String abc = "From Derived 1 var";

  @Override
  String getVar() {
    return abc;
  }
}