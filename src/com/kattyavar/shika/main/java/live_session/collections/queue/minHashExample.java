package com.kattyavar.shika.main.java.live_session.collections.queue;

import java.util.Arrays;

public class minHashExample {

  public static void main(String[] args) {

    Integer[] array = new Integer[10];
    int lastIndex = 0;

    for (int data : Arrays.asList(8, 6, 3, 10, 5, 4, 9, 100, 2, 1)) {
      System.out.println("Let add new data to array === " + data);
      if (data == 5){
        System.out.println("lets add break point here.");
      }
      shiftUpUsingComparator(lastIndex, data, array);
      printArray(array);
      lastIndex++;
    }


  }

  private static void printArray(Integer[] es) {
    System.out.println("Have look at the array ============");
    for (Integer data : es) {
      if (data != null) {
        System.out.print(data + ", ");
      }
    }
    System.out.println("");

    System.out.println("Have look at the array ============");
  }

  private static void shiftUpUsingComparator(int k, Integer x, Integer[] es) {
    System.out.println("Begin of the function ....");
    while (true) {
      System.out.println(" while k = " + k + " with his new parent is " + (k -1 >>> 1));
      if (k > 0) {
        int parent = k - 1 >>> 1;
        Integer e = es[parent];

        System.out.println("Find the parent of K " + k + " Parent is " + parent);

        System.out.println(" === Parent index parent =" + parent + " Parent data is " + es[parent] + " Compare with new input data ==" + x);
        if (x.compareTo(e) < 0) {
          System.out.println("shifting is required between  es[parent] " + e + " with k index " + es[k]);
          es[k] = e;
          printArray(es);
          k = parent;
          continue;
        }
      }
      System.out.println(" keep input values at index == " + k + " with value " + x);
      es[k] = x;
      System.out.println("End of the function ....");
      return;
    }


  }
}
