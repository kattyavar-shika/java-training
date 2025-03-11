package com.kattyavar.shika.main.java.live_session.mar11;

public class HigherOrderFunctionExample {


  static MyFunction wrapFunction(MyFunction function) {
    System.out.println("wrapFunction is creating a new function (Function Wrapping / Preparation Phase)");
    return x -> { // Returns a new function (lambda)
      System.out.println("Inside wrapped lambda: Received input " + x);
      System.out.println("Before calling function " + x);
      int result = function.apply(x); // Call the passed function (Function Invocation)
      System.out.println("After calling result " + result);
      return result;
    };
  }


  public static void main(String[] args) {

    MyFunction multiply2 = x -> {
      System.out.println("Inside multiply2 lambda: Multiplying " + x + " by 2");
      return x * 2;
    };

    // Function that adds 3
    MyFunction add3 = x -> {
      System.out.println("Inside add3 lambda: Adding 3 to " + x);
      return x + 3;
    };

    MyFunction wrapFunction = wrapFunction(multiply2);

    // Function Invocation: Calling wrapped function
    System.out.println("\nCalling wrapFunction.apply(4):");
    System.out.println("Step 1: wrapFunction.apply(4) is called, which triggers the wrapped lambda");
    System.out.println("Step 2: The wrapped lambda executes and calls multiply2.apply(4)");
    System.out.println("Step 3: multiply2 lambda executes and returns 4 * 2 = 8");
    System.out.println("Step 4: Wrapped lambda receives the result (8) and prints the final output");

    System.out.println("End Step. now see the actual result...\n\n");
    wrapFunction.apply(4);

    //Now let have look at use of andThen example
    System.out.println("\nUsing andThen to chain multiply2 and add3:");
    MyFunction multiplyThenAdd = multiply2.andThen(add3);
    int chainedResult = multiplyThenAdd.apply(4); // (4 * 2) + 3 = 11
    System.out.println("Final Result using andThen: " + chainedResult);
  }
}


interface MyFunction {
  int apply(int x);

  default MyFunction andThen(MyFunction after){
    return x -> {
      int intermediate = this.apply(x);
      System.out.println("andThen: First function result = " + intermediate);
      return after.apply(intermediate);
    };
  }
}