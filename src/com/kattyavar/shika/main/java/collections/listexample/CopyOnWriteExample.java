package com.kattyavar.shika.main.java.collections.listexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteExample {
  public static void main(String[] args) {
    //diffBetweenArraysAsListVsListOf();

    test();

  }

  static void test() {
    List<Integer> list = new CopyOnWriteArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(10);
    list.add(11);
    System.out.println(list);

    //Lets try to iterate the array list

    System.out.println("content of the list => " + list);

    Iterator<Integer> iterator = list.iterator();

    while (iterator.hasNext()) {
      Integer data = iterator.next();

      if (data == 3) {
        //lets remove from iterator.
        //iterator.remove(); // This will remove the element from the list using iterator..
        //Note iterator.remove(); is not allowed in CopyOnWriteArrayList but in array list is allowed.
        //Now try to remove the element from list
        //list.remove(Integer.valueOf(3)); // you will get ConcurrentModificationException. as you are trying to modify the original list.
        //but if you change the object type as CopyOnWriteArrayList this is allowed.

        list.add(100);

      }
    }

    System.out.println("Now print the original list =>" + list);


  }


  static void diffBetweenArraysAsListVsListOf() {

    /**
     * ype: Returns a fixed-size list backed by the original array.
     * Null Elements: Allows null elements.
     * Modification: The size of the list cannot be changed (you can't add or remove elements), but you can modify existing elements.
     * Syntax: Can take a varargs parameter or an existing array.
     */

    List<Integer> arraysAsList = Arrays.asList(1, 2, 3, 5, null, 6, 7);


    /**
     * Type: Returns an immutable list.
     * Null Elements: Does not allow null elements; attempting to include null will throw a NullPointerException.
     * Modification: The list is immutable, meaning you cannot modify it after creation (no adding, removing, or changing elements).
     * Syntax: Also takes a varargs parameter, but it can accept multiple elements directly.
     */

    //List<Integer> listOf = List.of(1, 2, 3, 5, null, 6, 7); // You can not have null item in List.of
    List<Integer> listOf = List.of(1, 2, 3, 5, 6, 7);

    //Can we add element ? -- no we can not
    //arraysAsList.add(10); // you will get UnsupportedOperationException
    //listOf.add(10); // // you will get UnsupportedOperationException

    //Can we add element to specific index

    //arraysAsList.add(1, 10); // will get error at runtime UnsupportedOperationException
    //listOf.add(1, 20); // will get error at runtime UnsupportedOperationException

    //Can we remove the element

    //arraysAsList.remove(10); // will get error at runtime UnsupportedOperationException
    //listOf.remove(10); // will get error at runtime UnsupportedOperationException


    //So far both are same..

    //Can update exiting element (in Arrays.asList allowed but not in List.of)
    arraysAsList.set(1, 30); // okie allowed.
    //listOf.set(1, 30); // This is not allowed. UnsupportedOperationException, as this immutable list


    //Can list contain null values? (Arrays.asList contain null but List.of do not allow null values.
    System.out.println(arraysAsList);  // Yes


    //Now lets check what is backed by the original array.

    String[] listOrg = {"a", "b", "c"};
    List<String> listNew = Arrays.asList(listOrg);

    printArray(listOrg);

    //now let modify the contain to new array.

    listNew.set(1, "updated One"); // This operation will also affect listOrg. This is backed by the original array.
    // in case of List.of this will not happen. As List.of does not allow to set any values..

    System.out.println("Updated New array => " + listNew);

    printArray(listOrg);


  }

  static void printArray(String[] data) {
    System.out.println("Array contain below data ");
    for (var val : data) {
      System.out.println(val);
    }
    System.out.println("end..... of Array elements");
  }
}
