# Why lambda?


## Assigning Behavior to Variables in Java

Before lambdas, behavior was usually tied to objects (via methods inside classes).  
With lambdas, we can store behavior as a variable and pass it around just like data.


Example: Assigning Behavior to a Variable (Before Java 8 - Using Anonymous Class)

```java
interface MathOperation {
    int operate(int a, int b);
}

public class AnonymousClassExample {
    public static void main(String[] args) {
        // Defining behavior using an anonymous class
        MathOperation addition = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };

        // Using the behavior
        System.out.println(addition.operate(5, 3)); // Output: 8
    }
}

```

Works, but requires too much boilerplate!


Same Example Using Lambda (Java 8)

```java
interface MathOperation {
    int operate(int a, int b);
}

public class LambdaExample {
    public static void main(String[] args) {
        // Storing behavior in a variable using a lambda
        MathOperation addition = (a, b) -> a + b;

        // Using the behavior
        System.out.println(addition.operate(5, 3)); // Output: 8
    }
}

```

### Why is Assigning Behavior to Variables Useful?
- Increases Code Reusability – You can pass behavior (lambda) as a method argument.
- Reduces Boilerplate Code – No need for extra class definitions.
- Makes Code More Functional – Enables functional programming techniques like higher-order functions.



# Passing Behavior as a Parameter

Once behavior is assigned to a variable, it can be passed to methods.

Example: Passing Lambda as a Method Parameter

```java
public class LambdaAsArgument {
    public static void main(String[] args) {
        MathOperation multiply = (a, b) -> a * b;

        // Passing lambda to a method
        executeOperation(4, 5, multiply); // Output: 20
    }

    // Method that takes a behavior (MathOperation) as an argument
    public static void executeOperation(int a, int b, MathOperation operation) {
        System.out.println(operation.operate(a, b));
    }
}

interface MathOperation {
    int operate(int a, int b);
}

```

Now, we can pass different operations dynamically without changing the method implementation!


## How Functional and Object-Oriented Paradigms Work Together in Java

- Lambdas in Java allow us to use functional programming concepts within an object-oriented structure.

Traditional Object-Oriented Approach (Before Java 8)


```java
interface Calculator {
    int calculate(int a, int b);
}

class Addition implements Calculator {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}

public class OOPExample {
    public static void main(String[] args) {
        Calculator addition = new Addition(); // Object-oriented approach
        System.out.println(addition.calculate(5, 3)); // Output: 8
    }
}

```

Behavior is encapsulated inside a class (Addition) and called through an instance.


Functional Approach Using Lambda (Java 8)

```java
interface Calculator {
    int calculate(int a, int b);
}

public class FPExample {
    public static void main(String[] args) {
        // Assigning function behavior to a variable (Functional approach)
        Calculator addition = (a, b) -> a + b;
        System.out.println(addition.calculate(5, 3)); // Output: 8
    }
}

```

Combining OOP and FP
Java does not eliminate OOP—it integrates functional programming concepts into its OOP model.

```java
import java.util.function.Function;

class MathOperations {
    Function<Integer, Integer> square = (n) -> n * n;

    int applyOperation(int x) {
        return square.apply(x); // Calling lambda inside a class
    }
}

public class HybridExample {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();
        System.out.println(math.applyOperation(4)); // Output: 16
    }
}

```

