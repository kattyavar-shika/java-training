package com.kattyavar.shika.main.java.linklist.foranytype;

public class Node<T> {
  T data;
  Node<T> next;

  public Node(T data) {
    this.data = data;
    this.next = null;
  }
}
