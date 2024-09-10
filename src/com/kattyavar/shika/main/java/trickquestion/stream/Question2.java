package com.kattyavar.shika.main.java.trickquestion.stream;

import java.util.List;

public class Question2 {

  public static void main(String[] args) {
    List.of(1, 2, 3)
      .parallelStream()
      //.parallel()
      .map(number -> {
        System.out.println("Apply transformation: " + Thread.currentThread()); //Where will transform run ?
        return number;
      })
      .sequential()
      .forEach(System.out::println);


    //Note here ..
    //java 8 stream do not segment the pipeline for diff threading.
    //model. The last setting, before the terminal call. Overrides the entire pipeline.
    // Only Reactive stream does that..
  }
}
