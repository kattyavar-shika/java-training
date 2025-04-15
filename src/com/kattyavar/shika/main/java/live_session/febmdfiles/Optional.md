# What is the Optional Class?

The Optional class is part of Java 8 and is used to represent a container object which may or may not contain a value. It’s a type-level solution for representing optional values instead of using null.

The main idea behind the Optional class is to avoid NullPointerExceptions and to make code more expressive and safe when dealing with potentially missing values.   
Instead of directly dealing with null (which often leads to errors), Optional provides a more controlled and readable way to handle missing values.

Definition of Optional Class

The Optional class is a generic class in the java.util package. Here's its definition:

```java
public final class Optional<T> {
    // Constructors, methods, and other functionalities
}

```
- T is the type of value contained inside the Optional.
- Optional can either contain a value (i.e., Optional.of(T value)), or it may be empty (i.e., Optional.empty()).




# Why Use Optional?
- Avoid NullPointerException:
  - Traditionally, null is used to indicate the absence of a value, but this can lead to errors when the value is accessed without checking for null.
  - With Optional, you can avoid this problem in a more explicit way.
- Improved Readability:
  - Optional makes it clear when a value might not exist, making the code more self-documenting and readable.
- Functional Programming Style:
  - Optional fits well with functional programming principles, as it supports methods like map(), flatMap(), filter(), etc., that can help you chain operations safely.


# Core Methods of Optional
- Creating an Optional object:
  - Optional.of(T value): Creates an Optional containing the specified non-null value.
    - Optional.of(T value) will throw NullPointerException if the provided value is null.

  - Optional.ofNullable(T value): Creates an Optional that may contain a non-null value or be empty.
    - Optional.ofNullable(T value) allows null values and returns an empty Optional if the value is null.

  - Optional.empty(): Returns an empty Optional (i.e., no value).


- Checking the presence of a value:
  - isPresent(): Returns true if the value is present, otherwise false.
  - ifPresent(Consumer<? super T> action): If a value is present, it performs the given action with the value; otherwise, it does nothing.

- Getting the value:
  - get(): Returns the value if present, otherwise throws NoSuchElementException. (Not recommended unless you're sure the value is present)
  - orElse(T other): Returns the value if present, otherwise returns the given default value (other).
  - orElseGet(Supplier<? extends T> other): Returns the value if present, otherwise returns the result of the given supplier.
  - orElseThrow(Supplier<? extends X> exceptionSupplier): Returns the value if present, otherwise throws an exception created by the given supplier.


- Transforming the value:
  - `map(Function<? super T, ? extends U> mapper): If a value is present, it applies the given function to the value and returns an Optional of the transformed value. If no value is present, it returns an empty Optional.`
  - `flatMap(Function<? super T, Optional<U>> mapper): Similar to map(), but the function must return an Optional instead of just a transformed value.`
  - `filter(Predicate<? super T> predicate): If a value is present, it filters the value using the given predicate and returns an Optional containing the value if it passes the filter. If no value is present or the value doesn't satisfy the predicate, it returns an empty Optional.`

# Types of Optional

There are generally two types of Optional:

- Non-empty Optional:
  - An Optional that contains a value. Example: Optional.of(value).

- Empty Optional:
  - An Optional that does not contain a value. Example: Optional.empty() or Optional.ofNullable(null).


Example Usage of Optional

1. Creating an Optional

```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // Non-empty Optional (with a value)
        Optional<String> nonEmptyOptional = Optional.of("Hello, World!");
        
        // Empty Optional (no value)
        Optional<String> emptyOptional = Optional.empty();

        // Optional with a nullable value
        Optional<String> nullableOptional = Optional.ofNullable(null); // This will be empty
        Optional<String> nullableOptionalWithValue = Optional.ofNullable("Value"); // This will contain a value

        System.out.println("Non-Empty Optional: " + nonEmptyOptional);
        System.out.println("Empty Optional: " + emptyOptional);
        System.out.println("Nullable Optional (empty): " + nullableOptional);
        System.out.println("Nullable Optional (with value): " + nullableOptionalWithValue);
    }
}

```


2. Checking if a Value is Present

```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hello");

        // Checking if value is present
        if (optional.isPresent()) {
            System.out.println("Value is present: " + optional.get());
        } else {
            System.out.println("No value present");
        }
    }
}

```

3. Using ifPresent()
 
```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hello");

        // Perform an action if value is present
        optional.ifPresent(value -> System.out.println("Value is: " + value));
    }
}

```


4. Using orElse() to Provide a Default Value
 
```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);

        // Provide a default value if the Optional is empty
        String result = optional.orElse("Default Value");
        System.out.println(result); // Output: Default Value
    }
}

```

5. Using map() to Transform the Value

```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hello");

        // Using map() to transform the value
        Optional<String> transformedOptional = optional.map(value -> value.toUpperCase());
        System.out.println(transformedOptional.get()); // Output: HELLO
    }
}

```

6. Using filter() to Conditionally Process

```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<Integer> number = Optional.of(10);

        // Using filter to only allow even numbers
        Optional<Integer> evenNumber = number.filter(n -> n % 2 == 0);
        evenNumber.ifPresent(n -> System.out.println("Even Number: " + n));  // Output: Even Number: 10
    }
}

```



# Key Differences Between `map()` in Java Streams and `map()` in Optional

| **Aspect**                       | **map() in Java Streams**                                        | **map() in Optional**                                          |
|----------------------------------|-------------------------------------------------------------------|----------------------------------------------------------------|
| **Purpose**                      | Transforms each element of a stream                               | Transforms the value inside an Optional if present             |
| **Input**                        | A stream of values (`Stream<T>`)                                  | An `Optional<T>` containing a value or nothing (`Optional<T>`) |
| **Output**                       | A transformed stream of values (`Stream<R>`)                      | A new `Optional` containing a transformed value or empty       |
| **Handling of Empty/Null**       | Does not handle empty streams explicitly, can result in empty stream after transformation | Returns an empty `Optional` if the original `Optional` is empty |
| **Common Use Case**              | When you need to perform an operation on every element of the stream (e.g., map, filter, etc.) | When you need to transform the value inside an `Optional` safely, avoiding null checks |
| **Return Type**                  | A stream (`Stream<R>`)                                            | An `Optional<U>`                                                |




Summary of Key Differences:
- Stream map() is for transforming elements in a stream of data and returns a new stream with the transformed data.
- Optional map() is for transforming the value inside an Optional if present, and returns a new Optional containing the transformed value (or an empty Optional if the original one was empty).
















