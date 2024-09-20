package com.kattyavar.shika.main.java.trickquestion.linklist;

public class FindKthFromLast {

  public static void main(String[] args) {
    LinkList linkList = new LinkList();
    linkList.add(1);
    linkList.add(2);
    linkList.add(3);
    linkList.add(4);
    linkList.add(5);
    linkList.add(99);


    linkList.printIt();
    //System.out.println("Data at k " + linkList.getKthFromEnd(2));
    //System.out.println("Middle entry " + linkList.findMiddleOfList());
    System.out.println("After reverse ");
    linkList.reverseLinkList();
    linkList.printIt();
    System.out.println("End");
  }

}


class LinkList {
  private Node head;

  public LinkList() {
  }


  public void reverseLinkList() {
    Node previous = null;
    Node currentNode = head;

    while (currentNode != null) {
      Node nextNode = currentNode.getNext();
      currentNode.setNext(previous);
      previous = currentNode;
      currentNode = nextNode;
    }
    head = previous;

  }

  public Integer getKthFromEnd(int k) {
    // in case of null list
    if (head == null || k <= 0) {
      return -1;
    }
    Node fast = head;
    Node slow = head;

    for (int i = 0; i < k; i++) {
      if (fast == null) {
        return -1;
      }
      fast = fast.getNext();
    }
    //Now let move both pointer at same time
    while (fast != null) {
      fast = fast.getNext();
      slow = slow.getNext();
    }

    return slow.getData();
  }

  public Integer findMiddleOfList() {
    if (head == null) {
      return -1;
    }

    Node fast = head;
    Node slow = head;

    while (fast != null && fast.getNext() != null) {
      fast = fast.getNext().getNext();
      slow = slow.getNext();
    }

    return slow.getData();
  }

  public void add(Integer data) {
    Node node = new Node(data);
    if (head == null) {
      head = node;
    } else {
      Node lastNode = head;
      while (lastNode.getNext() != null) {
        lastNode = lastNode.getNext();
      }
      lastNode.setNext(node);
    }
  }

  public void printIt() {
    Node node = head;
    while (node != null) {
      System.out.println(node.getData());
      node = node.getNext();
    }
  }


}