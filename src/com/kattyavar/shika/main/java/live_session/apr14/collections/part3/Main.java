package com.kattyavar.shika.main.java.live_session.apr14.collections.part3;

import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

  public static void main(String[] args) {
    List<String> list = new CopyOnWriteArrayList<>();

    List<String> statckWrongDemo = new Stack<>();

    Stack<String> correctWay = new Stack<>();

    //statckWrongDemo.push()
    //statckWrongDemo.pop();


    new Stack<>();

    list.add("s1");
    list.add("s2");
    list.add("s3");
    list.add("s4");
    list.add("s5");

    for (String item : list) {
      System.out.println("Processing ---> " + item);
      if (item.equals("s4")) {
        System.out.println("Lets remove it...");
        list.add("new One");
      }
    }

    System.out.println(list);


  }
}
