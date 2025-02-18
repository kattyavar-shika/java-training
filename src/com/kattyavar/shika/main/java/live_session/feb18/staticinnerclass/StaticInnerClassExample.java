package com.kattyavar.shika.main.java.live_session.feb18.staticinnerclass;

public class StaticInnerClassExample {
  public static void main(String[] args) {

    Outer.InnerClass obj = new Outer.InnerClass();
  }
}

class Outer {
  private String privateStr;
  public String publicStr;
  protected String protectedStr;
  String defaultStr;
  static String staticStr;
  final String finalStr = "dfdfd";

  private static String anotherStaticPrivate;


  static class InnerClass {

    public void display (){

      System.out.println(anotherStaticPrivate);

    }
  }
}
