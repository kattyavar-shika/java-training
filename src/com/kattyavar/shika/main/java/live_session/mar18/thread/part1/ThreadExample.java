package com.kattyavar.shika.main.java.live_session.mar18.thread.part1;

public class ThreadExample {
  void test() {
    MyThread thread1 = new MyThread();
    MyThread thread2 = new MyThread();


    // Test test  = new Test();
    System.out.println("Calling run method....");
    //test.run();
    thread1.start();
    thread2.start();
    System.out.println("Run method is over....");

  }

  public static void main(String[] args) throws InterruptedException {

    Integer count = 10;
    MyThread obj = new MyThread();

    Thread myThreadObj = new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        System.out.println(" using lambda ...Thread id = " + Thread.currentThread().getId() + " value of loop is " + i);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

      }
    });

    MyRunnable myRunnable = new MyRunnable();

    Thread usingRunnable = new Thread(myRunnable);


    System.out.println("Calling obj run method...");
    //obj.run();
    obj.start();
    myThreadObj.start();
    usingRunnable.start();

    System.out.println("End of obj run method...");


  }
}


class Test {
  public void run() throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
      Thread.sleep(1000);
    }
  }
}

class MyRunnable implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {

      System.out.println(" Using Runnable interface Thread id = " + Thread.currentThread().getId() + " value of loop is " + i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

    }
  }
}


class MyThread extends Thread {

  String fileName;

  /*

  public MyThread(String fileName) {
    this.fileName = fileName;
  }


   */
  void setFileName(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void run() {
    System.out.println("Read this file ..." + fileName);
    for (int i = 0; i < 10; i++) {
      System.out.println(" Thread id = " + Thread.currentThread().getId() + " value of loop is " + i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

    }
  }
}