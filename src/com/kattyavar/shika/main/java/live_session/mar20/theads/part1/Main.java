package com.kattyavar.shika.main.java.live_session.mar20.theads.part1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Main {
  void test() throws InterruptedException {

    System.out.println("In Main method...");
    MyThread thread = new MyThread();

    //thread.setPriority();
    //thread.setDaemon(true);
    System.out.println("Before calling thread start...");

    thread.start();

    System.out.println("Now i will be waiting for thread to finish it job...");

    thread.join(1000);

    System.out.println("Main method over...");


    Thread t2 = new Thread(() -> System.out.println("I am in new thread"));
    t2.start();

  }

  public static void main(String[] args) throws Exception {

    ThreadExampleWithCallable t3 = new ThreadExampleWithCallable();

    FutureTask<Integer> futureTask = new FutureTask<>(t3);

    Thread callableThread = new Thread(futureTask);

    callableThread.start();

//    Integer returnValue = t3.call(); //This is blocking call..


    //  System.out.println("We got return value from thread as -> " + returnValue);

    while (futureTask.isDone()) {
      System.out.println("Task is still running.....");

      Thread.sleep(100);
    }


    Integer returnValue = futureTask.get();
    System.out.println("I got the value from the callable is -> " + returnValue);

    System.out.println("Main thread end ");

  }
}

class Temp {

  public Integer call() throws Exception {
    System.out.println("I am in callable method...");
    Thread.sleep(10000);
    return 1;
  }

}

class ThreadExampleWithCallable implements Callable<Integer> {
  @Override
  public Integer call() throws Exception {
    System.out.println("I am in callable method...");
    Thread.sleep(10000);
    return 1;
  }
}


class MyThread extends Thread {
  @Override
  public void run() {

    for (int i = 0; i < 10; i++) {
      System.out.println("I am in thread");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}