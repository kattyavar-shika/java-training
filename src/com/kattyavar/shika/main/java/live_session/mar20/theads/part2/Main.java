package com.kattyavar.shika.main.java.live_session.mar20.theads.part2;

import javax.sound.midi.Soundbank;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
  public static void main(String[] args) throws InterruptedException {


    Counter counter = new Counter();

    Counter counter1 = new Counter();


    Thread[] threads = new Thread[1000];

    for (int i = 0; i < 1000; i++) {
      threads[i] = new Thread(() -> {
        counter.increment(); // 999 waiting sate 1 in execution state
        counter1.increment(); // 999 waiting sate 1 in execution state
      }

        // t1 -> counter.increment(); // 999 waiting sate t1 in execution state


        // t1 -> counter1.increment();
      );
      threads[i].start();
    }


    for (Thread thread : threads) {
      thread.join();
    }

    System.out.println("Final counter value is -> " + counter.getCount());

    Counter cnt1 = new Counter();


    Counter cnt2 = new Counter();


    ExecutorService service =  Executors.newFixedThreadPool(10);

    Runnable task = () -> System.out.println("Task 1");
    Runnable task2 = () -> System.out.println("Task 2");


    service.submit(task);
    service.submit(task2);

    service.submit(() -> System.out.println("New Task "));

    //Wait for all task to finish...
    service.shutdown();







  }


}

class Counter {
  private int count = 0;
  private static Integer countStatic = 0;

  public synchronized static void incrementStatic(){

    countStatic++;
  }
  public  void increment() {
    System.out.println("This code is not synchronized ....");
    synchronized (this) {
      System.out.println("But This code is synchronized ....");
      count++;
    }

    System.out.println("even this..This code is not synchronized ....");
  }

  public int getCount() {
    return count;
  }


  void demo (){
    synchronized (this) {
      demo();
    }
  }
}
