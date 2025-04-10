package com.kattyavar.shika.main.java.live_session.apr10.collection.part4;

import java.util.*;

public class Man {
  public static void main(String[] args) {
    //Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    new Stack<>();

    // Adding elements (Enqueue)

    queue.offerLast(10);
    queue.offerLast(20);
    queue.offerLast(30);
    queue.offer(40);


    System.out.println(queue);


  }

  static void pollAndPrintQueue(Queue<Integer> queue){
    System.out.println("Start of operation ");
    System.out.println("Trying to poll");
    System.out.println("Poll item = " + queue.poll());

    System.out.println("Have look at remaing queue as below");
    System.out.println(queue);
    System.out.println("End of operation ");
    System.out.println();

  }
}
