package com.kattyavar.shika.main.java.live_session.aug28.queueexample;

import java.util.*;

public class PriorityQueueExample {

  static void prQueueExample(){
     /*
    Queue<Integer> pr = new PriorityQueue<>();

    pr.offer(8);
    pr.offer(6);
    pr.offer(3);
    pr.offer(10);
    pr.offer(5);
    pr.offer(4);
    pr.offer(9);

     */

    class Student {
      Integer name;

      public Student(Integer name) {
        this.name = name;
      }

      @Override
      public String toString() {
        return "Student{" +
          "name='" + name + '\'' +
          '}';
      }
    }
    Queue<Integer> q = new ArrayDeque<>();

    q.offer(8);
    q.offer(6);
    q.offer(3);
    q.offer(10);
    q.offer(5);
    q.offer(4);
    q.offer(9);

    System.out.println("Check Array Deque data =     " + q);

    Queue<Integer> pr = new PriorityQueue<>();

    pr.offer(8);
    pr.offer(6);
    pr.offer(3);
    pr.offer(10);
    pr.offer(5);
    pr.offer(4);
    pr.offer(9);
    System.out.println("Check Priority Queue data =  " + pr);

  }

  static void toCalcuateLeftAndRight(){
    int rootElementIndex = 2;

    int leftElementIndex = ( 2 * rootElementIndex ) + 1;
    int rightElementIndex = ( 2 * rootElementIndex ) + 2;

    System.out.println("Root index is  =" +rootElementIndex);
    System.out.println("Left index is  =" + leftElementIndex);
    System.out.println("Right index is =" + rightElementIndex);
  }
  public static void main(String[] args) {


    Queue<Integer> q = new ArrayDeque<>();

    q.offer(8);
    q.offer(6);
    q.offer(3);
    q.offer(10);
    q.offer(5);
    q.offer(4);
    q.offer(9);

    System.out.println("Check Array Deque data =     " + q);

    Queue<Integer> pr = new PriorityQueue<>(Comparator.reverseOrder());

    Set<String> abc;

    pr.offer(8);
    pr.offer(6);
    pr.offer(3);
    pr.offer(10);
    pr.offer(5);
    pr.offer(4);
    pr.offer(9);
    System.out.println("Check Priority Queue data =  " + pr);

    System.out.println("Let take out the element from queue = " + pr.poll());
    System.out.println("Check Priority Queue data =  " + pr);



  }
}

class LinkListNode{
  String data;
  LinkListNode next;
}

class TreeNode{
  String data;
  TreeNode leftNode;
  TreeNode rightNode;
}