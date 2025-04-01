package com.kattyavar.shika.main.java.live_session.apr1.collectionsdemo.part3;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Part3 {

  void testDemo() {

    new WeakHashMap<>();
  }

  public static void main(String[] args) {

    ArrayList<String> arr = new ArrayList<>();


    //Adding element into list..
    arr.add("val1");
    arr.add("val2");
    arr.add("val3");

    //e for loop
    for (String val : arr) {
      System.out.println(val);
    }

    //Using index

    for (int i = 0; i < arr.size(); i++) {
      System.out.println(arr.get(i));
    }

    //How will i update it?

    arr.set(0, "New values of index 0");

    System.out.println("Please have look at updated values...");
    for (String val : arr) {
      System.out.println(val);
    }

  }
}
