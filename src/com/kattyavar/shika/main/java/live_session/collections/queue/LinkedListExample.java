package com.kattyavar.shika.main.java.live_session.collections.queue;

import java.util.Deque;
import java.util.LinkedList;

public class LinkedListExample {

  public static void main(String[] args) {
    Deque<Integer> deque = new LinkedList<>();

    deque.offer(11);
    deque.add(15);
    deque.offer(10);

    System.out.println(deque);

    //Diff between remove and poll. remove throw exception and poll return null...
    deque.remove();

    deque.poll();

    System.out.println(deque);
  }
}
