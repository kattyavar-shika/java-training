# Why Use Lambdas in Java?

Lambdas, introduced in Java 8, allow you to write more concise and expressive code by providing a way to represent anonymous functions.  
A lambda expression is a short block of code that takes parameters and returns a value, without requiring a full method definition.

By eliminating the need for anonymous inner classes, lambdas enhance code readability, functional programming capabilities, and parallel processing in Java.  
This document explains why lambdas are beneficial and how they improve Java programming.

## 1. Conciseness and Readability

Lambdas allow for a more compact and readable syntax compared to traditional anonymous inner classes. This makes the
code shorter and easier to understand.

### Example

**Traditional Anonymous Inner Class:**

```java
Runnable r = new Runnable() {
  @Override
  public void run() {
    System.out.println("Hello, World!");
  }
};

```

lambda equivalent to the first example:

```java
Runnable r = () -> System.out.println("Hello, World!");

```

## 2.Enhanced Functional Programming Support

Lambdas enable a functional programming style by allowing you to pass behavior as parameters, return behavior from
methods, and operate on data in a functional manner.

```java
List<String> names = Arrays.asList("prasad", "patil", "Amol");
names.

stream()
.

filter(name ->name.

startsWith("A"))
  .

forEach(System.out::println);
```

## 3. Reduction of Boilerplate Code

Lambdas reduce the amount of boilerplate code required to create instances of single-method interfaces. This results in
more concise and manageable code.

```java
// Using Anonymous Inner class
ActionListener listener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("Button clicked");
    }
  };

// Using lambda. we can write same as below. 

ActionListener listener = e -> System.out.println("Button clicked");

```

## 4. Efficient Parallel Processing

Lambdas, in conjunction with the Streams API, simplify writing parallelized code. This can lead to performance
improvements with minimal changes to your code.

```java 
List<String> names = Arrays.asList("prasad", "patil", "Amol");
names.

parallelStream().

forEach(name ->System.out.

println(name));

```

## 5. Easier to use API and libraries.

Lambdas allow for cleaner and more expressive API designs by supporting functional-style programming. Java’s
java.util.function package includes several functional interfaces, such as Predicate, Function, Consumer, and Supplier,
which are commonly used with lambdas.

```java 
List<String> names = Arrays.asList("prasad", "patil", "Amol");
names.forEach(name ->System.out.println(name));

```

# Key Concepts of Functional Programming.

## 1. First-Class and Higher-Order Functions

First-Class Functions: Functions are treated as first-class citizens. This means functions can be assigned to variables,
passed as arguments to other functions, and returned as values from other functions.

Example

```java 
// Example in JavaScript
const add =(a,b)=>a +b;
const operate =(func,x,y)=>

func(x, y);
console.

log(operate(add, 2,3)); // Output: 5
```

in java

```java 
import java.util.function.BiFunction;

public class HigherOrderFunctionExample {
  public static void main(String[] args) {
    // Define a lambda expression for the 'add' function
    BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

    // Define the higher-order function 'operate'
    int result = operate(add, 2, 3);

    // Print the result
    System.out.println(result); // Output: 5
  }

  // Higher-order function that accepts a BiFunction and two integers
  public static int operate(BiFunction<Integer, Integer, Integer> func, int x, int y) {
    return func.apply(x, y);
  }
}
```

## 2. Immutability

Immutable Data: Data is not changed after it is created. Instead of modifying existing data, new data structures are
created. This helps avoid side effects and makes the code easier to reason about

```java 
// Example in JavaScript
const originalArray =[1,2,3];
  const newArray =originalArray.

map(x =>x*2);
console.

log(newArray); // Output: [2, 4, 6]
```

## 3. Pure Functions

Pure Functions: Functions that have the same output for the same input and do not have side effects (i.e., they do not
alter any state outside their scope).

```java
// Example in JavaScript
const add =(a,b)=>a +b; // Pure function

```

in java

```java 
public class PureFunctions {
  public static void main(String[] args) {
    System.out.println(add(2, 3)); // Output: 5
  }

  public static int add(int a, int b) {
    return a + b;
  }
}
```

## 4. Declarative vs. Imperative

