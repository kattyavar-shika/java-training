package com.kattyavar.shika.main.java.trickquestion.collection;

import java.util.Arrays;
import java.util.List;

public class Question2 {
  public static void main(String[] args) {

    //Is Arrays.asList is really immutable ?  always use List.of as Arrays.asList has given set implementation.
    // due to this is not really immutable ...
    // List<Integer> list = Arrays.asList(2, 5, 7); // change Arrays.asList to List.of
    List<Integer> list = Arrays.asList(2, 5, 7);

    try {
      list.add(10);
    } catch (Exception e) {
      System.out.println("Un supported add");
    }

    try {
      list.set(2, 2);
    } catch (Exception e) {
      System.out.println("Un supported set");
    }

    System.out.println(list);


  }
}
