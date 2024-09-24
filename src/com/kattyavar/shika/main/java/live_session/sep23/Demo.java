package com.kattyavar.shika.main.java.live_session.sep23;

import java.util.*;

public class Demo {
  static ProductImpl obj;

  static void topic1() {

    Hashtable<String, String> map = new Hashtable<>();

    map.put("abc", "Abc");

    map.put("pqr", "pql");

    System.out.println(map);

    //Let iterate the hashMap

    //Option 1
    Set<Map.Entry<String, String>> entries = map.entrySet();

    for (Map.Entry<String, String> item : entries) {
      System.out.println("Key " + item.getKey() + " " + "Value " + item.getValue());
    }


    System.out.println("Option 2");

    // Option 2

    map.keySet()
      .stream()
      .map(k -> "Key = " + k + ", value =" + map.get(k))
      .forEach(val -> System.out.println(val));

    System.out.println("Option 3 ");

    Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();


    while (iterator.hasNext()) {
      Map.Entry<String, String> next = iterator.next();
      System.out.println(" key = " + next.getKey() + " value = " + next.getValue());
    }

    //you can do this with only HashTable not with HashMap.

    //Note : Enumeration is not part of Map, it is only part of HashTable
    Enumeration<String> keys = map.keys();

    while (keys.hasMoreElements()) {

      //Here you got the key...
      String key = keys.nextElement();
      //To get the values
      map.get(key);

      System.out.println("Key = " + key + ", value = " + map.get(key));
    }
  }

  void treeSet(){
    Set<String> set = new TreeSet<>();

    set.add("z");

    set.add(null);

    set.add("a1");
    set.add("b");
    set.add("d");
    set.add("e");
    set.add("a");

    System.out.println("Set contain = " + set);

  }
  public static void main(String[] args) {

   Set<Integer> set = new LinkedHashSet<>();
   set.add(99);
   set.add(20);
   set.add(10);
   set.add(1);

   set.iterator();

    System.out.println(set);


  }
}

class Person {
  private String name;

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


interface Product {
  String getProductName();

  String getPassword();

  default String getLogLevel() {
    return "Level 1";

  }

  static void applyLogLevel() {

  }

  private void weHavePrivateMethod() {
    //In java 9 onwards...
  }
}

class ProductImpl implements Product {
  @Override
  public String getProductName() {
    return "";
  }

  @Override
  public String getPassword() {
    return "";
  }
}

class Amol {

  final String name ;

  public Amol(String name) {
    this.name = name;
  }

  final void display(){

  }

  public void display(final String input){
    //input = "lets modify"; // Not allowed
  }

}


















