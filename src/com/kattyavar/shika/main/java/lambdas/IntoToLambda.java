package com.kattyavar.shika.main.java.lambdas;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class IntoToLambda {

  public void executeTask() {
    System.out.println("Executing task 1");
  }


  public void executeTask(Action task) {
    task.execute();
  }

  public static void main(String[] args) {


    new IntoToLambda().executeTask();

    //Passing the Behaviour to execute Task
    new IntoToLambda().executeTask(new Task2());

    //Option 2
    new IntoToLambda().executeTask(new Action() {
      @Override
      public void execute() {
        System.out.println("Executing temp task...");
      }
    });


    //Can we pass function to executeTask() ?
    //As in java everything is object = data + method

    /**
     * for Example
     * int i = 10 (Where i is variable and 10 is it values
     * long j = 2010; ( j is variable and 2010 is it values
     * so can we have something
     *
     *  functionvar = {
     *  block of code...
     *  }
     *  But keeping in mind what should be data type of functionvar?
     */

    new IntoToLambda().executeTask(() -> System.out.println(" I am working on lambda task.."));

    Predicate<String> predicate = s -> s.length() > 0;

    BiFunction<Integer, Integer, Integer> addition = (a, b) -> a + b;


    System.out.println("Find out the order of print statement...");
    execute("Check the wrapper part...", wrapper((a) -> System.out.println("We need to print input as ===> " + a)));

    int x = 30;
    //Note x should be final. If you try to change you will get compiler error.

    //What jvm will do at runtime it will replace i + x = i + 30.
    closuresExample(10, (i)-> System.out.println(i + x));

  }


  public static void closuresExample(int i, Consumer<Integer> consumer){
    consumer.accept(i);
  }


  public static void execute(String str, Consumer<String> consumer) {
    System.out.println("I am in execute method to execute lambda..");
    consumer.accept(str); // as this will call wrapper lambda
  }

  public static Consumer<String> wrapper(Consumer<String> consumer) {
    return (a) -> {
      System.out.println(" I am in wrapper lambda...");
      consumer.accept(a); // This will call original pass lambda
    };
  }




}

class Task2 implements Action {
  @Override
  public void execute() {
    System.out.println("Executing task 2");
  }
}


