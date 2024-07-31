package com.kattyavar.shika.main.java.live_session.interface_example;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 * Why we need interface
 * Types of interface.
 * normal interface
 * functional interface - yet to cover.. we have seen the definition
 * marker interface
 * <p>
 * Abstract class vs interface with below aspect
 * Methods
 * Fields
 * Constructor
 * Inheritance
 * Default implementation
 * static method
 * instantiation
 * <p>
 * Interfaces and inheritance
 * interface only extends interface ore or more.
 * <p>
 * private method : Introduced in Java 9, private methods in interfaces allow you to define helper methods that are used internally within the interface itself. These methods cannot be accessed or overridden by implementing classes or interfaces.
 * <p>
 * private Vs Default method.
 * - static method
 */

class Base {

}

public class InterfaceExample {

    public static void main(String[] args) throws CloneNotSupportedException, IOException {

        Demo obj = new Demo();


        obj.useThis();
    }


}

interface IDefalutExample {
    default void display (){
        System.out.println("in Display from interface...");
    }
}

class Demo {

     void display (){
        System.out.println("in Display from interface...");
    }

    public void useThis() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("person.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(this);
    }
}

abstract class CanIStoreMemberVAriable {
    private String name;
    public Integer age;
    private final Integer maxAge = 39;
    protected static String staticVarName;
    private static final String staticFinalVar = "Yes we can..";


}