package com.kattyavar.shika.main.java.live_session.apr21.stream.part3;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    List<Long> numbers = new ArrayList<>();
    for (long i = 1; i <= 100000000L; i++) {
      numbers.add(i);
    }


    long startTime = System.currentTimeMillis();

    long sequentialSum = numbers
      .stream()
      .mapToLong(Long::longValue)
      .sum();

    long endTime = System.currentTimeMillis();

    long timeTaken = endTime - startTime;

    long startParallel = System.currentTimeMillis();

    long parallelSum = numbers
      .parallelStream()
      .mapToLong(Long::longValue)
      .sum();

    long endParallel = System.currentTimeMillis();

    long timeTakenParallel = endParallel - startParallel;

    System.out.println("Seq item took " + timeTaken);
    System.out.println("Parallel  item took " + timeTakenParallel);



  }
}
