package com.kattyavar.shika.main.java.trickquestion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class finalTest {
  public static void main(String[] args) {

    Stack<String> abc  = new Stack<>();

    abc.push(null);
    abc.push(null);
    abc.push(null);
    abc.push(null);
    abc.push("non Empty");

    Set<String> set = new HashSet<>();

    set.add(null);
    set.add(null);
    set.add(null);
    set.add("Non empty");

    System.out.println(abc);

    System.out.println("Set entries");
    System.out.println(set);



  }

}

class Base {
  public void readFile()  throws ArrayIndexOutOfBoundsException{
    // Implementation
  }
}

class Derived extends Base {
  public void readFile() throws RuntimeException { // Allowed
    // Implementation
  }
}