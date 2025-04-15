package com.kattyavar.shika.main.java.live_session.apr15.stream.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

  static void usingforLoop(){

    List<Person> list = new ArrayList<>();

    list.add(new Person("A1", 10, 1));
    list.add(new Person("A2", 18, 2));
    list.add(new Person("A3", 70, 3));
    list.add(new Person("A4", 60, 4));
    list.add(new Person("A5", 30, 4));
    list.add(new Person("A6", 20, 5));

    List<Person> increaseSalary = new ArrayList<>();


    for(int index =0; index < list.size(); index=  index + 2){
      Person item = list.get(index);
      if (item.getAge() >= 18) {
        //We need to take some action on these item.
        Integer salary = item.salary;
        item.salary = item.salary + 5;
        increaseSalary.add(item);
      } else {
        System.out.println("We don't care about this person " + item);
      }
    }

    for (Person item : list) {
      if (item.getAge() >= 18) {
        //We need to take some action on these item.
        Integer salary = item.salary;
        item.salary = item.salary + 5;
        increaseSalary.add(item);
      } else {
        System.out.println("We don't care about this person " + item);
      }
    }

    System.out.println("We have process all the data and here is list ");
    System.out.println(increaseSalary);
  }
  public static void main(String[] args) {

    List<Person> list = new ArrayList<>();

    list.add(new Person("A1", 10, 1));
    list.add(new Person("A2", 18, 2));
    list.add(new Person("A3", 70, 3));
    list.add(new Person("A4", 60, 4));
    list.add(new Person("A5", 30, 4));
    list.add(new Person("A6", 20, 5));

    Person obj = new Person("don't share this with anyone", 20, 11);


    Stream<Integer> integerStream = list
      .parallelStream()
      //.parallel()
      .peek(x -> System.out.println("Can you see this line " + x))
      .filter(x -> x.age >= 18)
      .map(x -> {
        obj.salary = 100;
        x.salary = x.salary + 5;
        return x;
      })
      //.map(x -> x.getAge())
      .map(Person::getAge);

    System.out.println(list);


    integerStream.count();

    integerStream.count();


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
}