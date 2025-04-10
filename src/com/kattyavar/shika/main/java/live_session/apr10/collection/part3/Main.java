package com.kattyavar.shika.main.java.live_session.apr10.collection.part3;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main extends Object {

  public static void main(String[] args) {

    Set<Test> set = new HashSet<>();

    set.add(new Test("a"));
    set.add(new Test("a"));
    set.add(new Test("a"));
    set.add(new Test("a"));
    set.add(new Test("a"));

    System.out.println(set);

  }
}

class Test {
  String name;

  public Test(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Test test = (Test) o;
    return Objects.equals(name, test.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public String toString() {
    return "Test{" +
      "name='" + name + '\'' +
      '}';
  }
}
