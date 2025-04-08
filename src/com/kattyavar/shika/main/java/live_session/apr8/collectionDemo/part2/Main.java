package com.kattyavar.shika.main.java.live_session.apr8.collectionDemo.part2;

import java.util.HashMap;
import java.util.Map;

public class Main {

  static void test() {
    Map<String, String> map = new HashMap<>();

    map.put("abc", "abc value");
    map.put("abc", "new value abc value");

  }

  static final int hash(Object key) {
    int h;
    return key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
  }

  static void demo2() {

    Map<Test, String> map = new HashMap<>();

    Test obj = new Test("abc");


    Test obj1 = obj;
    Test obj2 = obj;

    map.put(obj1, "abc value");
    map.put(obj2, "new value abc value");


    System.out.println("let try to find hash of obj1 " + hash(obj1));
    System.out.println("let try to find hash of obj2 " + hash(obj2));


    System.out.println("Bucket info for obj1 = " + (16 - 1 & hash(obj1)));
    System.out.println("Bucket info for obj2 = " + (16 - 1 & hash(obj2)));

    System.out.println(map);

  }

  public static void main(String[] args) {

    Map<String, Test> map = new HashMap<>();

    map.put("abc", new Test("abc"));

    System.out.println("Before updating to null values ...");

    System.out.println(map);
    map.put("abc", null);

    System.out.println("after nulll");

    System.out.println(map);


    map.put(null, new Test("hell world"));
    map.put(null, new Test("hell world 2"));

    System.out.println(map);

  }
}


class Test {
  String name;

  public Test(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public String toString() {
    return "Test{" +
      "name='" + name + '\'' +
      '}';
  }
}
