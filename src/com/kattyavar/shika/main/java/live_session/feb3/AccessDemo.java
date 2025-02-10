package com.kattyavar.shika.main.java.live_session.feb3;


import java.math.BigDecimal;

public class AccessDemo {
  public static void main(String[] args) {

    Base obj = new Derived();
    obj.getName("test");

  }
}

class Base {

  public String getName(Integer input){
    System.out.println("In base class -> String getName(Integer input)");
    return null;
  }
  public String getName() {
    System.out.println("In Base class -> public String getName");
    return "Default arg method getName";
  }

  public String getName(String name) {
    System.out.println("In Base class -> public String getName(String name)");
    return name;
  }
}
class Derived extends Base {

  @Override
  public String getName() {
    System.out.println("In Derived clas -> public String getName");
    return "Hello from Derived ... ";
  }

  @Override
  public String getName(String harendraSourabhInput){
    System.out.println("In derived class -> String getName(String name)");
    return "Hello world..";
  }

  public String getName(BigDecimal input){
    System.out.println("In Derived class -> String getName(BigDecimal input)");
    return null;
  }

  public String getHarendra(){
    System.out.println("In Derived Harendra...");
    return null;
  }

}
