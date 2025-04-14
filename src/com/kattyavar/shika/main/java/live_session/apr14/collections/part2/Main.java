package com.kattyavar.shika.main.java.live_session.apr14.collections.part2;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
  public static void main(String[] args) throws InterruptedException {

    //BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
    //BlockingQueue<String> queue = new LinkedBlockingQueue<>(3);
    BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    Thread t1 = new Thread(() -> {

      while (true) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        try {
          System.out.println("Reading from the queue " + queue.take());
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }

    });
    t1.start();

    System.out.println("Adding first element ");

    queue.put("s1");

    System.out.println("Queue = " + queue);

    System.out.println("Adding second element ");
    queue.put("s2");

    System.out.println("Queue = " + queue);

    System.out.println("Adding thrid element ");
    queue.put("s3");

    System.out.println("Queue = " + queue);


    System.out.println("Adding forth element ");
    queue.put("s4");

    System.out.println("Queue = " + queue);

    System.out.println("adding fiveth element ");
    queue.put("s5");

    System.out.println("Queue = " + queue);

    System.out.println("Main program ended... here...");

  }
}
