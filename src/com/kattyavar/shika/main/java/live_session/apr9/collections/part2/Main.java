package com.kattyavar.shika.main.java.live_session.apr9.collections.part2;

import java.util.*;

public class Main {

  static List<Product> doNotTryThis() {

    Map<MyKey, List<Product>> map = new HashMap<>();

    return map.get(null);
    //map.get()
  }

  public static void main(String[] args) {

    List<Product> itemsRisky = doNotTryThis();
    //itemsRisky.add()


    Product product_1 = new Product(1, "Chair", "Usage for sitting purpose", 1000);
    Product product_2 = new Product(2, "Table", "Usage for office purpose", 5000);
    Product product_3 = new Product(3, "TV", "Entertainment", 50000);
    Product product_4 = new Product(4, "Computer", "Office work", 35000);
    Product product_5 = new Product(5, "WashingMachine", "Washing cloths", 45000);
    Product product_6 = new Product(6, "Chair", "Usage for sitting purpose", 2000);

    Map<MyKey, List<Product>> map = new HashMap<>();

    List<Product> productList = new ArrayList<Product>();
    productList.add(product_1);
    productList.add(product_2);
    productList.add(product_3);
    productList.add(product_4);
    productList.add(product_5);
    productList.add(product_6);


    Set<String> set = new HashSet<>();
    set.add("dfdf");


    //There is another alternative ...
    //List<Product> p1Temp  = new ArrayList<>(Arrays.asList(product_1, product_2, product_3, product_4, product_5, product_6));

    /*
     Iterator<Product> iterator = productList.iterator();
     while (iterator.hasNext()){
       Product product = iterator.next();
     }
     */

    for (Product product : productList) {
      MyKey myKey = new MyKey(product.getName());

      // Option 1
      List<Product> objectList = map.get(myKey);
      if (objectList == null) {
        objectList = new ArrayList<>();
      }

      map.put(myKey, objectList);

      objectList.add(product);


      //return map.get(myKey);


    }

    System.out.println(map);

    System.out.println("Please have look now");

    map.forEach((key, value) -> {
      System.out.println(key + " ==> " + value);
    });

    /*
    for(int i = 0; i < productList.size(); i++) // 1) enhanced for loop 2) streaming
    {
      String name = productList.get(i).getName();
      MyKey myKey = new MyKey(name) ;


      ArrayList<Product> objectList = map.get(myKey);
      if(objectList == null) {
        objectList = new ArrayList<>();
        objectList.add(productList.get(i));
        //map.put(myKey, objectList);
        objectList = null ;

      }else if(map.containsKey(myKey)) {
        objectList = map.get(myKey);
        objectList.add(productList.get(i));

      }
      map.put(myKey, objectList);
      System.out.println(" value: " + map.get(myKey));
    }
    System.out.println(" value: " + map);


     */
  }
}

class MyKey {
  String name;

  public MyKey(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {

    if (o == null || getClass() != o.getClass()) return false;
    MyKey mykey = (MyKey) o;
    return Objects.equals(name, mykey.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public String toString() {
    return "Mykey{" +
      "name='" + name + '\'' +
      '}';
  }
}

class Product {
  Integer number;
  String name;
  String description;
  Integer price;

  public Product(Integer number, String type, String description, Integer price) {
    this.number = number;
    this.name = type;
    this.description = description;
    this.price = price;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Product{" +
      "number=" + number +
      ", name='" + name + '\'' +
      ", description='" + description + '\'' +
      ", price=" + price +
      '}';
  }
}
