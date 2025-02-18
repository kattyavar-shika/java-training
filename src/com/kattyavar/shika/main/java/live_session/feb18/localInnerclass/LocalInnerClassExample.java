package com.kattyavar.shika.main.java.live_session.feb18.localInnerclass;

public class LocalInnerClassExample {

  public static void main(String[] args) {

  }
}

class Outer {

  void letTryThis(String input1){
    final String temp = "dfdfdf";
    String temp2 = "Effective final var";


    class LocalInnerClass {

      void display(){


        privateStr = privateStr + " Updated by inner class";
        System.out.println("in Inner class ...");
        System.out.println(privateStr);
        System.out.println(publicStr);
        System.out.println(protectedStr);
        System.out.println(defaultStr);
        System.out.println(staticStr);
        System.out.println(finalStr);

        System.out.println("Let try this... ");

        System.out.println(temp2);

        System.out.println(temp);

        System.out.println(input1);


      }

    }

    new LocalInnerClass();


  }

  private String privateStr;
  public String publicStr;
  protected String protectedStr;
  String defaultStr;
  static String staticStr;
  final String finalStr = "dfdfd";
}
