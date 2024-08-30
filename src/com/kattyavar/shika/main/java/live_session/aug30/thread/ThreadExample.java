package com.kattyavar.shika.main.java.live_session.aug30.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadExample {

  static void threadExample() throws InterruptedException {
    Task1 task1 = new Task1();
    Task2 task2 = new Task2();
    task1.start();
    task2.start();

    System.out.println("I am waiting for my all thread to get finish...");
    task1.join();
    task2.join();
    System.out.println("My all thread to get finish....");
  }

  public static void main(String[] args) throws InterruptedException {

    List<BackendCall> threads = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      BackendCall obj = new BackendCall("GET http://google.co.in/index/" + i);
      obj.start();
      threads.add(obj);
    }

    for (BackendCall obj : threads) {
      obj.join();
    }
    System.out.println("We are doing calling with 5 End points...");

  }


}


class BackendResponse {
  //kdjfkldfjkldjf
}


class BackendCall  extends Thread {
  String url;

  public BackendCall(String url) {
    this.url = url;
  }

  @Override
  public void run() {
    System.out.println("Calling backend call with url ==> " + url + " with Thread id " + Thread.currentThread().getId());
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Got the backend call  response with url ==> " + url+ " with Thread id " + Thread.currentThread().getId());
  }
}

class Task1 extends Thread {

  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Reading book page number " + i);
      try {
        sleep(2000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public void anotherMethod() {

  }

}

class Task2 extends Thread {

  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Washing cloth number " + i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

}