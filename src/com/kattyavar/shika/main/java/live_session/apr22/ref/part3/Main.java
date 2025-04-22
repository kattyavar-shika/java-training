package com.kattyavar.shika.main.java.live_session.apr22.ref.part3;

public class Main {
  public static void main(String[] args) {
    Object obj = "Hello111";

    String result = switch (obj) {
      case String s when s.length() > 5 -> "Long string";
      case String s -> "Short string";
      case Integer i -> "Integer";
      default -> "Something else";
    };


    System.out.println("REsult  ===>" + result);


  }
}
