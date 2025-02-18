package com.kattyavar.shika.main.java.live_session.feb18.nonstaticinnerclass;

public class InnerClassExample {
  public static void main(String[] args) {
    OuterClass obj = new OuterClass();
    //Creation of inner class
    //OuterClass.InnerClass innerObj = obj.new InnerClass();
    OuterClass.InnerClass innerObj = obj.getInnerClass();
    innerObj.display();

  }
}

class OuterClass {

  private String privateStr;
  public String publicStr;
  protected String protectedStr;
  String defaultStr;
  static String staticStr;
  final String finalStr = "dfdfd";

  public OuterClass() {
    privateStr = "private value";
    publicStr = "public value";
    protectedStr = "protected value";
    defaultStr = "Default value";
    staticStr = " static vlaue ";
  }

  private void outerClassDisplayMethod() {
    System.out.println(" I am in outer class private method...");
  }

  InnerClass getInnerClass (){
    return new InnerClass();
  }

 public class InnerClass {
    public InnerClass() {
    }

    public void display() {
      privateStr = privateStr + " Updated by inner class";
      System.out.println("in Inner class ...");
      System.out.println(privateStr);
      System.out.println(publicStr);
      System.out.println(protectedStr);
      System.out.println(defaultStr);
      System.out.println(staticStr);
      System.out.println(finalStr);
      outerClassDisplayMethod();
    }
  }


}