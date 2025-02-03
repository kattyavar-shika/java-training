package com.kattyavar.shika.main.java.live_session.jan28;

import java.util.List;

public class StringExample {

  public static void main(String[] args) {

    String s1 = "Test";

    String s2 = new String("Test");
    String s3 = s2.intern();
    System.out.println("S1 == s2 " + (s1 == s2));
    System.out.println("S1 == s3 " + (s1 == s3));

    int i = 10;
    if (i == 10) {
      System.out.println("Okie");
    }

    for (i = 0; i < 10; i++) {
      System.out.println(i);
    }

    //Enhanced Loop

    List<String> list = List.of("one", "two", "Threee");

    for (String item : list) {
      System.out.println("in Enhanced loop --> " + item);
    }

    i = 1;
    while(i < 10){
      System.out.println("In while loop " + i);
      i++;
    }


    System.out.println("Begin of my for loop...");
    for(int index =0; index < 1; index++){

      System.out.println("Working on index " + index);
      if(index > 10){
        continue;
      }
      System.out.println("Let have look how many time it comesss...." + index );

    } // ... for

    System.out.println("End of my for loop ");


    int j = 100;
    int k = 20;

    //We trying to find out the maximum number
    int max = (j > k)? j:k;

    System.out.println("Max number is -->" + max);



  }

}
