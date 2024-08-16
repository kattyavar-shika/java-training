package com.kattyavar.shika.main.java.live_session.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ArrayListExample {

  public static void main(String[] args) {

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
