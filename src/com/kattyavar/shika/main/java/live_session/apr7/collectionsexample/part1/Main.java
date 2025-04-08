package com.kattyavar.shika.main.java.live_session.apr7.collectionsexample.part1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

  public static void main(String[] args) {



    //List<String> list = new ArrayList<>();
    List<String> list = new LinkedList<>();
    list.add("v1");
    list.add("v2");


    List<String> temp = new ArrayList<>();
    temp.add("from temp t1");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");
    temp.add("from temp t2");



    list.addAll(temp);

    System.out.println(list);


    //This one way of doing it...
    for(String item : list){
      System.out.println("Processing item === > " + item);
    }


    Iterator<String> iterator =  list.iterator();

    while(iterator.hasNext()){
      String item = iterator.next();

      System.out.println(item);
    }





    //Any how we will see as part of stream in java...
    list
      .stream()
      .forEach(x -> System.out.println("Using stream ..Processing item === > " + x));


    //If i would like to get the item by index...

    System.out.println("At index zero " + list.get(0));


    //if would like to search

    System.out.println("Is v3 present in list " + list.contains("v3"));

    //if you would like to remove the item..

    //two ways..

    list.remove(0);

    System.out.println("After all operation we have list as below");
    System.out.println(list);

  }
}


class Animal {

  void getAnimal() {

  }

}


class Person extends Animal {
  String name;

  String getPerson() {
    return null;
  }
}

class IndianPerson extends Person {

  String getIndinanPerson() {
    return null;
  }
}

class Dog extends Animal {

}