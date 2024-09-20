package com.kattyavar.shika.main.java.live_session.sep20;

public class InternExample {
  public static void main(String[] args) {

    String str1 = "Patil";
    String str2 = new String("Patil");
    String str3 = "Patil";

    String str4 = str2.intern();

    System.out.println("Str1 == str3 " + (str1 == str3));
    System.out.println("Str1 == str2 " + (str1 == str2));

    System.out.println("Str1 == str4 " + (str1 == str4));

  }
}
