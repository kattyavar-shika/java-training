package com.kattyavar.shika.main.java.live_session.apr15.stream.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {
    List<Person> list = new ArrayList<>();

    list.add(new Person("A1", 10, 1));
    list.add(new Person("A2", 18, 2));
    list.add(new Person("A3", 70, 3));
    list.add(new Person("A4", 60, 4));
    list.add(new Person("A5", 30, 4));
    list.add(new Person("A6", 20, 5));
    list.add(new Person("A6", 20, 5));

    for(Person item : list){

    }

    list
      .stream()
      .filter(x -> x.getAge() > 18)
      .distinct();
      //.forEach(x -> System.out.println(x));



     Stream.of(1, 2, 3, 4, 5).limit(1)
      .forEach(x -> System.out.println(x));


    System.out.println("Skip example ");
    Stream.of(1, 2, 3, 4, 5).skip(3)
      .forEach(x -> System.out.println(x));



  }
}

class Person {
  String name;
  Integer age;

  Integer salary;

  public Person(String name, Integer age, Integer salary) {
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
      "name='" + name + '\'' +
      ", age=" + age +
      ", salary=" + salary +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(name, person.name) && Objects.equals(age, person.age) && Objects.equals(salary, person.salary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, salary);
  }
}