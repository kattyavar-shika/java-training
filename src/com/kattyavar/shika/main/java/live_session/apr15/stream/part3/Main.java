package com.kattyavar.shika.main.java.live_session.apr15.stream.part3;

import java.util.List;

public class Main {
  public static void main(String[] args) {

    List<Integer> numbers = List.of(2,3,1);

/*
     Map<Integer, Integer> result = numbers.stream()
      .takeWhile(n -> n < 4)  // Take while numbers are less than 4
      //.forEach(x -> System.out.println(x));
      .collect(Collectors.toMap(x -> x, x->x));

 */

    /*
    int sum = Stream.of(1, 2, 3)
    .reduce(0, Integer::sum);  // Output: 6
     */


    Long total = numbers
      .stream()
      .count();


    System.out.println("Count of element in stream " + total);


  }
}
