package com.kattyavar.shika.main.java.live_session.sep9.lambdas;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LambdaExample4 {


  static void closurExample(Integer input, Consumer<Integer> consumer) {
    consumer.accept(input);

  }

  public static void main(String[] args) {

    int i = 30;
    Consumer<Integer> consumer = (a) -> System.out.println(a + i);
    //Consumer<Integer> consumer = (a) -> System.out.println(a + 30);
    closurExample(10, consumer);

    Thread thread = new Thread(new RunnableImpl());

    Thread thread1 = new Thread(() -> System.out.println("I am using lambda..."));


    List<Integer> lst = List.of(1, 2, 3, 6, 99, 20);

    lst
      .parallelStream()
      .map(x -> x * 2)
      .collect(Collectors.toList());

  }
}

class RunnableImpl implements Runnable {
  @Override
  public void run() {
    System.out.println(" My run method...");

  }
}