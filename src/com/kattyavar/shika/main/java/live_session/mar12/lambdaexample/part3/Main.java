package com.kattyavar.shika.main.java.live_session.mar12.lambdaexample.part3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Main {

  void test1(){
    ZeroArg obj = () -> {
    };

    OneArg obj1 = (a) -> System.out.println("In test method and value is " + a);


    ThreeArg obj2 = (a, b, c) -> System.out.println("fdfddf");

    ThreeArgWithReturnTypeString obj3 = (a, b, c) -> "";

    WithOneArgAndReturnTypeBoolean obj4 = (String a) -> true;
    Predicate<String> obj6              = (String a) -> true;

    WithOneArgIntegerAndReturnTypeBoolean obj5 = (a) -> false;



    Predicate<Integer> obj7                    = (a) -> false;

    Supplier<String> supplierObj = () -> new String("kdfjldfj");

    //Consumer
    //BiConsumer


    //Function
    //BiFunction

    List<Integer> list = new ArrayList<>();


    list
      .stream()
      .filter(x -> x > 5);


    Predicate<Integer> predicate = x -> x > 5;

    predicate.test(5);






    MyHarendra<Integer> obj8                    = (a) -> false;


    test(10);


  }
  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>();

    list.add(10);
    list.add(1);
    list.add(11);
    list.add(19);
    list.add(30);
    list.add(18);

    list
      .stream()
      .peek(x -> System.out.println("next line will call predicate.test(" + x + ")" ))
      .filter(x -> x > 100);
     // .forEach(x -> System.out.println("we have data as -> " + x));



  }

  static Boolean test(Integer input) {
    return input > 5;
  }


}

interface MyHarendra<T> {
  boolean test(T a);
}

interface WithOneArgIntegerAndReturnTypeBoolean {
  boolean test(Integer input);
}


interface WithOneArgAndReturnTypeBoolean {
  boolean test(String input);
}

interface ThreeArgWithReturnTypeString {
  String test(String a, Integer b, String c);
}

class Temp implements ThreeArgWithReturnTypeString {
  @Override
  public String test(String a, Integer b, String c) {
    return "";
  }
}

interface ThreeArg {
  void test(String a, Integer b, String c);
}

@FunctionalInterface
interface OneArg {
  void test(String a);
}

interface ZeroArg {
  void test();
}
