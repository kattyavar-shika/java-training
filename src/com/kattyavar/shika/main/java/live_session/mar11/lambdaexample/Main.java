package com.kattyavar.shika.main.java.live_session.mar11.lambdaexample;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

  static Integer cnt = 10;

  static Integer add(Integer a, Integer b) { //pure function...
    return a + b;
  }

  public void applyOperationAsPerNeed(MathOperation operationInterface) {
    operationInterface.readFileFromDist();
  }

  public static void main(String[] args) {

    //We will think about return type after some time..
    MathOperation abc = () -> System.out.println("Subtraction operation ");

    Main obj = new Main();

    System.out.println("Let try to check with the new way...");

    obj.applyOperationAsPerNeed(() -> System.out.println("lambda way of doing the thing... operation "));
    obj.applyOperationAsPerNeed(() -> System.out.println("Matrix multiplication "));
    obj.applyOperationAsPerNeed(() -> System.out.println("dot product ... "));
    obj.applyOperationAsPerNeed(() -> System.out.println("I can do anything now... "));
    obj.applyOperationAsPerNeed(() -> System.out.println("I can do anything now... "));
    obj.applyOperationAsPerNeed((MathOperation) abc);


    Integer result = add(1, 2); //result = 3
    result = 3; //result = 3
    result = add(1, 2); //result = 3
    result = add(1, 2); //result = 3
  }
}

interface MathOperation {
  void readFileFromDist();


  //void readFileFromDist();
  //Retrun Type functionName(parameters name ...)
  //Return Type i don't care about functionnamer(Parameter Name )

}

class Addition implements MathOperation {

  //@Override
  public void applyOperation() {
    System.out.println("Addition of the numbers...");
  }

  //@Override
  public void readFileFromDist() {

  }
}

class Subtraction implements MathOperation {
  //@Override
  public void applyOperation() {
    System.out.println("Subtraction operation ");

  }

  @Override
  public void readFileFromDist() {

  }
}