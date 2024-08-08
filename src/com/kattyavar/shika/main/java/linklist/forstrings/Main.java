package com.kattyavar.shika.main.java.linklist.forstrings;

public class Main {
  public static void main(String[] args) {
    MyLinkList demo = new MyLinkList();
    demo.add("one");
    demo.add("one2");
    demo.add("one3");
    demo.add("one4");
    demo.printList();

    demo.add(1, "added one more");

    System.out.println("Have look at the link list now...updated one...");
    demo.printList();
  }
}
