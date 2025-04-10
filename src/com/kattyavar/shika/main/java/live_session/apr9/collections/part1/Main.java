package com.kattyavar.shika.main.java.live_session.apr9.collections.part1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {

    Map<MyKey, List<Product>> map = new HashMap<>();

    Product p1 = new Product("Chair", 1000L);
    Product p2 = new Product("Table", 1000L);
    Product p3 = new Product("TV", 1000L);
    Product p4 = new Product("TV", 3000L);


    List<Product> products = new ArrayList<>();
    products.add(p1);
    products.add(p2);
    products.add(p3);
    products.add(p4);

    for (Product item : products) {
      MyKey key = new MyKey(item.name);

      map.computeIfAbsent(key, k -> new ArrayList<>()).add(item);

      /*
      map.putIfAbsent(new MyKey(item.name), new ArrayList<>());
      map.get(key).add(item);
       */
    }

    System.out.println(map);

    map.forEach((key, val) -> {
      System.out.println(key + " -> " + val);
    });
  }
}


class Product {
  public String name;
  public Long price;

  public Product(String name, Long price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public String toString() {
    return "Product{" +
      "name='" + name + '\'' +
      ", price=" + price +
      '}';
  }
}

class MyKey {
  public String name;

  public MyKey(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {

    if (o == null || getClass() != o.getClass()) return false;
    MyKey myKey = (MyKey) o;
    return Objects.equals(name, myKey.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public String toString() {
    return "MyKey{" +
      "name='" + name + '\'' +
      '}';
  }
}