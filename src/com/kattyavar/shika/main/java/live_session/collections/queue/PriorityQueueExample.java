package com.kattyavar.shika.main.java.live_session.collections.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

  static public void main(String[] args) {
    PriorityQueue<Integer> pr = new PriorityQueue<>();

    pr.offer(8);
    pr.offer(6);
    pr.offer(3);
    pr.offer(10);
    pr.offer(5);
    pr.offer(4);
    pr.offer(9);

    System.out.println(pr);

    //PriorityQueue<Student> studentPriorityQueue  = new PriorityQueue<>((x, y) -> x.rollNumber.compareTo(y.rollNumber));
    //Same as ...
    PriorityQueue<Student> studentPriorityQueue  = new PriorityQueue<>(Comparator.comparing(x -> x.rollNumber));

    studentPriorityQueue.offer(new Student(8));
    studentPriorityQueue.offer(new Student(6));
    studentPriorityQueue.offer(new Student(3));
    studentPriorityQueue.offer(new Student(10));
    studentPriorityQueue.offer(new Student(5));
    studentPriorityQueue.offer(new Student(4));
    studentPriorityQueue.offer(new Student(9));

    System.out.println(studentPriorityQueue);

  }


  static class Student {
    Integer rollNumber;

    public Student(Integer rollNumber) {
      this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
      return "Student{" +
        "rollNumber=" + rollNumber +
        '}';
    }
  }
}


