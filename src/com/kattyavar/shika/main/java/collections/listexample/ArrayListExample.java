package com.kattyavar.shika.main.java.collections.listexample;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListExample {


  static void createList() {

    List<String> list = new ArrayList<>();

    //lets add few elements to it.
    list.add("Input data 1");
    list.add("Input data 2");
    list.add("Input data 3");

    System.out.println(list);
  }

  static void createListWithInitialCapacity() {
    //Here 10 is giving the initial capacity. As default initial capacity is zero (DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
    List<String> list = new ArrayList<>(10);

    //Lets add few elements
    list.add("Input data 1");
    list.add("Input data 2");
    list.add("Input data 3");
    System.out.println(list);
  }

  static void createListFromExitingOne() {
    List<Demo> list = new ArrayList<>();
    list.add(new Demo("input 1"));
    list.add(new Demo("input 2"));
    list.add(new Demo("input 3"));

    //Let crete the new list from exiting list
    List<Demo> listNewFromExitingOne = new ArrayList<>(list);
    listNewFromExitingOne.add(new Demo("input 4"));
    System.out.println(listNewFromExitingOne);


    //Lets create the list from array
    Demo[] array = {new Demo("one"), new Demo("Two")};

    /**
     * Key Points about Arrays.asList()
     * Fixed-Size List: The list returned by Arrays.asList() has a fixed size.
     * You cannot add or remove elements from this list, though you can modify existing elements.
     *
     * Backing Array: The list returned is backed by the original array, meaning any changes to the list will directly affect the array and vice versa.
     *
     *Note a Generic List: The type of the list returned by Arrays.asList() is java.util.List<T>, but it is not an instance of ArrayList or any other specific list implementation.
     * Note: private static class ArrayList<E> extends AbstractList<E> implements RandomAccess, Serializable  we have diff arraylist
     */
    listNewFromExitingOne = Arrays.asList(array);
    System.out.println(listNewFromExitingOne);


    //Not supported operation if you try to add new element.
    //listNewFromExitingOne.add(new Demo("New one"));

    //Lets modify original array
    array[0] = new Demo("you will not able to see one any more");

    System.out.println(listNewFromExitingOne);

    //if you try to add, remove,delete you will get unsupported operation.
    //listNewFromExitingOne.remove(1);

    // Unsupported operation.
    //listNewFromExitingOne.clear();


    //From java 9 onwards you can crate following ways.

    //This will create ImmutableCollections list.
    List<String> listOfExample = List.of("Apple", "Banana", "Cherry");

    //Un supported operation
    //listOfExample.add("Test");


  }

  void addingElement() {
    List<String> list = new ArrayList<>();

    list.add("String 1");
    list.add("String 2");
  }


  static void step3(){
    int step3Var = 20;
  }
  static void step2(){
    int step2Var = 20;
    step3();
    System.out.println("I am here");
  }
  static void step1(){
    int step1Var = 20;
    step2();

  }

  public static void main(String[] args) {
    /*
    createList();
    createListWithInitialCapacity();
    createListFromExitingOne();
     */
    createListFromExitingOne();

  }
}

class Demo {
  String name;

  public Demo(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Demo{" +
      "name='" + name + '\'' +
      '}';
  }
}
