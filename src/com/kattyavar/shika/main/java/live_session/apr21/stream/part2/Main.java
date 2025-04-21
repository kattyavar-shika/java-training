package com.kattyavar.shika.main.java.live_session.apr21.stream.part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  void streamDemo(){

    List<String> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {

      if (i == 3) {
        break;
      }
      System.out.println(i);
    }


    Optional<String> prasad = list
      .stream()
      .filter(x -> x.equals("P2"))
      .map(x -> x)
      .findAny();

    String nameRetVal  = list
      .stream()
      .filter(x -> x.equals("P2"))
      .map(x -> x)
      .findAny()
      .orElseThrow();


    Person obj = getPersonInfo();

    if (obj == null){

    }

    getPersonInfo2();
    //.filter()
//      .map()

    Stream<List<String>> stream = getpersons2()
      .stream();


    Optional<List<String>> temp = getpersons2();
    if (temp.isPresent()){
      List<String> listVar = temp.get();

      Stream<String> stream1 = listVar
        .stream();

    }

    Stream<List<String>> stream1 = getpersons2()
      .map(x -> x)
      .stream();


  }
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();

    List<String> dangoure = new ArrayList<>();


    list.add("P1");
    list.add("P2");
    list.add("P3");
    list.add("P4");
    list.add("P5");
    list.add("E1");
    list.add("E2");
    list.add("E3");

    /*

    with normal way we required : x amount of time.

    with p way  : t (divided, mulitple thread + combine result )amount of time...

    t < x

t ~~ x
    t > x ----it of no use...

     */

    list
      .parallelStream()
      .map(x -> {
        dangoure.add(x);
        return x;
      })
      .collect(Collectors.toList());



     Stream<String> p1Stream = list
      .parallelStream()
      .filter(x -> x.startsWith("P"));

     //Lets process it ...

    processStream(p1Stream);
    processStream(p1Stream);




  }

  static void processStream(Stream<String> stream){
    System.out.println("Start processing input stream ....");
    stream
      .forEach(x -> System.out.println(x));

    System.out.println("End processing input stream ....");
  }

  static List<String> getPersons(){
    return Collections.EMPTY_LIST;
  }

  static Optional<List<String>> getpersons2(){
 return    Optional.empty();
  }
  static Person getPersonInfo(){
    return null;
  }

  static Optional<Person> getPersonInfo2(){

    //Optional.of()
    //Optional.ofNullable()
    return Optional.empty();

  }
}


class Person {

  String name;

}