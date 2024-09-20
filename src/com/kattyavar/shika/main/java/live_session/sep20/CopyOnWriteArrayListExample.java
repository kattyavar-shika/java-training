package com.kattyavar.shika.main.java.live_session.sep20;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {

  public static void main(String[] args) {

    List<Integer> list = new CopyOnWriteArrayList<>();

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(10);
    list.add(15);
    list.add(20);

    System.out.println("List => " + list);

    //Lets iterate the list..
    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
      Integer data = iterator.next();
      System.out.println("We got the data as ==> " + data);

      if (data == 3) {
        // iterator.remove();
        list.add(100);
      }
    }

    System.out.println("Original list => " + list);

  }
}
