package com.kattyavar.shika.main.java.live_session.extra.hashandarray;

import java.util.*;

public class Usage {
  public static void main(String[] args) {
    usingHashMapAndSetUsageExample();
    usingHashMapAndArrayUsageExample();
  }

  static void usingHashMapAndSetUsageExample(){
    ProblemSG6Implementation obj = new ProblemSG6Implementation();
    obj.storeDrink(new Drink("Coca-Cola", "Crystal Coke"));
    obj.storeDrink(new Drink("Pepsi", "Pepsi 2"));
    obj.storeDrink(new Drink("Coca-Cola", "Coke Lite"));

    List<Drink> drinks = obj.getDrinks("Coca-Cola");

    System.out.println(obj.getDrinks("Coca-Cola"));

    //now lets update drinks
    drinks.add(new Drink("test", "test"));

    System.out.println("now have look at coco cola=======");
    System.out.println(obj.getDrinks("Coca-Cola"));


    System.out.println(obj.getDrinks("Pepsi"));
    System.out.println(obj.getDrinks("Wal-Mart"));
  }
  static void usingHashMapAndArrayUsageExample(){
    System.out.println("Using HashMap and Array list impl");
    ProblemSG6Implementation2 obj = new ProblemSG6Implementation2();
    obj.storeDrink(new Drink("Coca-Cola", "Crystal Coke"));
    obj.storeDrink(new Drink("Pepsi", "Pepsi 2"));
    obj.storeDrink(new Drink("Coca-Cola", "Coke Lite"));

    List<Drink> drinks = obj.getDrinks("Coca-Cola");

    System.out.println(obj.getDrinks("Coca-Cola"));


    //now lets update drinks
    drinks.add(new Drink("test", "test"));

    System.out.println("now have look at coco cola=======");
    System.out.println(obj.getDrinks("Coca-Cola"));


    System.out.println(obj.getDrinks("Pepsi"));
    System.out.println(obj.getDrinks("Wal-Mart"));
    System.out.println(obj.getDrinks(null));
  }
}


