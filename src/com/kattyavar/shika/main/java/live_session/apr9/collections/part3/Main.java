package com.kattyavar.shika.main.java.live_session.apr9.collections.part3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

  public static void main(String[] args) {

    Map<MyKey, String> map = new HashMap<>();

    //map.put()
    //map.get()
    //map.getOrDefault()


    map.put(new MyKey(), "var1");
    map.put(new MyKey(), "var2");
    map.put(new MyKey(), "var3");

    System.out.println(map);

    map.forEach((k, v) -> {
      System.out.println(k + " => " + v);
    });

    map.keySet();

    map.entrySet();


    Map<String, Map<MyKey, Map<String, Map<Integer, Integer>>>> map1;

  }
}

class MyKey {


  String var1;
  String var2;

  @Override
  public boolean equals(Object o) {
    return false;
  }

  @Override
  public int hashCode() {
    return 1;
  }

  @Override
  public String toString() {
    return "MyKey{" +
      "var1='" + var1 + '\'' +
      ", var2='" + var2 + '\'' +
      '}';
  }
}
