package com.kattyavar.shika.main.java.live_session.collections.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class UsingArrayDequeStack {
  public static void main(String[] args) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(11);
    stack.push(12);
    stack.push(15);
    stack.push(1);
    System.out.println(stack);

    System.out.println("let pop the element from the stack " + stack.pop());
    System.out.println(stack);
  }

}
