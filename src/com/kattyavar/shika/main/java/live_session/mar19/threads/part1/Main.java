package com.kattyavar.shika.main.java.live_session.mar19.threads.part1;

public class Main {

  void usingThreadClassExample(){
    System.out.println("Hello World..." + Thread.currentThread().getId());

    System.out.println("Let create thread object");
    MyThread thread = new MyThread();
    thread.setFileName("fdkfdlfdkl.txt");
    //thread.setDaemon(true);
    System.out.println("Lets call thread start");

    thread.start();

    System.out.println("Main thread job is done...");

  }

  static void test(){
    for (int i = 0; i < 10; i++) {

      System.out.println("Hello world from thread... with count " + i);
      try {
        Thread.sleep(1000); // it will sleep for 1 second
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
  public static void main(String[] args) {

    MyThread thread = new MyThread();

    thread.start();

  }

  void usingRunnable(){
    //MyThreadUsingRunnableInterface myThreadUsingRunnableInterface = new MyThreadUsingRunnableInterface();

    Thread thread = new Thread( Main::test);

    System.out.println("Lets call thread start");


    thread.start();
    System.out.println("Main thread job is done...");
  }
}


class WithoutThread {

  public void run() {
    for (int i = 0; i < 10; i++) {

      System.out.println("Hello world from thread... with count " + i);
      try {
        Thread.sleep(1000); // it will sleep for 1 second
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

  }

}


class MyThread extends Thread {

  String filename;
  void setFileName(String fileName){
    this.filename = fileName;
  }

  @Override
  public void run() {
    System.out.println("I am trying to create the new thread... thread id = " + Thread.currentThread().getId());

    Thread t1 = new MyThread();
    t1.start();
    try {
      t1.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }
}

class MyThreadUsingRunnableInterface implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {

      System.out.println("Hello world from thread... with count " + i);
      try {
        Thread.sleep(1000); // it will sleep for 1 second
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}