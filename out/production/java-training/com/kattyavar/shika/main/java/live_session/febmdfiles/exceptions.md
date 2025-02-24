# Java Exceptions

In Java, an exception is an event that disrupts the normal flow of the program. When an exceptional situation occurs, it is represented as an object that contains information about the error. Java provides a robust exception-handling mechanism to gracefully manage these situations.


## Exception Types:
- *Checked Exceptions*: 
  -  These are exceptions that are checked at compile-time. You must handle these exceptions explicitly using a try-catch block or declare them using throws in the method signature. Examples include IOException, SQLException.
- *Unchecked Exceptions:*:
  -  These exceptions occur during runtime and are not checked by the compiler. They are subclasses of RuntimeException. Examples include NullPointerException, ArrayIndexOutOfBoundsException.
- *Errors*
  - These are severe problems that the application is not expected to handle, such as OutOfMemoryError or StackOverflowError. Errors are typically not caught by the application.


## Exception Hierarchy:

- The base class of all exceptions in Java is Throwable.
  - Error class is for serious issues (usually not caught by programs).
  - Exception class is for issues that programs can handle (divided into checked and unchecked exceptions).
    - RuntimeException class: Unchecked exceptions.
    - Other exceptions: Checked exceptions.


## Handling Exceptions:

- try-catch block: You put the code that might throw an exception in the try block, and handle the exception in the catch block.

```java
try {
    // Code that may throw an exception
} catch (ExceptionType e) {
    // Handle the exception
}

```


- finally block: Code inside the finally block will always execute, regardless of whether an exception occurred or not. It is often used for cleanup activities like closing files or releasing resources.

```java
try {
    // Code that may throw an exception
} catch (ExceptionType e) {
    // Handle the exception
} finally {
    // Cleanup code (will always run)
}

```

- Throw keyword:
  - This is used to explicitly throw an exception from a method or block of code

```java
throw new ExceptionType("Message");

```

- throws keyword:
  - Used in method declarations to specify that a method may throw an exception, passing the responsibility of handling it to the calling method.

```java
public void someMethod() throws IOException {
    // Method that may throw IOException
}

```

Example of Exception Handling:

```java
public class ExceptionExample {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Execution completed.");
        }
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}

```

## Custom Exception:

In Java, you can define your own exceptions by creating a custom exception class. Custom exceptions can be helpful when you want to handle specific errors in your application that don't fall under the existing Java exceptions.


- Steps to Create a Custom Exception:
  - Extend the Exception class (for checked exceptions) or RuntimeException (for unchecked exceptions).
  - Define a constructor that passes a message or other relevant details to the parent class.


Define the Custom Exception

```java
// Custom exception class
public class InvalidAgeException extends Exception {
    
    // Constructor that accepts a custom error message
    public InvalidAgeException(String message) {
        super(message);
    }
}

```

Use the Custom Exception

```java
public class Registration {

    public static void main(String[] args) {
        try {
            registerUser("John", 16);  // This will throw the custom exception
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void registerUser(String name, int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older. Provided age: " + age);
        }
        System.out.println("User registered successfully: " + name);
    }
}

```


## Custom Unchecked Exception Example:

If you want to create an unchecked exception (a subclass of RuntimeException), here's how you can do it:


```java
// Custom unchecked exception
public class InvalidAgeRuntimeException extends RuntimeException {

    public InvalidAgeRuntimeException(String message) {
        super(message);
    }
}

```

In this case, you don't need to declare the exception in the method signature or catch it explicitly (though you can). It can be used in the same way as the checked exception but without requiring explicit exception handling.


## When to Use Custom Exceptions:

- Domain-specific errors: When you need to signal application-specific errors (e.g., invalid input, failed business rules).
- Clear error messages: When you want to provide more detailed, descriptive error messages to users or developers.
- Separation of concerns: To isolate specific types of errors from generic ones like NullPointerException or IllegalArgumentException.




##  try-with-resources 
- The try-with-resources statement in Java is a feature introduced in Java 7 that simplifies resource management (like closing files, streams, or database connections). It ensures that all resources are automatically closed at the end of the try block, even if an exception occurs.

### Key points about Try-with-Resources:

- A resource is any object that implements the AutoCloseable interface (or java.io.Closeable, which is a more specific subtype of AutoCloseable).
- Resources are automatically closed after the try block is finished executing (either normally or due to an exception).
- You don't need to explicitly call close() on the resource; it’s done automatically.


Example : Using Try-with-Resources

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        // Use try-with-resources to automatically close resources
        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle exceptions (e.g., file not found)
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

```

## Multiple Resources in Try-with-Resources

- You can also manage multiple resources in a single try-with-resources statement by separating them with a semicolon (;).

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResourcesMultiple {
    public static void main(String[] args) {
        // Using multiple resources: reading from one file and writing to another
        try (
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            FileWriter fw = new FileWriter("output.txt")
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                fw.write(line + "\n");  // Write the read content to the output file
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

```


### Why Use Try-with-Resources?
- Cleaner Code: Reduces the need for explicitly closing resources, which is especially useful for handling multiple resources.
- Exception Safety: Ensures that resources are always closed even if an exception is thrown.
- Prevents Leaks: Avoids forgetting to close resources, which can lead to resource leaks and inefficient memory usage.



