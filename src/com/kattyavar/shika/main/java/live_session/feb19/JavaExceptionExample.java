package com.kattyavar.shika.main.java.live_session.feb19;

import com.kattyavar.shika.main.java.generics.howgenricesolveissue.Box;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JavaExceptionExample {


  static <T> void testMe(List<T> testMe){}

  public static void main(String[] args) {

    List<Integer> abc = new ArrayList<>();
    List<String> abc1 = new ArrayList<>();

    testMe(abc);

    testMe("Hello World...", 1, 0);
    //testMe(null, 1, 1);
    //testMe("What will happen to me...", 1, 1);
  }

  static void testMe(String input, Integer a, Integer b) throws RuntimeException {

  // BufferedReader br = new BufferedReader(new FileReader("abc.txt"));

   //br.close();

    try {
      System.out.println("Lenght of input is as ->" + input.length());

      System.out.println("We have input as " + input);
      try {
        try {

        } catch (Exception e) {

        }

      } catch (Exception e) {

      }


      System.out.println("Divide A /B ans = " + a / b);

    } catch (NullPointerException ex) {
      System.out.println(" in Catch block ---> We got the exception " + ex.toString());
      throw  new RuntimeException("Let see how it work");

    } catch (ArithmeticException ex) {
      System.out.println(" in Catch block ---> We got the exception " + ex.toString());

    } catch (IndexOutOfBoundsException ex) {

    } catch (ClassCastException ex) {

    } finally {
      System.out.println("When this will get executed ....");
     // br.close();
    }
    /*
    catch (Exception ex ){
      System.out.println(" in Catch block ---> We got the exception " + ex.toString());

      throw new RuntimeException("This will not workl...."); // Or i can send custom exception ...
      //throw ex;
    }

     */


  }

}





