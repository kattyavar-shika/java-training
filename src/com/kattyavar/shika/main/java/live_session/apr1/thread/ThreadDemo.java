package com.kattyavar.shika.main.java.live_session.apr1.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {


  static void ThreadPoolExample(){
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    for(int i =0; i< 10; i++){
      System.out.println("Added task to executorService with task id " + i);
      executorService.submit(new WorkerThread(i));
    }

   executorService.shutdown();
  }

  static void withPlatformThreadExample() {
    for (int i = 0; i < 100000; i++) {
      Thread thread = new Thread(new WorkerThread(i));
      thread.start();
    }

    System.out.println("End of main program..");

  }

  static void withVirtualThreadExample() throws InterruptedException {
    List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < 100000; i++) {
     Thread thread =  Thread.ofVirtual()
       //.name("WorkerThread-" + i)
       .start(new WorkerThread(i));
     threads.add(thread);
    }

    System.out.println("End of main program..");

    for(Thread thread : threads){
      thread.join();
    }

  }
  public static void main(String[] args) throws InterruptedException {
    ThreadPoolExample();

  }
}


class WorkerThread implements Runnable {

  int threadCnt;

  public WorkerThread(int threadCnt) {
    this.threadCnt = threadCnt;
  }

  @Override
  public void run() {

    System.out.println("Manual Thread count " + threadCnt + " => " + Thread.currentThread().getName() + " Thread started ..." + Thread.currentThread().threadId());
    try {
      Thread.sleep(1000);
      System.out.println("Manual Thread count " + threadCnt + " => " + Thread.currentThread().getName() + " Thread completed ..." + Thread.currentThread().threadId());
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }
}