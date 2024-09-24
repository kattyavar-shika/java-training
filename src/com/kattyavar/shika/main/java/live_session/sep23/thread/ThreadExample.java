package com.kattyavar.shika.main.java.live_session.sep23.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThreadExample {

  public static void main(String[] args) throws InterruptedException {

    List<String> list = new ArrayList<>();
    list.add("1");
    Iterator<String> it = list.iterator();

    while (it.hasNext()) {
      System.out.println(it.next());
    }


    //Using extends of Thread
    Task1 task1 = new Task1();
    task1.start();

    //Let have look implements Runnable.

    Thread task2FromRunnable = new Thread(new Task2());
    task2FromRunnable.start();

    //Using lambda

    Thread usingLambda = new Thread(() -> {
      System.out.println(" I am using lambda");
    });
    usingLambda.start();

    // If you want to sure wait for thread to get execution completed

    task1.wait();
    System.out.println("Task 1 finished .. or you can more action base on the requirement...");


  }
}

class Options {
  String getOptionName() {
    return "Default options";
  }
}

//If some how you want to extends from any exiting class then use Runnable interface.
class Task3 extends Options implements Runnable {
  @Override
  public void run() {

  }
}

class Task1 extends Thread {
  @Override
  public void run() {
    System.out.println(" I am extending from Thread...");
  }
}

class Task2 implements Runnable {

  @Override
  public void run() {
    System.out.println(" I am implements Runnable");
  }

  private class InnerToTask2 {

  }

  static class InnerToTask2StaticClas {

  }
}

 class Person {
  private String name;
  public String name1;
  protected String name2;
  String name3;
  static String nameStatic;

  void display() {
    String temp;
  }


  final void updateBankAccount() {

  }

}






























