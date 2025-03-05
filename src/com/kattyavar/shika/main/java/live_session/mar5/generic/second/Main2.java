package com.kattyavar.shika.main.java.live_session.mar5.generic.second;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main2 {
  public static void main(String[] args) {

    class Person {}

    List<Object> genricObjList = new ArrayList<>();

    Integer input1 = 10;
    String input2 = "dfdf";
    Number input3 = Integer.valueOf(10);

    Person input4 = new Person();

    genricObjList.add(input1);
    genricObjList.add(input2);
    genricObjList.add(input3);
    genricObjList.add(input4);



    List<String> abc = new ArrayList<>();
    abc.add("ffdf");
    abc.add("ffdf1");
    abc.add("ffdf2");
    abc.add("ffdf3");

//    tryThis(abc);

    List<String> list1  = new ArrayList<>();
    List<Person> list2 = new ArrayList<>();
    List<Number> list3 = new ArrayList<>();

    //tryThis(list1);
    //tryThis(list2);
    tryThis(list3);

    //Enum<E extends Enum<E extends Enum<E extends Enum<E>>



    Test<Integer> intInput;
    //Test<String> strInput;


  }

  enum Status{}


  static void tryThis(List<? super Number> input){

  }



}

class Test <T extends Number> {
  //    Test<Integer> intInput;
  //private Integer varName;
  //private Number varName;


  //    Test<String> strInput;
  //private String varName;
  private T varName;

  void display(){

  }

}
