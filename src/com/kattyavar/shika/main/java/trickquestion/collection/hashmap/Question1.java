package com.kattyavar.shika.main.java.trickquestion.collection.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Question1 {
  public static void main(String[] args) {
    Map<Person, String> map = new HashMap<>();

    Person obj = new Person("Person 1");

    //Let put this object to map.

    map.put(obj, " Person 1");

    System.out.println("Map content :" + map);

    System.out.println("Is map contain obj ? = " + map.containsKey(obj));

    //Now let try to modify the obj, as we have ref object with us, even it is added as part of Hash.


    obj.setName("Person 2");

    //Now lets print the map.
    System.out.println("Map content :" + map);

    //Now let try to find is Person 1 is present in map.

    Person obj2 = new Person("Person 1");

    System.out.println("Search this in map " + obj2 + " as map content " + map + " Result = " + map.containsKey(obj2));
    System.out.println("Search this in map " + obj + " as map content " + map + " Result = " + map.containsKey(obj));

    //Now question is why? we get false in above two cases. As map contain
    //{Person{name='Person 2'}= Person 1}

    System.out.println("Map content size " + map.size());
    //now lets try to find out above two cases.

    System.out.println("Map content " + map);
    System.out.println("Search this in map " + obj2 + " Result = " + map.containsKey(obj2));
    System.out.println("Search this in map " + obj + " Result = " + map.containsKey(obj));
    System.out.println("Search this in map " + new Person("Person 2") + " Result = " + map.containsKey(new Person("Person 2")));
    System.out.println("Search this in map " + new Person("Person 1") + " Result = " + map.containsKey(new Person("Person 1")));

    //Now lets try to find out using iterator.

    for (var person : map.keySet()) {
      if (person.equals(new Person("Person 1"))) {
        System.out.println("Person 1 exits  using keyset..");
      }
      if (person.equals(new Person("Person 2"))) {
        System.out.println("Person 2 exits using keyset..");
      }
    }

    /***
     * output as
     * Map content :{Person{name='Person 1'}= Person 1}
     * Is map contain obj ? = true
     * Map content :{Person{name='Person 2'}= Person 1}
     * Search this in map Person{name='Person 1'} as map content {Person{name='Person 2'}= Person 1} Result = false
     * Search this in map Person{name='Person 2'} as map content {Person{name='Person 2'}= Person 1} Result = false
     * Map content size 1
     * Map content {Person{name='Person 2'}= Person 1}
     * Search this in map Person{name='Person 1'} Result = false
     * Search this in map Person{name='Person 2'} Result = false
     * Search this in map Person{name='Person 2'} Result = false
     * Search this in map Person{name='Person 1'} Result = false
     * Person 2 exits using keyset..
     *
     * Question is why?
     */
  }
}

class Person {
  String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(name, person.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public String toString() {
    return "Person{" +
      "name='" + name + '\'' +
      '}';
  }
}

