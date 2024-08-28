package com.kattyavar.shika.main.java.live_session.aug28.queueexample;

import java.sql.SQLOutput;
import java.util.*;

public class ArrayDequeExample {

  static void simpleQueueUsingArrayDeque(){
    Queue<String> q = new ArrayDeque<>();

    q.add("Person 1");
    q.add("Person 15");
    q.add("Person 20");
    q.add("Person 30");

    System.out.println("Queue data " + q);

    System.out.println("we have taken item out side of queue " + q.poll());

    System.out.println("After pool queue data is " + q);

    System.out.println("let take next item from queue = " + q.remove());

    System.out.println("After remove queue data is " + q);

    System.out.println("let remove another one " + q.poll());

    System.out.println("Let have look at after pool =" + q);
    System.out.println(" let remove one more = " + q.poll());
    System.out.println("After pool queue is = " + q);

    System.out.println("Let try to remove from the empty one..." + q.poll());

    System.out.println("Let add some more element in queue ");
    q.add("patil");

    System.out.println("Queue data is =" + q);

    System.out.println("Let use pool = " + q.poll());

    System.out.println("Queue data is =" + q);

  }

  static void dequeExampleUsingLinkList(){

    Deque<String> q = new LinkedList<>();

    q.add("Person 1");
    q.add("Person 15");
    q.add("Person 20");
    q.add("Person 30");


    System.out.println("Queue data = " + q);

    //let add new element in queue

    q.offerFirst("Person VIP patil");

    System.out.println("Queue data = " + q);

    System.out.println("we have taken item out side of queue " + q.poll());

    System.out.println("Queue data = " + q);

    System.out.println("Let remove from the last = " + q.pollLast());

    System.out.println("Queue data = " + q);
  }

  public static void main(String[] args) {

    Deque<String> stack = new ArrayDeque<>();

    stack.push("item 1");
    stack.push("item 2");
    stack.push("item 55");

    System.out.println("Stack content = "+ stack);

    System.out.println("Let pop the element " + stack.pop());

    System.out.println("Stack content = "+ stack);








  }
}
