package com.kattyavar.shika.main.java.collections.listexample;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {

  static void basicOperation() throws InterruptedException {
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3); //Bounded queue

    BlockingQueue<String> blockingQueueLink = new LinkedBlockingQueue<>(3); //Bounded queue
    BlockingQueue<String> blockingQueueLink2 = new LinkedBlockingQueue<>(); //Un Bounded queue

    System.out.println("Put First");
    blockingQueue.put("First");
    System.out.println(blockingQueue);
    System.out.println("Put Second");
    blockingQueue.put("Second");
    System.out.println(blockingQueue);
    System.out.println("Put Third");
    blockingQueue.put("Third");
    System.out.println(blockingQueue);
    System.out.println("let add forth ");
    blockingQueue.put("Four"); // This will get block until some one read the data from queue.
    System.out.println("Let see if you can see this..");


    //Method ..
    //put blocks until an queue has some space
    //Offer will not wait and return false in case queue is full
    // offer with timeOut wait till timeout
    // add it wil throw error in case queue is full

  }

  public static void main(String[] args) throws InterruptedException {

    // basicOperation();
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
    //BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
    Thread provider = new Thread(() -> {

      while (true) {
        long time = System.currentTimeMillis();
        try {
          System.out.println("Provide : " + time + " " + Thread.currentThread().getName());

          //put will block until there space to put..
          blockingQueue.put(" " + time);

          //Option 2
          //This will not block but if queue is full then it throw exception IllegalStateException.
          //blockingQueue.add("data");

          //Option 3
          //This is non blocking call. if it put you will get true or you will get false.
          //blockingQueue.offer("Data");

          //Option 4
          //This will block for 1 second time if no space.
          // after the timeout if still not abel to put then it will return false
          // and it throws InterruptedException
          //blockingQueue.offer("data", 1, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
          System.out.println("Error : Unable to put item.");
        }
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });


    Thread newThread = new Thread(){
      @Override
      public void run() {
        super.run();
      }
    };

    Thread consumer = new Thread(() -> {

      while (true) {
        try {
          //This is blocking call. blocks until an element become available
          String input = blockingQueue.take();
          System.out.println("Consumed : " + input + " " + Thread.currentThread().getName());

          //Option 2
          //This is non blocking call. if queue is empty it will return null.
          //blockingQueue.poll();

          //Option 3

          // if queue is empty it will wait for 1 seconds (As given time out) fro an element to become available.
          //Other wise you will get null if time expire and queue is empty.
          //In case of interrupt you will get Exceptions
          //blockingQueue.poll(10, TimeUnit.SECONDS);


        } catch (InterruptedException e) {
          System.out.println("Error : Unable to put item.");
        }
        try {
          Thread.sleep(10000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });

    provider.start();
    consumer.start();


    //Note :
    /**
     * Non-Daemon Threads: By default, threads in Java are non-daemon.
     * If there are any non-daemon threads still running, the JVM will not terminate.
     * This means your provider and consumer threads will keep the application alive because they are non-daemon threads.
     * To create daemon Thread.  provider.setDaemon(true); this case jvm will not wait and program will be terminated.
     *     provider.setDaemon(true);
     *     consumer.setDaemon(true);
     */
    System.out.println("Main program finished..." + Thread.currentThread().getName());

  }


}

