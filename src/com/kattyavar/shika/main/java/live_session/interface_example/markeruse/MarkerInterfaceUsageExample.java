package com.kattyavar.shika.main.java.live_session.interface_example.markeruse;

import java.io.*;

public class MarkerInterfaceUsageExample {


    public static void letsPutSomeCommonCode(Object obj) {
        if (obj instanceof AmolFriend) {
            // if some tries to make post .. stop him doing so...
            System.out.println("Yes I can trust this object, lets apply the predefine logic... ");
        } else {
            System.out.println("I don't know what to do with this object...");
        }
    }

    public static void letHaveLookAtSerialiizing() throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("abc.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        Prasad prasadObj = new Prasad();

        //This call will get fail if you dont implements Serializable
        objectOutputStream.writeObject(prasadObj);
    }

    public static void main(String[] args) throws IOException {


        Prasad prasadObj = new PatilSena();
        letsPutSomeCommonCode(prasadObj);

       // System.out.println("Let crate the patil instance ");
        //Patil patilObj = new Patil();

        //letsPutSomeCommonCode(patilObj);

//        letHaveLookAtSerialiizing();

    }
}

//Marker interface example as

/**
 * Cloneable
 * Serializable
 * Remote interface
 */



interface IBase1 {
    void display();
}

interface IBase2 {
    void display2();
}

interface IBaseDerived extends IBase1, IBase2 {

    default void display2(){
        System.out.println("Lets override the display2 method...");
    }

    void display3();
}


class Temp3 implements IBaseDerived {
    @Override
    public void display3() {

    }

    @Override
    public void display() {

    }
}


interface AmolFriend {

}

class Temp implements Serializable {

}

class Patil implements AmolFriend {

    public Patil() {
    }
}

class Prasad extends Patil {
    private String name;

    public Prasad() {
        name = "Prasad sir";
        System.out.println("In Prasad Sir class");
    }
}

class PatilSena extends  Prasad {

}

