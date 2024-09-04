package com.kattyavar.shika.main.java.enumexample;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapExample {
  public static void main(String[] args) {
    Map<Color, String> map = new EnumMap<>(Color.class);

    map.put(Color.BlUE, "It is blue");
    map.put(Color.WHITE, " it is while. you can put anything... as value.");

    System.out.println(map);

    //Let us another enum class with custom attributes

    EnumMap<ColorWithPrice, String> mapWithCustomAttribute = new EnumMap<>(ColorWithPrice.class);
    mapWithCustomAttribute.put(ColorWithPrice.RED, "Red values");

    System.out.println(mapWithCustomAttribute);

  }
}
