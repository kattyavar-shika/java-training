package com.kattyavar.shika.main.java.live_session.apr8.collectionDemo.part1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Main extends Object {

  static void part1() {
    List<String> list = new LinkedList<>();




    list.add("a");
    //list.remove()
    Iterator<String> iterator = list.iterator();

    while (iterator.hasNext()) {
      iterator.next();


    }

    for (String item : list) {

    }

    list.add(10, "kljdfkdfljd");


    list.add("a");
    list.add("a");
    list.add("a");
    list.add("a");
    list.add("a");
    list.add("a");
    list.add("a");
    list.add("a");
    list.add("a");
    list.add("a");
    list.add("a");
    list.add("a");
    list.add("a");
    list.add("a");
    list.add("a");
  }

  public static void main(String[] args) {


    Test obj1 = new Test("part1");
    Test obj2 = new Test("part1");



    // obj1.hashCode() ==  obj2.hashCode()
    //Hash Collision...

    System.out.println(obj1 == obj2);

    System.out.println(obj1.equals(obj2));

    System.out.println(obj1.hashCode());
    System.out.println(obj2.hashCode());


  }

}

class Test {
  String name;
  String name1;
  String name3;
  String name4;

  public Test(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Test test = (Test) o;
    return Objects.equals(name, test.name) && Objects.equals(name1, test.name1) && Objects.equals(name3, test.name3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, name1, name3);
  }
}


