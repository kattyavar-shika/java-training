package com.kattyavar.shika.main.java.live_session.apr1.collectionsdemo.part1;

public class Part1 {

  public static void main(String[] args) {
    String name = "val";
    String name1 = "val";
    String name2 = "val";
    String name3 = "val";
    String name4 = "val";
    String name5 = "val";
    String name6 = "val";
    String name7 = "val";
    String name8 = "val";
    String name9 = "val";
    String name91 = "val";
    String name92 = "val";
    String name93 = "val";
    String name94 = "val";
    String name95 = "val";
    String name96 = "val";
    String name97 = "val";
    String name98 = "val";

    // dataType[] arrayName = new dataType[size];

    String[] names = new String[10];

    for(int i =0; i < 10; i++) {
      //Insertion
      names[i] = "val " + i;
    }




    for(int i =0; i < 10; i++){
      System.out.println(names[i]);
    }


    //If i want to change the position 5 values as "Test 1234"

    //Update
    names[5] = "Test 1234";


    System.out.println("Please have look after update...");
    for(int i =0; i < 10; i++){
      System.out.println(names[i]);
    }


    names[5] = null;

    System.out.println("Please have look after update...");
    for(int i =0; i < 10; i++){
      System.out.println(names[i]);
    }


    //Jhow to find out length of array in java

    for(int i=0; i < names.length; i++ ){
      System.out.println(names[i]);
    }

  }
}
