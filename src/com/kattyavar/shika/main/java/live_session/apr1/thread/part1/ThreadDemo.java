package com.kattyavar.shika.main.java.live_session.apr1.thread.part1;

import com.kattyavar.shika.main.java.live_session.thread.ThreadExample;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo {

  static void threadDemoPlatformExample(){

    for (int i = 0; i < 100000; i++) {
      Thread thread = new Thread(new WorkerThread(i));
      thread.start();
    }


  }
  public static void main(String[] args) throws InterruptedException {

    List<Thread> threads = new ArrayList<>();

    for (int i = 0; i < 100000; i++) {

      Thread thread = Thread.ofVirtual()
        .start(new WorkerThread(i));
      threads.add(thread);

      //Thread thread = new Thread(new WorkerThread(i));
      //thread.start();
    }

    for(Thread thread :threads) {
      thread.join();
    }

  }
}

class WorkerThread implements Runnable {

  long myThreadId;

  public WorkerThread(long myThreadId) {
    this.myThreadId = myThreadId;
  }

  @Override
  public void run() {
    System.out.println("My manual id = " + myThreadId +  ", Thread started With thread id " + Thread.currentThread().threadId());
    try {
      Thread.sleep(30000); // hard coded sleep... 30 seconds...
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("My manual id = " + myThreadId +  ", Thread completed With thread id " + Thread.currentThread().threadId());
  }
}
