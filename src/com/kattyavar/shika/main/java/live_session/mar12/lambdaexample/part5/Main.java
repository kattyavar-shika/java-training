package com.kattyavar.shika.main.java.live_session.mar12.lambdaexample.part5;

public class Main {

  static MyFunction higherOrderFunctionExample(MyFunction function) {

    System.out.println("higherOrderFunctionExample is creating new function / Preparation phase");


    return x -> {

      try {
        return function.apply(x);
      } catch (Exception e) {

        return null;
      }

    };

  }


  public static void main(String[] args) {

    MyFunction multiply2 = x -> {

      System.out.println("Inside multiply2 lambda: Multiplying " + x + " by 2");
      return x * 2;
    };

    MyFunction newFunction = higherOrderFunctionExample(multiply2);

    newFunction.apply(10);

    // Function that adds 3
    MyFunction add3 = x -> {
      System.out.println("Inside add3 lambda: Adding 3 to " + x);
      return x + 3;
    };

    Integer result = multiply2.apply(4);
    result = add3.apply(result);

//    Can we do it this way...
//    MyFunction multiplyThenAdd = multiply2.andThen(add3);


  }
}


interface MyFunction {
  Integer apply(Integer x);
}

class Temp implements MyFunction {
  @Override
  public Integer apply(Integer x) {
    return x + 1;
  }
}