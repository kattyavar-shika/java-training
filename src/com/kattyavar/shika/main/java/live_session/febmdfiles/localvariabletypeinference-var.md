# Var

local variable type inference is a feature introduced in Java 10 that allows the compiler to automatically infer the type of a local variable based on the assigned value.  
This is done using the keyword var.   
It reduces the need for explicitly specifying the type of a variable when it is clear from the context, making the code more concise and readable.

# How does it work?

Instead of explicitly declaring the type of a local variable, you can use var, and the Java compiler will infer the type based on the expression on the right-hand side of the assignment.

Example: 
```java
public class Main {
    public static void main(String[] args) {
        var message = "Hello, World!"; // Java infers the type as String
        var number = 42;               // Java infers the type as int
        var decimal = 3.14;            // Java infers the type as double
        var isActive = true;           // Java infers the type as boolean
        
        System.out.println(message);   // Output: Hello, World!
        System.out.println(number);    // Output: 42
        System.out.println(decimal);   // Output: 3.14
        System.out.println(isActive);  // Output: true
    }
}

```

## Key points about var:

- Type Inference: The compiler determines the type of the variable based on the initializer (the value assigned to it).
- Cannot be null: You cannot use var for variables that are initialized with null because the type cannot be inferred from null.
```java
var someVar = null; // Error: Cannot infer type from null

```

- Type must be clear: The compiler must be able to clearly infer the type from the context. If the type is ambiguous, the code will not compile.

```java
var x; // Error: Cannot infer type because no initializer is provided

```

- Scope: var is only for local variables (i.e., inside methods or constructors). You cannot use var for instance variables, class variables, or method parameters.

```java
public class Main {
    var message = "Hello"; // Error: 'var' can only be used for local variables
}

```

