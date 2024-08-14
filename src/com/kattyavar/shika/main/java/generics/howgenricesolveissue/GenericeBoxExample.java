package com.kattyavar.shika.main.java.generics.howgenricesolveissue;

public class GenericeBoxExample {
  public static void main(String[] args) {
    Box<Integer> integerBox = new Box<>(10);
    Box<String> stringBox = new Box<>("Test");

    System.out.println("Box integer Item = " + integerBox.getItem());
    System.out.println("Box String  Item = " + stringBox.getItem());
  }
}
