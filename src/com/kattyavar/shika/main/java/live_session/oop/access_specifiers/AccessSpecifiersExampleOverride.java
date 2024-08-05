package com.kattyavar.shika.main.java.live_session.oop.access_specifiers;

public class AccessSpecifiersExampleOverride {
    public static void main(String[] args) {

    }
}

interface IAbc {
    //you can have only final static ....
    void show();
    void display();
    void runServer();
    default void readConfig() {
        //Apply the logic here...
    }
    static void printeMe(){
    }
    private void yesWeCanHavePrivateMethod(){
    }
}


abstract class CAbc {
    //you can store any variable
    abstract void show();
    abstract void display();
    abstract void runServer();
    void readConfig() {
        //Apply the logic here...
    }
    static void printeMe(){
    }
    private void yesWeCanHavePrivateMethod(){
    }
}

//You dont want some should create the object using new.. \
abstract class BaseAbstract {

}

class Base {
    void defaultMethod() {
        System.out.println("Default");
    }

    void defaultMethod1() {
        System.out.println("Default");
    }

    void defaultMethod2() {
        System.out.println("Default");
    }


    public void publicMethod() {
        System.out.println("Public method...");
    }

    protected void protectedMethod() {
        System.out.println("Protected Method...");
    }

    protected void proctedMethod2() {
        System.out.println("In protected method 2...");
    }
}

class Derived extends Base {

    @Override
    public void defaultMethod() {

        System.out.println("Default method...");

    }

    @Override
    protected void defaultMethod1() {
        super.defaultMethod1();
    }

    @Override
    void defaultMethod2() {
        super.defaultMethod2();
    }

    //Can I make this as private. No you can't....

    //We can change public access specifier in derived class regardless of abstract or normal class

    @Override
    public void publicMethod() {
        super.publicMethod();
    }

    @Override
    protected void protectedMethod() {
        super.protectedMethod();
    }

    @Override
    public void proctedMethod2() {
        super.proctedMethod2();
    }
}