Declarative Programming: Focuses on what should be done rather than how. Functional programming is declarative because
it focuses on describing the logic of computation without specifying the control flow.

```java 
// Example in JavaScript using map (declarative)
const numbers =[1,2,3];
  const doubled =numbers.

map(x =>x*2);
```

in Java

```java 
import java.util.Arrays;
import java.util.List;

public class DeclarativeProgramming {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    // Declarative approach using Streams
    numbers.stream()
      .filter(n -> n % 2 == 0)
      .map(n -> n * 2)
      .forEach(System.out::println); // Output: 4 8
  }
}
```

Imperative Programming: Focuses on how to perform tasks using explicit control flow.

```java 
// Example in JavaScript using for loop (imperative)
const numbers =[1,2,3];
  const doubled =[];
  for(
let i = 0;
i<numbers.length;i++){
  doubled.

push(numbers[i]*2);
}
```

in java

```java 
import java.util.Arrays;
import java.util.List;

public class ImperativeProgramming {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    for (Integer number : numbers) {
      if (number % 2 == 0) {
        System.out.println(number * 2);
      }
    }
  }
}
```

## 5. Lazy Evaluation

Lazy Evaluation: Expressions are not evaluated until their values are needed. This can improve performance by avoiding
unnecessary computations.

```java
// Example in JavaScript (using generators for lazy evaluation)
function*

infiniteSequence() {
  let i = 0;
  while (true) yield i++;
}
const sequence =

infiniteSequence();
console.

log(sequence.next().value); // Output: 0
```

in java

```java 
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluation {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    // Lazy evaluation using Streams
    Stream<Integer> stream = numbers.stream()
      .filter(n -> n % 2 == 0)
      .map(n -> {
        System.out.println("Mapping " + n);
        return n * 2;
      });

    // Nothing is printed yet, processing happens here when you do terminal operation on Stream.
    stream.forEach(System.out::println);
  }
}
```

## 6. Concurrency

Immutable data structures and pure functions facilitate concurrent and parallel processing.

## 7. Referential Transparency

if an expression is replaced by its result and the program behaves the same way, then the expression is referentially
transparent.

```java
public class ReferentialTransparencyExample {
  public static void main(String[] args) {
    int x = 5;
    int result = add(x, 10); // result is 15

    // You can replace the expression `add(x, 10)` with its value `15` without changing the behavior
    System.out.println(result); // Output: 15
  }

  // Pure function: The result depends only on the inputs, and has no side effects
  public static int add(int a, int b) {
    return a + b;
  }
}
```

Non Referential Transparency.

```java 
public class NonReferentialTransparencyExample {
  private static int counter = 0;

  public static void main(String[] args) {
    int result = incrementAndAdd(10); // result will be 11
    System.out.println(result); // Output: 11
  }

  // Not referentially transparent because it has side effects
  public static int incrementAndAdd(int value) {
    counter++; // Side effect: modifies external state
    return value + counter;
  }
}
```

Side Effect: The function incrementAndAdd modifies the counter variable, which is external to the function. The result
depends on the internal state of the counter, which changes each time the function is called.

No Substitution: You cannot substitute incrementAndAdd(10) with a fixed value because its result depends on the state of
counter. Replacing the function call with a fixed value would alter the program’s behavior.

# Functional Programming Vs Object Oriented Programming.

| Object Oriented Programming                                                                                                                                                                                                              | Functional Programming                                                                                                                                                                                                     |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Functions that are associated with an object. They operate on the data contained within the object.                                                                                                                                      | Standalone entities that operate on input and produce output. They are not tied to any particular object.                                                                                                                  |
| Data is encapsulated within objects and can be mutable.                                                                                                                                                                                  | Data is immutable. Operations produce new data rather than modifying existing data.                                                                                                                                        |
| Objects maintain state through attributes, and methods modify the object's state.                                                                                                                                                        | No mutable state; state is managed through function arguments and return values.                                                                                                                                           |
| Imperative Approach: Focuses on how to achieve a task by specifying the sequence of operation                                                                                                                                            | Declarative Approach: Focuses on what to compute rather than how to compute it.                                                                                                                                            |
| Concurrency: Requires careful handling of mutable state to avoid issues like race conditions. Synchronization mechanisms are often needed to manage concurrent access to shared state.                                                   | Concurrency: Naturally suited for concurrent programming due to immutability and stateless functions. Since functions don’t modify shared state, they can be executed in parallel more safely.                             |
| Object-Oriented Programming: Focuses on encapsulation, inheritance, and polymorphism. It models real-world entities as objects, making it ideal for applications that benefit from a structured approach to managing state and behavior. | Functional Programming: Emphasizes immutability, pure functions, and higher-order functions. It’s great for tasks that can be expressed in terms of transformations and is particularly suited for concurrent programming. |

