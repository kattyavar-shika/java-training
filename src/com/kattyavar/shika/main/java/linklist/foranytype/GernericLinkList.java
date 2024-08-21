package com.kattyavar.shika.main.java.linklist.foranytype;

public class GernericLinkList<T> {
  Node<T> head;

  void add(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null) {
      head = newNode;
      return;
    }

    Node<T> lastNode = head;
    while (lastNode.next != null) {
      lastNode = lastNode.next;
    }
    lastNode.next = newNode;
  }

  public void add(int index, T data) {
    if (index < 0) {
      throw new ArrayIndexOutOfBoundsException("Index out of bound");
    }
    Node<T> newNode = new Node<>(data);
    if (index == 0) {
      newNode.next = head;
      head = newNode;
      return;
    }
    // if you would like to insert at index 2
    Node<T> currentNode = head;
    for (int i = 0; i < index - 1; i++) {
      if (currentNode == null) {
        throw new ArrayIndexOutOfBoundsException("Index out of bound");
      }
      currentNode = currentNode.next;
    }
    newNode.next = currentNode.next;
    currentNode.next = newNode;
  }

  public void printList() {
    Node<T> currentRef = head;
    if (currentRef == null) {
      return;
    }

    while (currentRef != null) {
      System.out.println("Data : " + currentRef.data);
      currentRef = currentRef.next;
    }
  }


}
