package com.kattyavar.shika.main.java.live_session.aug30.thread;

public class RaceConditionExample {
  public static void main(String[] args) throws InterruptedException {

    BackendCallCounter counter = new BackendCallCounter();

    Thread t1 = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        counter.callDone();
      }
    });
    Thread t2 = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        counter.callDone();
      }

    });
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println("Total call made so far " + counter.cnt);


  }
}

class BackendCallCounter {
  int cnt;

  //you can make method as synchronized
  // synchronized public void callDone() {
  // or you can make some specific code as synchronized ...
  //  synchronized (this) {
  //      cnt++;
  //    }

  public void callDone() {
    synchronized (this) {
      cnt++;
    }
  }
}

class SingleTone {
  static SingleTone obj;

  private SingleTone() {
  }

  static SingleTone getInstance() {
    Object obj1 = new Object();
    if (obj == null) {
      synchronized (obj1) {
        if (obj == null) {
          obj = new SingleTone();
        }
      }
    }
    return obj;
  }
}
