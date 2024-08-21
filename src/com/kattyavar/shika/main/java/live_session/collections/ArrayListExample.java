package com.kattyavar.shika.main.java.live_session.collections;

import java.util.*;

public class ArrayListExample {

  void samples(){

    String[] arraySample = new String[0];


    Options optionsObj = new Options("New optionsWay");
    //To create
    List<Options> optionsList = new ArrayList<>();

    optionsList = new LinkedList<>();


    //To Add
    optionsList.add(new Options("Option1"));

    optionsList.add(new Options("Option2"));

    optionsList.add(optionsObj);

    System.out.println("Lets print the array list ===> " + optionsList);
    System.out.println("Size of array list ===> " + optionsList.size());

    //lets try to add at 1st place
    optionsList.add(1, new Options("I am in in middle of some where"));

    System.out.println("Please have look at the below line");

    System.out.println("Lets print the array list ===> " + optionsList);
    System.out.println("Size of array list ===> " + optionsList.size());


    List<Options> newOptionData = new ArrayList<>();

    newOptionData.add(new Options("Let add it from new options using add all"));
    newOptionData.add(new Options("Let add it from new options using add all"));

    optionsList.addAll(1, newOptionData);

    optionsList.clear();


    optionsList.get(5);
    // optionsList.

    Options[] optionsArr = new Options[2];
    optionsArr[0] = new Options("From other source 1");
    optionsArr[1] = new Options("From other source 2");


    Options[] array = optionsList.toArray(optionsArr);


    array[0] = null;
    System.out.println("Now have look at the new array " + array);


    for (Options item : array) {
      System.out.println(item);
    }
  }

  void toArrayExample(){
    List<String> stringList = new ArrayList<>();

    stringList.add("Step 1");
    stringList.add("Step 2");
    stringList.add("Step 3");

    String[] array = stringList.toArray(new String[0]);
    System.out.println(array);
    for(String item : array){
      System.out.println(item);
    }

    Iterator<String> iterator =  stringList.iterator();
    while(iterator.hasNext()){
      String item = iterator.next();
      System.out.println(" ===" + item);
    }

    String[] newList = new String[10];
    newList[0] = "back 0";
    newList[1] = "back 1";
    newList[2] = "back 2";
    newList[3] = "back 3";
    newList[4] = "back 4";
    newList[5] = "back 5";
    newList[6] = "back 6";
    newList[7] = "back 7";
    newList[8] = "back 8";
    newList[9] = "back 9";

    String[] array1 = stringList.toArray(newList);
    System.out.println(array1);
    for(String item : array1){
      System.out.println(item);
    }

  }
  public static void main(String[] args) {

    Vector<Integer> v = new Vector<>(3, 2);

    Stack<Integer> stack = new Stack<>();

    stack.add(11);
    stack.add(12);
    stack.add(13);
    stack.add(14);

    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }



  }
}

class Options {
  String optionName;

  public Options(String optionName) {
    this.optionName = optionName;
  }

  @Override
  public String toString() {
    return "Options{" +
      "optionName='" + optionName + '\'' +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Options options = (Options) o;
    return Objects.equals(optionName, options.optionName);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(optionName);
  }
}
