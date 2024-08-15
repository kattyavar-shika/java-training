package com.kattyavar.shika.main.java.live_session.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenericsExample {

  void additionExample() {

    IntegerAddition integerAddition1 = new IntegerAddition(10);
    IntegerAddition integerAddition2 = new IntegerAddition(20);


    Integer result = integerAddition1.addition(integerAddition2);


    Integer obj1 = Integer.valueOf(10);
    Integer obj2 = Integer.valueOf(20);
    result = obj1 + obj2;

  }

  void someOldCode (){

    /*
    IntegerBox integerBox = new IntegerBox(10);
    integerBox.display();
    StringBox stringBox = new StringBox("Paitl");
    stringBox.display();
    StudentBox studentBox = new StudentBox();
    studentBox.display();
     */
    //


    //GenericBox<Integer> integerGenericBox = new GenericBox<>(10);
    //GenericBox<String> stringGenericBox = new GenericBox<>("Patil");
    // GenericBox<Student> studentGenericBox = new GenericBox<>(new Student("A", "p", 1));
    //GenericBox<Objects> objectsGenericBox = new GenericBox<>();

    /*
    GenericBox<C> obj = new GenericBox<>(new C());
    GenericBox<A> objA = new GenericBox<>(new A());

    obj.display();
    objA.display();

    GenericBox<Integer, String, String, Student> obj3;

    Map<String, Student> map;

    //integerGenericBox.display();
    //stringGenericBox.display();
    //studentGenericBox.display();

     */
  }
  public static void main(String[] args) {

    List<Object> stringList = new ArrayList<>();


    pleasePrintMe(stringList);

    List<Object> names = new ArrayList<>();

    names.add("Option1");
    names.add("Option2");
    names.add("Option3");
    names.add("Option4");
    //....
    names.add(new Student("a", "b", 1));


    //At the time retiterive you will find out the issues.


    //String name1 = (String) names.get(4); // you will get error fot this line...

  }






  public static void pleasePrintMe(List<? super Number> obj){

    System.out.println(obj);
  }


  public static  <T, V, Z> T printAnything(T object, V objec2, Z object3) {
    System.out.println("Let print it out.." + object);
    return object;
  }







}

class A{

public   String nameA;
  public void displayA(){

    System.out.println("In DisplayA method");
  }
  public void display(){

    System.out.println("In A display");
  }

}
class B extends A{
  public String nameB;

  public void displayB(){
  }
  public void display(){

    System.out.println("In B display");
  }

}
class C extends  B {
  private String nameC;
  public void displayC(){

  }
  public void display(){

    System.out.println("In C display");
  }


}

class Student {
  String name;
  String lastName;
  Integer rollNumber;

  public Student(String name, String lastName, Integer rollNumber) {
    this.name = name;
    this.lastName = lastName;
    this.rollNumber = rollNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getRollNumber() {
    return rollNumber;
  }

  public void setRollNumber(Integer rollNumber) {
    this.rollNumber = rollNumber;
  }
}

interface Employee {
  void displayEmployee();

}

interface Employee2 {
  void displayEmployee2();
}

