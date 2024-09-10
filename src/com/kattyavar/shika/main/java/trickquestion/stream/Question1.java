package com.kattyavar.shika.main.java.trickquestion.stream;

import java.util.List;
import java.util.stream.Stream;

public class Question1 {

  public static void main(String[] args) {

    //Why we get output as 0 0 0
    int[] factor = new int[]{2};

    var numbers = List.of(1, 2, 3);

    Stream<Integer> integerStream = numbers
      .stream()
      .map(x -> x * factor[0]); // this is not pure function... Closures will work correctly in case of normal variable. but with
    // array element compiler is not helping us...

    factor[0] = 0;

    integerStream
      .forEach(System.out::println);


  }
}
