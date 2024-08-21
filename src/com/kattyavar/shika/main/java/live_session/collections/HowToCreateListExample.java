package com.kattyavar.shika.main.java.live_session.collections;

import java.util.*;

public class HowToCreateListExample {

  static void toArrayExample() {
    List<String> list = new ArrayList<>();

    list.add("Step 1");
    list.add("Step 2");
    list.add("Step 3");

    String[] temp = new String[10];

    temp[0] = "Temp 0";
    temp[1] = "Temp 1";
    temp[2] = "Temp 2";
    temp[3] = "Temp 3";
    temp[4] = "Temp 4";
    temp[5] = "Temp 5";
    temp[6] = "Temp 6";
    temp[7] = "Temp 7";
    temp[8] = "Temp 8";
    temp[9] = "Temp 9";

    System.out.println("Have look at the list ..." + list);

    System.out.println("Let look at the temp variable " + temp.toString());

    for (String item : temp) {
      System.out.println(item);
    }

    //String[] array = list.toArray(temp);
    String[] array = list.toArray(new String[0]);
    list.toArray();

    System.out.println("Let have look at the new array");

  }

  static void arrayAsListExample() {
    List<String> abc = new ArrayList<>();

    String[] temp = new String[10];
    temp[0] = "Temp 0";
    temp[1] = "Temp 1";
    temp[2] = "Temp 2";
    temp[3] = "Temp 3";
    temp[4] = "Temp 4";
    temp[5] = "Temp 5";
    temp[6] = "Temp 6";
    temp[7] = "Temp 7";
    temp[8] = "Temp 8";
    temp[9] = "Temp 9";

    List<String> list = Arrays.asList(temp);
    System.out.println("Let have look at the new list items.." + list);

    temp[4] = "Patils world is here...";

    System.out.println("Let have look at the new list items.." + list);


  }

  static void listOfExampleJava9Onwards() {
    //Java 9 onwards
    List<String> temp = List.of("Abc", "PQR", "TQR");
    System.out.println(temp);
    temp.add("Test me if you can");


    //It is not thread safe...
    List<String> list = new ArrayList<>();

    list.add("add me");

    List<String> listVector = new Vector<>();

    listVector.add("add me if you can...");

  }

  static void iterateTheList() {
    List<String> stringList = new ArrayList<>();
    stringList.add("Item 1");
    stringList.add("Item 2");
    stringList.add("Item 3");
    stringList.add("Item 4");
    stringList.add("Item 5");

    for (String item : stringList) {
      System.out.println(item);
    }

    System.out.println(stringList.size());

    for (int i = 0; i < stringList.size(); i++) {
      System.out.println(stringList.get(i));
    }


    Iterator<String> iterator = stringList.iterator();

    System.out.println("Let iterate using ierator...");
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    System.out.println("let use lamdassssssss");
    stringList.forEach(x -> {
      System.out.println(x);
    });
  }

  public static void main(String[] args) {
    List<String> stringList = new LinkedList<>();
    stringList.add("Item 1");
    stringList.add("Item 1");
    stringList.add("Item 1");
    stringList.add("Item 1");

    stringList.add("Item 2");
    stringList.add("Item 3");
    stringList.add("Item 4");
    stringList.add("Item 5");


    System.out.println(stringList);


    Set<Patil> set = new HashSet<>();

    Map<String, String> map = new HashMap<>();
    map.put("test", "Test");

    set.add(new Patil("Patil"));
    set.add(new Patil("Patil"));
    set.add(new Patil("Patil"));
    set.add(new Patil("Patil"));

    System.out.println(set);



  }
}

class Patil {
  String name;

  public Patil(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Patil patil = (Patil) o;
    return Objects.equals(name, patil.name);
  }


  @Override
  public String toString() {
    return "Patil{" +
      "name='" + name + '\'' +
      '}';
  }
}
