package com.kattyavar.shika.main.java.live_session.collections.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {
  public static void main(String[] args) {
    Deque<Integer> arrayq = new ArrayDeque<>();

    //Adding element at the end...
    arrayq.add(11);
    arrayq.add(10);
    System.out.println(arrayq);

    //adding element in front of queue..

    arrayq.offerFirst(15);
    System.out.println(arrayq);

    //Adding element end of the queue as good as add
    arrayq.offerLast(16);

    System.out.println(arrayq);

    //Lets remove the from the front

    System.out.println("Element removed " + arrayq.poll());

    System.out.println(arrayq);

    //Similarly we can remove from the end as well.

    //we have pollFirst is same as poll.
    System.out.println("Element removed from end .." + arrayq.pollLast());
    System.out.println(arrayq);

  }
}
