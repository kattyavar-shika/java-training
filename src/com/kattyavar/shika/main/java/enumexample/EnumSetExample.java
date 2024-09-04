package com.kattyavar.shika.main.java.enumexample;

import java.util.EnumSet;
import java.util.Set;

public class EnumSetExample {
  public static void main(String[] args) {
    //Option 1 to crate the set of Enum.
    Set<Color> colorEnumSet =  EnumSet.of(Color.BlUE);
    colorEnumSet.add(Color.WHITE);

    //It will add all .values() to set..
    EnumSet<ColorWithPrice> colorWithPricesSet = EnumSet.allOf(ColorWithPrice.class);

    //Or you can define the range base on ordinal

    System.out.println("EnumSet.of + add " + colorEnumSet);
    System.out.println("EnumSet.allOf " + colorWithPricesSet);

    System.out.println("Using range " + EnumSet.range(Color.RED, Color.RED));

  }
}
