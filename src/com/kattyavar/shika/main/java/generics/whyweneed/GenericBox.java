package com.kattyavar.shika.main.java.generics.whyweneed;

//Simple format
//public class GenericBox<T> {
//For this GenericBox<String> is not allowed as String is not subclass of String
//public class GenericBox<T extends Number> {
//Here first should be class if you have any, or you can use interface directly then you can add any number of interface separated by &
//public class GenericBox<T extends Number & DummyForDemoPurpose> {
public class GenericBox<T > {

  T item;

  public GenericBox() {
    System.out.println("IN Default constructor...");
  }

  public GenericBox(T item) {
    this.item = item;

  }

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }
}


interface DummyForDemoPurpose {
  default void display() {
    System.out.println("In dummy interface..");
  }
}


/***
 * 1. Basic Generic Class
 * class ClassName<T> {
 *     // This class can accept any type for T
 * }
 * Explanation:
 * ClassName<T> is a generic class where T can be any type.
 * This means you can instantiate it with any object type (e.g., ClassName<String>, ClassName<Integer>).
 * This allows for flexibility and reusability of the class with different types.
 * 2. Generic Class with an Upper Bound
 * class ClassName<T extends Number> {
 *     // This class can only accept types that are subclasses of Number (e.g., Integer, Double)
 * }
 * Explanation:
 * ClassName<T extends Number> restricts T to be a subclass of Number or Number itself. This constraint ensures that T must be a type like Integer, Double, or any other class that extends Number. This is useful when you need to perform operations that are only valid for Number types.
 * 3. Generic Class with Multiple Type Parameters
 * java
 * Copy code
 * class ClassName<T, V> {
 *     // This class can accept two different types for T and V
 * }
 * Explanation: ClassName<T, V> is a generic class with two type parameters. T and V can be different types, giving you the flexibility to use two distinct types in your class. For example, ClassName<String, Integer> can hold a String and an Integer.
 * 4. Generic Class with an Interface Bound
 * java
 * Copy code
 * class ClassName<T extends InterfaceNameType> {
 *     // T can be any type that implements InterfaceNameType
 * }
 * Explanation: ClassName<T extends InterfaceNameType> restricts T to be a type that implements the InterfaceNameType interface. This is useful when you want to ensure that T provides specific methods defined by InterfaceNameType.
 */