package com.kattyavar.shika.main.java.linklist.forstrings;


public class MyLinkList {
  private Node head;

  public MyLinkList() {
    head = null;
  }

  public void add(String data) {
    Node node = new Node(data);
    if (head == null) {
      head = new Node(data);
    } else {
      Node lastNode = head;
      while (lastNode.next != null) {
        lastNode = lastNode.next;
      }
      lastNode.next = node;
    }
  }

  public void printList() {
    Node nodeEntry = head;
    if (nodeEntry == null) {
      return;
    }
    while (nodeEntry != null) {
      System.out.println("Find the data " + nodeEntry.data);
      nodeEntry = nodeEntry.next;
    }
  }

  public void add(int index, String data) {
    if (index < 0) {
      throw new IndexOutOfBoundsException("Index out of Bound");
    }
    Node newNode = new Node(data);

    //This is special case.
    if (index == 0) {
      newNode.next = head;
      head = newNode;
      return;
    }

    Node currentNode = head;

    for (int i = 0; i < index - 1; i++) {
      if (currentNode == null) {
        throw new ArrayIndexOutOfBoundsException("Index out of Bound");
      }
      currentNode = currentNode.next;
    }
    newNode.next = currentNode.next;
    currentNode.next = newNode;
  }
}
