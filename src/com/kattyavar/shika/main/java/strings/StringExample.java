package com.kattyavar.shika.main.java.strings;

import java.util.ArrayList;
import java.util.List;

public class StringExample {

    public static void main(String[] args) {

        //How to create string in java?
        //There are two ways to create string in java

        /** 1) String literal
         *  It's important to note that string literals are immutable in Java, meaning their values cannot be changed once they are created.
         *  This property ensures that once a string literal is interned in the string pool, it remains consistent and can be safely shared across different parts of your Java program.
         */
        String str = "Kattyaar shika";

        /**
         * String Literal Creation: "Kattyaar shika" is a string literal. When Java encounters this literal during execution,
         * it checks if an equivalent string already exists in the string pool.
         *
         * String Pool Behavior:
         *
         * If "Kattyaar shika" does not exist in the string pool, Java creates a new entry for it.
         * If "Kattyaar shika" already exists in the string pool (from a previous encounter or due to another variable holding the same literal), Java reuses the existing instance instead of creating a new one.
         * Assignment: The variable str is then assigned a reference to the string literal "Kattyaar shika" from the string pool.
         *
         * Memory Efficiency: String literals are interned by default in Java, meaning identical string literals are stored only once in the string pool. This saves memory and enhances performance by reducing the number of String objects created.
         *
         * Therefore, in your example:
         *
         * str will reference the existing string literal "Kattyaar shika" from the string pool if it already exists there.
         */

        //2) Using new keyword.
        String strUsingNew = new String("Kattyaar shika");

        //Common String Methods

        //To get the length of String
        System.out.println("String length = " + str.length());

        //To get charter at specific index. Note Index start from zero.
        System.out.println("Charter at 4th location = " + str.charAt(1));

        //To get the substring beginIndex from 9 to end of string. Note all index start at zero.
        System.out.println("Substring from specific index till end of string = " + str.substring(9));


        //Make string all char to upper case, note original str object will not change.
        System.out.println("All charter to upper case = " + str.toUpperCase());

        System.out.println("Even after applying toUpperCase please check str content as = " + str);

        //TODO add other methods...

        List<String> list = new ArrayList<>();


    }
}

