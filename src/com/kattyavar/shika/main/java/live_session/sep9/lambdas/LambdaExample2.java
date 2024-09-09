package com.kattyavar.shika.main.java.live_session.sep9.lambdas;

import java.util.function.BiFunction;

public class LambdaExample2 {
  public void executeTask(Action action) {
    action.execute();
  }

  static public Boolean checkCondition(checkCondition condtion, Integer input) {
    return condtion.test2(input);
  }


  public static void main(String[] args) {


    LambdaExample2 obj = new LambdaExample2();


    obj.executeTask(() -> System.out.println(" I can do any thing i dont need to worry about method name..."));

    obj.executeTask(() -> System.out.println("I am executing task 3..."));


    checkCondition checkConditionVar = (Integer i) -> {
      if (i > 30) {
        return true;
      }
      return false;
    };

    boolean result = checkCondition(checkConditionVar, 10);

    System.out.println("WE got the result == " + result);

    /***
     * 1) return type of above function is = void
     * 2) What is the data type of this code ---> () -> {
     *       System.out.println("I am executing task 2...");
     *     };
     *
     *     int i = 10
     *
     *     functionVar = {
     *
     *     System.out.println("about to connect to db");
     *     // here some code to connect to DB
     *     System.out.println("Lets make backend call.....");
     *     // here is code to make backend call..
     *      //here some code...
     *
     * // Here get the total number of record in employ table.
     *      //and finally return the total number of record in employ tables...
     *
     *
     *     }
     *
     *     //What is the function return type... int...
     *     //but question is what the data type of above function...
     */

    BiFunction<Integer, Integer, Integer> addition = (a, b) -> a + b;
    addition.apply(5, 7);


    //


  }
}

interface MyBiFunction {
  Integer myAddition(Integer a, Integer d);
}


interface checkCondition {
  boolean test2(Integer input);

  private void iCanHaveIt() {

  }

  default void iCanHaveDefaultMethod() {

  }

  static void iCanHaveStaticMethod() {

  }
}


