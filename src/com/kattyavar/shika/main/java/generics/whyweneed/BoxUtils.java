package com.kattyavar.shika.main.java.generics.whyweneed;

public class BoxUtils {
  public static void printBoxContent(Object box) {

    if (box instanceof IntegerBox) {
      System.out.println((((IntegerBox) box).getItem()));
    } else if (box instanceof StringBox) {
      System.out.println(((StringBox) box).getItem());
    } else {
      System.out.println("Unknown box type..." + box.getClass().getName());
    }
  }
}
