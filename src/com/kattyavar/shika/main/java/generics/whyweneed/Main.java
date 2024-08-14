package com.kattyavar.shika.main.java.generics.whyweneed;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    IntegerBox integerBox = new IntegerBox(10);
    StringBox stringBox = new StringBox("Test");

    BoxUtils.printBoxContent(integerBox);
    BoxUtils.printBoxContent(stringBox);
    BoxUtils.printBoxContent(new Object());

    ArrayList<B> arrayList = new ArrayList<>();

    arrayList.add(new c());
    Integer i;

    // Now have look at generic block

    GenericBox<String> stringGenericBox = new GenericBox<>();

    GenericBox<Object> objectGenericBox = new GenericBox<>();

    List<String> stringList = new ArrayList<>();


    List<String> temp = new ArrayList<>();


    objectGenericBox.setItem("I am here");
    objectGenericBox.setItem(10);
    objectGenericBox.setItem(new A());

    int array[] = new int[10];

    System.out.println("Please check array lenght " + array);

    List<Integer> integerList = new ArrayList<>();

    System.out.println("Have look atg list lenght " + integerList.size());

    //So where is type safety ..

    //To restrict the what kind of object we can have use can use... Bounded types (extended Types


  }

  private static <T> void print(T anyData) {
    System.out.println(anyData);
  }
}


interface TestMe<T> {
  T loadDAta();
}

class A {

}

class B extends A {

}

class c extends B {

}
