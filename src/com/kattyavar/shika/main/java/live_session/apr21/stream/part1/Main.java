package com.kattyavar.shika.main.java.live_session.apr21.stream.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
  void streamExample() {

  }

  void someMoreExample() {


    String name = "This is original value";

    Optional<String> optionalString = Optional.ofNullable(name);

    if (optionalString.isPresent()) {
      String val = optionalString.get();
      System.out.println("Lets find out will this get printed" + val);
    }

    optionalString.ifPresent(x -> System.out.println("Lets find out will this get printed" + x));


    System.out.println("Usage of orElseGet" + optionalString.orElseGet(() -> new String("Default value")));
  }

  void optionalDemo (){

    String name = "This is original value";

    //We need to find out the length of input string.

    Integer len;
    if (name == null){
      len = 0;
    } else {
      len = name.length();
    }




    Optional<String> optionalString = Optional.of(name);

    Integer withOptionalLenApi = optionalString
      .map(x -> x.length())
      .orElse(0);

    //getName().length();

    Optional<Integer> i = optionalString
      .map(x -> x.length());

    String retVal = getName();
    if (retVal != null){

    }

    /*
     getName2()
       .filter()
       .map()

     */

  }
  public static void main(String[] args) {




  }

  static public Optional<String> getName2(){
    return Optional.empty();
  }

  static public String getName(){
    return null;
  }

  static void playWithThis(String name, Optional<String> nullSafeVariable) {

    if (name == null) {
      //Take action in case of name is null...
    }

    if (nullSafeVariable == null) {

    }

  }
}

class Person {
  String name;

  public Person(String name) {
    this.name = name;
  }
}