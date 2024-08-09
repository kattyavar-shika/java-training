package com.kattyavar.shika.main.java.live_session.arrays;

import java.util.List;
import java.util.Objects;

public class ArraysExample {

  void preAndPostExample() {
    int i = 10;

    System.out.println("Before making as Pre add have look at ++i = " + i);
    int newIPre = ++i;
    System.out.println("++i values at line 31 =" + newIPre);
    System.out.println(i);
    System.out.println("Before making as post add have look at i++ = " + i);
    int newIPost = i++;
    System.out.println("++i values at line 35 =" + newIPost);
    System.out.println(i);

    int i1 = 10;
    i1++;
    System.out.println(i1);
    ++i1;
    System.out.println(i1);
  }

  void primitiveDateTypeExample() {
    //Data type (String , int, Integer, Student, Demo, Product, Oder ..
    //variable names... (as per java allowed syntax )

    int intArray[];
    int[] intArrayAnotherWayDefination;

    //Option 1 you have to give the size while creating the array.
    intArray = new int[7];

    //how you will access

    intArray[0] = 10;
    intArray[1] = 11;
    intArray[2] = 22;
    intArray[3] = 33;
    intArray[4] = 44;
    intArray[5] = 55;
    intArray[6] = 66;
    //intArray[7] = 999;

    //lets print out this values ..
    for (int i = 0; i < intArray.length; i++) {
      intArray[i] = i * 10;
    }

    for (int i = 0; i < intArray.length; i++) {
      System.out.println("Have look at the index " + i + " now let have look at the vlaues  " + intArray[i]);
    }

    //Option 2

    int[] intArrayOption2 = new int[]{1, 2, 3, 4, 5, 6, 100, 8, 300, 1, 1, 2, 3, 3, 4};

    for (int i = 0; i < intArrayOption2.length; i++) {
      System.out.println("Index = " + i + " value = " + intArrayOption2[i]);
    }


  }

  void customObjectArrayExample() {
    Person[] personArray = new Person[5];


    for (int i = 0; i < personArray.length; i++) {
      personArray[i] = new Person("Pername " + i, false);
    }

    //Lets print the values of person

    for (int i = 0; i < personArray.length; i++) {
      System.out.println(personArray[i]);
    }

    Person[] personArrayAnotherWay = new Person[]{new Person("P1", false), new Person("p2", true)
      , new Person("p3", false)};


    System.out.println("Let find out values from the new ways...");
    for (int i = 0; i < personArrayAnotherWay.length; i++) {
      System.out.println(personArrayAnotherWay[i]);
    }
  }

  void twodimensionArrayExample(){
    //How to define the single array
    //new int[rows][columns]
    int[][] varname = new int[5][3];

    for(int i =0 ; i < 5; i++){
      for(int j = 0; j < 3; j++) {
        System.out.print(varname[i][j] + "     ");
      }
      System.out.println("");
    }


    //If you dont know the row and column then you can do following

    System.out.println("Here are rows =" + varname.length);

    System.out.println("Let print using length ");
    for(int i=0; i < varname.length; i++){
      for(int j = 0 ; j < varname[i].length; j++){
        System.out.print(varname[i][j] + "     ");
      }
      System.out.println("");
    }

  }
  public static void main(String[] args) {

    int jaggedArray [][] = new int[3][];

    jaggedArray[0] = new int[30];
    jaggedArray[1] = new int[3];
    jaggedArray[2] = new int[8];

    for(int i =0 ; i < jaggedArray.length; i++){
      //Here you will hve customer login to add specific entry
      if(i ==0 ) {
        int j = 900;
        //by length, or take as parameter of config..
        jaggedArray[0] = new int[j];
      }
    }

    System.out.println("Let print using length ");
    for(int i=0; i < jaggedArray.length; i++){
      for(int j = 0 ; j < jaggedArray[i].length; j++){
        System.out.print(jaggedArray[i][j] + "     ");
      }
      System.out.println("");
    }

    // ==
    //.equal     -
    //hashCode   -

  }
}

class Person {
  private String name;
  private Boolean isMail;

  public Person() {
    System.out.println("In Person default constructor...");
  }

  public Person(String name, Boolean isMail) {
    this.name = name;
    this.isMail = isMail;
  }

  @Override
  public String toString() {
    return "Person{" +
      "name='" + name + '\'' +
      ", isMail=" + isMail +
      '}';
  }
}

class University {
  private String name;
  List<College> colleges;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    University that = (University) o;
    return Objects.equals(name, that.name) && Objects.equals(colleges, that.colleges);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}

class College{
  private String name;
  List<Student> students;
}

class Student {
  private Integer rollNumber;
}
