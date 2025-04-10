package com.kattyavar.shika.main.java.live_session.apr10.collection.part2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
  public static void main(String[] args) {

    //Map<Object, Integer> map = new ConcurrentHashMap<>();
    //Map<Object, Integer> map = new HashMap<>();
    //Map<Object, Integer> map = new TreeMap<>();
    Map<Object, Integer> map = new WeakHashMap<>();

    // Adding key-value pairs
    map.put("Apple", 1);
    map.put("Banana", 2);

    // Simulating the behavior of weak references by nullifying a key reference
    Object key = new String("Cherry");  // This creates a non-interned string
    map.put(key, 3);

    System.out.println(map);

    key = null;

    System.gc();

    System.out.println(map);
  }
}