# how to Define lambda.

( argument list ) -> { body of function }

## Zero argument and return void.

```java
 ()->System.out.println("ok");
```

## Take one input and return the boolean.

```java 
Predicate<String> predicate = s -> s.length() > 0;
```

## Taking two int parameter and return int values

```java 
BiFunction<Integer, Integer, Integer> addition = (a, b) -> a + b;
```

## Take two argument and return void

```java
BiConsumer<String, String> biConsumer = (s1, s2) -> System.out.println(s1 + s2);
```

you can find more details about interface

https://docs.oracle.com/en%2Fjava%2Fjavase%2F11%2Fdocs%2Fapi%2F%2F/java.base/java/util/function/package-summary.html

so you don't need to recreate your own interface. you can reuse.

# How to wrap lambda.

```java 

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

//To call this.. 
// execute("Check the wrapper part...", wrapper((a) -> System.out.println("We need to print input as ===> " + a)));

```

Another example 

```java
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

    MyFunction wrapFunction = wrapFunction(multiply2);

    // Function Invocation: Calling wrapped function
    System.out.println("\nCalling wrapFunction.apply(4):");
    System.out.println("Step 1: wrapFunction.apply(4) is called, which triggers the wrapped lambda");
    System.out.println("Step 2: The wrapped lambda executes and calls multiply2.apply(4)");
    System.out.println("Step 3: multiply2 lambda executes and returns 4 * 2 = 8");
    System.out.println("Step 4: Wrapped lambda receives the result (8) and prints the final output");

    System.out.println("End Step. now see the actual result...\n\n");
    wrapFunction.apply(4);

  }
}


interface MyFunction {
  int apply(int x);
}
```

# Closures example.

```java
  public static void closuresExample(int i, Consumer<Integer> consumer) {
  consumer.accept(i);
}

public static void closureUsage() {
  int x = 30;
  //Note x should be final. If you try to change you will get compiler error.

  //What jvm will do at runtime it will replace i + x = i + 30.
  closuresExample(10, (i) -> System.out.println(i + x));
}
  ```

# Do we have this for lambda in following case ?

## static context

## instance method.

```java
 import java.util.function.Consumer;

class LambdaExample {

  void instanceMethod(String message) {
    System.out.println("Instance method: " + message);

    // ✅ Using 'this' inside an instance method
    this.anotherInstanceMethod("Called from instanceMethod using this");
  }

  void anotherInstanceMethod(String message) {
    System.out.println("Another instance method: " + message);
  }

  static void staticMethod(String message) {
    System.out.println("Static method: " + message);
  }

  void nonStaticContextDemo() {
    // ✅ Allowed: Using 'this' inside a non-static method
    Consumer<String> lambdaInstance = this::instanceMethod;
    lambdaInstance.accept("Hello from instance using this!");

    // ✅ Allowed: Calling static method via class reference
    Consumer<String> lambdaStatic = LambdaExample::staticMethod;
    lambdaStatic.accept("Hello from static inside instance method!");
  }

  static void staticContextDemo() {
    // ❌ ERROR: 'this' cannot be used in a static method
    // Consumer<String> lambdaInstance = this::instanceMethod; // Compilation Error!

    // ✅ Correct way: Create an instance first
    LambdaExample obj = new LambdaExample();
    Consumer<String> lambdaInstance = obj::instanceMethod;
    lambdaInstance.accept("Hello from instance inside static!");
  }

  public static void main(String[] args) {
    LambdaExample obj = new LambdaExample();

    System.out.println("Calling from non-static context:");
    obj.nonStaticContextDemo();

    System.out.println("\nCalling from static context:");
    staticContextDemo();
  }
}

```


# andThen

```java

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
```