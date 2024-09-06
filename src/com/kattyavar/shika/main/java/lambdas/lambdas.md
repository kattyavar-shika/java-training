# Why Use Lambdas in Java?

Lambdas, introduced in Java 8, offer several advantages that enhance the language and make it more versatile.
This document explains why lambdas are beneficial in Java.

## 1. Conciseness and Readability

Lambdas allow for a more compact and readable syntax compared to traditional anonymous inner classes. This makes the code shorter and easier to understand.

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

## 2.Enhanced Functional Programming Support
Lambdas enable a functional programming style by allowing you to pass behavior as parameters, return behavior from methods, and operate on data in a functional manner.

```java
List<String> names = Arrays.asList("prasad", "patil", "Amol");
names.stream()
.filter(name -> name.startsWith("A"))
.forEach(System.out::println);
```

## 3. Reduction of Boilerplate Code
Lambdas reduce the amount of boilerplate code required to create instances of single-method interfaces. This results in more concise and manageable code.


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
Lambdas, in conjunction with the Streams API, simplify writing parallelized code. This can lead to performance improvements with minimal changes to your code.

```java 
List<String> names = Arrays.asList("prasad", "patil", "Amol");
names.parallelStream().forEach(name -> System.out.println(name));

```

## 5. Easier to use API and libraries. 
Lambdas allow for cleaner and more expressive API designs by supporting functional-style programming. Java’s java.util.function package includes several functional interfaces, such as Predicate, Function, Consumer, and Supplier, which are commonly used with lambdas.

```java 
List<String> names = Arrays.asList("prasad", "patil", "Amol");
names.forEach(name -> System.out.println(name));
```

# Key Concepts of Functional Programming. 

## 1. First-Class and Higher-Order Functions
First-Class Functions: Functions are treated as first-class citizens. This means functions can be assigned to variables, passed as arguments to other functions, and returned as values from other functions.

Example 

```java 
// Example in JavaScript
const add = (a, b) => a + b;
const operate = (func, x, y) => func(x, y);
console.log(operate(add, 2, 3)); // Output: 5
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
Immutable Data: Data is not changed after it is created. Instead of modifying existing data, new data structures are created. This helps avoid side effects and makes the code easier to reason about

```java 
// Example in JavaScript
const originalArray = [1, 2, 3];
const newArray = originalArray.map(x => x * 2);
console.log(newArray); // Output: [2, 4, 6]
```

## 3. Pure Functions 
Pure Functions: Functions that have the same output for the same input and do not have side effects (i.e., they do not alter any state outside their scope).

```java
// Example in JavaScript
const add = (a, b) => a + b; // Pure function

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

Declarative Programming: Focuses on what should be done rather than how. Functional programming is declarative because it focuses on describing the logic of computation without specifying the control flow.

```java 
// Example in JavaScript using map (declarative)
const numbers = [1, 2, 3];
const doubled = numbers.map(x => x * 2);
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
const numbers = [1, 2, 3];
const doubled = [];
for (let i = 0; i < numbers.length; i++) {
  doubled.push(numbers[i] * 2);
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

Lazy Evaluation: Expressions are not evaluated until their values are needed. This can improve performance by avoiding unnecessary computations.
```java
// Example in JavaScript (using generators for lazy evaluation)
function* infiniteSequence() {
  let i = 0;
  while (true) yield i++;
}
const sequence = infiniteSequence();
console.log(sequence.next().value); // Output: 0
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
if an expression is replaced by its result and the program behaves the same way, then the expression is referentially transparent.

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

Side Effect: The function incrementAndAdd modifies the counter variable, which is external to the function. The result depends on the internal state of the counter, which changes each time the function is called.

No Substitution: You cannot substitute incrementAndAdd(10) with a fixed value because its result depends on the state of counter. Replacing the function call with a fixed value would alter the program’s behavior.


# Functional Programming Vs Object Oriented Programming. 

| Object Oriented Programming                                                                         | Functional Programming|
|-----------------------------------------------------------------------------------------------------|-----------------------|
| Functions that are associated with an object. They operate on the data contained within the object. |  Standalone entities that operate on input and produce output. They are not tied to any particular object.                     |
| Data is encapsulated within objects and can be mutable.                                             |  Data is immutable. Operations produce new data rather than modifying existing data.                     |
| Objects maintain state through attributes, and methods modify the object's state.                   | No mutable state; state is managed through function arguments and return values.                      |
| Imperative Approach: Focuses on how to achieve a task by specifying the sequence of operation       | Declarative Approach: Focuses on what to compute rather than how to compute it.                      |
| Concurrency: Requires careful handling of mutable state to avoid issues like race conditions. Synchronization mechanisms are often needed to manage concurrent access to shared state.                                                                                                    | Concurrency: Naturally suited for concurrent programming due to immutability and stateless functions. Since functions don’t modify shared state, they can be executed in parallel more safely.                      |
| Object-Oriented Programming: Focuses on encapsulation, inheritance, and polymorphism. It models real-world entities as objects, making it ideal for applications that benefit from a structured approach to managing state and behavior.                                                                                                    |Functional Programming: Emphasizes immutability, pure functions, and higher-order functions. It’s great for tasks that can be expressed in terms of transformations and is particularly suited for concurrent programming.                       |
