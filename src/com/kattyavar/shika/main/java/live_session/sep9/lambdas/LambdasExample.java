package com.kattyavar.shika.main.java.live_session.sep9.lambdas;

import java.util.List;
import java.util.stream.Stream;

public class LambdasExample {

  static int myVar = 0;

  public void executeTask(Action action) {
    /***
     * We can any other logic rather just doing system out println...
     * //System.out.println("I am working on task " + taskId);
     */

    action.execute();

  }

  static int noPureAdd(int x, int y) {
    myVar++;
    return x + y + myVar;
  }

  static int noPureV2Add(int x, int y) {
    myVar++;
    if (myVar > 5) {
      return x + y + myVar;
    }

    return x + y;
  }


  static int add(int x, int y) {
    return x + y;
  }


  static void whyWeNeedLambdas() {
    LambdasExample obj = new LambdasExample();
    obj.executeTask(new Task2());
    obj.executeTask(new Task4());

    obj.executeTask(new Action() {
      @Override
      public void execute() {
        System.out.println(" I m in annomus task ...class impl");
      }
    });


    System.out.println(add(3, 5));
    System.out.println(add(3, 5));
    System.out.println(add(3, 5));
    System.out.println(add(3, 5));
    System.out.println(add(3, 5));
    System.out.println(add(3, 5));
    System.out.println(add(3, 5));
    System.out.println(add(3, 5));
    System.out.println(add(3, 5));
    System.out.println(add(3, 5));
    System.out.println(add(3, 5));

    System.out.println("Lets have look at non pure functions ...");
    System.out.println(noPureAdd(3, 5));
    System.out.println(noPureAdd(3, 5));
    System.out.println(noPureAdd(3, 5));

    System.out.println("Lets have look at another example ...");
    System.out.println(noPureV2Add(3, 5));
    System.out.println(noPureV2Add(3, 5));
  }

  static void imperativeStyleExample() {
    List<Integer> abc = List.of(1, 2, 5, 6, 7, 8, 10);

    for (int i = 0; i < abc.size(); i++) {
      System.out.println(" we need to apply to process on item " + abc.get(i));

      int result = abc.get(i) * 2;

      System.out.println("Result = " + result);
    }


    Stream<Integer> integerStream = abc
      .stream()
      .map(x -> x * 2);


    for (int i = 0; i < abc.size(); i++) {
      System.out.println("Result =" + abc.get(i) * 2);

    }


    for (int item : abc) {
      System.out.println(item);
    }


    String str = "Amol";

    str = str + " patil"; // Amol patil

  }

  public static void main(String[] args) {

    LambdasExample obj = new LambdasExample();
    obj.executeTask(new Task2());
    obj.executeTask(new Task4());

    obj.executeTask(new Action() {
      @Override
      public void execute() {
        System.out.println(" I m in annomus task ...class impl");
      }
    });

  }

  public static void takeInputOne(String s) {
    System.out.println("we got input as " + s);
  }

  public static int addTowNumber(int x, int y) {
    return x + y;
  }

}

class Task2 implements Action {

  // i can have other method also, also i can have other data variables...
  @Override
  public void execute() {
    System.out.println("I am executing task 2...");
  }
}

class Task4 implements Action {
  @Override
  public void execute() {
    System.out.println("I am executing task executing task 4...");
  }
}