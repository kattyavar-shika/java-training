# Stream 

In Java, a Stream is a sequence of elements that supports sequential and parallel aggregate operations.   
It is not a data structure, but rather a view of a data source (like collections, arrays, or I/O channels) that allows functional-style operations to be performed on it.

Streams were introduced in Java 8 as part of the java.util.stream package.


```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.stream()
     .filter(name -> name.startsWith("A"))
     .forEach(System.out::println);

```


## Key Differences: Stream vs for-loop / enhanced for-loop

| **Feature**    | **Stream**                                               | **for-loop / enhanced for-loop**                      |
|----------------|-----------------------------------------------------------|--------------------------------------------------------|
| **Style**       | Functional programming style                              | Imperative style                                       |
| **Conciseness** | More concise and readable for complex operations         | More verbose for filtering, mapping, etc.              |
| **Parallelism** | Easy to parallelize using `.parallelStream()`            | Manual effort needed for parallelism                   |
| **Mutability**  | Encourages immutability (no side-effects)                | Often involves mutable variables                       |
| **Chaining**    | Allows chaining of multiple operations (filter, map, etc.) | Requires nesting or multiple loops                     |
| **Use Case**    | Best for bulk operations on data                         | Best for simple iteration and when index is needed     |


Example:
Using enhanced for-loop:


```java
for (String name : names) {
  if (name.startsWith("A")) {
  System.out.println(name);
    }
      }

```

Using Stream 

```java
names.stream()
     .filter(name -> name.startsWith("A"))
     .forEach(System.out::println);

```


## Key Characteristics of Streams

- **Declarative**: Streams allow you to specify what you want to achieve, rather than how to achieve it. This leads to more readable and maintainable code.

- **Functional Style**: Streams support a functional approach to processing sequences, including operations like `map`, `filter`, and `reduce`.

- **Lazy Evaluation**: Operations on streams are not executed until a terminal operation is invoked. This allows for optimization and efficiency improvements, such as short-circuiting or pipelining.

- **Non-Interfering**: The operations on a stream do not modify the underlying data structure. They produce a new stream or result, leaving the original data unchanged.

- **Parallel Processing**: Streams can be processed in parallel to take advantage of multi-core processors, potentially improving performance for large datasets.

## Types of Streams

- **Sequential Streams**: These process elements in a sequence, one after another.

- **Parallel Streams**: These can process elements concurrently using multiple threads, which can improve performance for large datasets.

## Basic Stream Operations

- **Intermediate Operations**: These operations transform a stream into another stream and are lazy. Examples include `filter`, `map`, and `sorted`.

- **Terminal Operations**: These produce a result or a side-effect and trigger the processing of the stream. Examples include `collect`, `forEach`, and `reduce`.


#  Method Reference in Java

A method reference is a shorthand syntax for calling a method directly in Java. Instead of writing a lambda expression that calls a method, you can use a method reference to directly refer to a method by its name. Method references are used primarily to simplify the code when the method body is just calling an existing method.

```java
ClassName::methodName

```
- Static methods: ClassName::methodName
- Instance methods: objectInstance::methodName
- Constructor references: ClassName::new


## Types of Method References:

- Static Method Reference: Referring to a static method in a class.

```java
import java.util.*;

class MathOperations {
    public static int square(int x) {
        return x * x;
    }
}

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Using lambda expression
        numbers.stream()
               .map(n -> MathOperations.square(n))  // Lambda expression
               .forEach(System.out::println);  // Output: 1 4 9 16 25

        // Using method reference (static method reference)
        numbers.stream()
               .map(MathOperations::square)  // Method reference
               .forEach(System.out::println); // Output: 1 4 9 16 25
    }
}

```

- Explanation: MathOperations::square is a method reference to the static method square(). It works exactly the same as the lambda expression n -> MathOperations.square(n) but in a more concise way.



- 2. Instance Method Reference:

If we have an instance method, you can refer to it using an instance method reference.

```java
import java.util.*;

class Printer {
    public void print(String message) {
        System.out.println(message);
    }
}

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> messages = List.of("Hello", "World", "Method Reference");

        Printer printer = new Printer();

        // Using lambda expression
        messages.forEach(message -> printer.print(message));

        // Using method reference (instance method reference)
        messages.forEach(printer::print);  // Output: Hello World Method Reference
    }
}

```

Explanation: printer::print is an instance method reference, referring to the print() method of the Printer object.


- 3. Constructor Reference:

You can also use method references for constructors.

```java
import java.util.*;

class Person {
    String name;

    // Constructor to initialize Person object
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class MethodReferenceExample {
    public static void main(String[] args) {
        // Using lambda expression
        List<String> names = List.of("Alice", "Bob", "Charlie");
        names.stream()
             .map(name -> new Person(name))  // Lambda expression
             .forEach(person -> System.out.println(person.getName()));

        // Using method reference (constructor reference)
        names.stream()
             .map(Person::new)  // Constructor reference
             .forEach(person -> System.out.println(person.getName()));  // Output: Alice Bob Charlie
    }
}

```

Explanation: Person::new is a constructor reference, which refers to the Person constructor that takes a String as an argument.




# Intermediate Operations

## 1. filter() - filter based on condition

```java
Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
Stream<Integer> evenStream = stream.filter(n -> n % 2 == 0);

```

## 2. map() - transform elements

```java
Stream<String> names = Stream.of("Alice", "Bob");
Stream<Integer> lengths = names.map(String::length);
//Same 
Stream<Integer> lengths = names.map(x -> x.length());

```

## 3. sorted() - sort elements

```java
Stream<String> sorted = Stream.of("Charlie", "Alice", "Bob")
    .sorted();

```
With Comparator 

```java
List<String> names = List.of("Alice", "Bob", "Charlie");
    names.stream()
      .sorted((a, b) -> b.compareTo(a))  // Sort in reverse order
      .forEach(System.out::println); // Output: Charlie, Bob, Alice

```

## 4. distinct() - remove duplicates

```java
Stream<Integer> unique = Stream.of(1, 2, 2, 3).distinct();

```

## 5. limit() and skip()

```java
Stream<Integer> limited = Stream.of(1, 2, 3, 4, 5).limit(3);
Stream<Integer> skipped = Stream.of(1, 2, 3, 4, 5).skip(2);

```

## flatmap()

flatMap() takes a function that produces a stream of values for each input element, then flattens the result into a single stream.

It is typically used when you have a collection of collections (e.g., lists inside a list) and you want to "flatten" them into a single collection.

In simpler terms:
- map() transforms each element into one output element.
- flatMap() transforms each element into zero or more output elements (a stream of elements).

```java
 List<List<String>> nestedList = List.of(
      List.of("A", "B"),
      List.of("C", "D", "E"),
      List.of("F", "G")
    );

    // Using flatMap to flatten the list of lists
    List<String> flatList = nestedList.stream()
      .flatMap(x -> x.stream())  // Flatten the inner lists
      .collect(Collectors.toList());
```

using MethodRef : 

```java
 List<List<String>> nestedList = List.of(
            List.of("A", "B"),
            List.of("C", "D", "E"),
            List.of("F", "G")
        );

        // Using flatMap to flatten the list of lists
        List<String> flatList = nestedList.stream()
            .flatMap(Collection::stream)  // Flatten the inner lists
            .collect(Collectors.toList());
```


## peek()

The peek() method is another intermediate operation in Java Streams that is often overlooked. While it’s not commonly used in **production code** for transforming data, it can be very useful for debugging and inspection of the elements in the stream.

```java
import java.util.*;
import java.util.stream.*;

public class PeekExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        // Using peek to observe each element in the stream
        List<String> result = names.stream()
            .peek(name -> System.out.println("Processing: " + name))  // Action on each element
            .filter(name -> name.startsWith("A"))                     // Intermediate operation
            .collect(Collectors.toList());                             // Terminal operation

        System.out.println(result);  // Output: [Alice]
    }
}

```

## boxed()

boxed() is an intermediate operation that converts a primitive stream into a stream of objects.

This is particularly useful because the Stream API works with objects, not primitives. When working with primitive streams (like IntStream), you might need to convert them to object streams (like Stream<Integer>).


```java
import java.util.*;
import java.util.stream.*;

public class BoxedExample {
    public static void main(String[] args) {
        // Creating a primitive IntStream
        IntStream intStream = IntStream.of(1, 2, 3, 4);

        // Convert IntStream to Stream<Integer> and apply map operation
        List<Integer> result = intStream
            .boxed()  // Convert to Stream<Integer>
            .map(i -> i * 2)  // Apply transformation
            .collect(Collectors.toList());

        System.out.println(result);  // Output: [2, 4, 6, 8]
    }
}

```

## takeWhile() (Java 9+)

This operation allows you to take elements from the stream while the elements satisfy a given predicate (condition).

Once an element fails the predicate, the operation terminates early and does not process further elements.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
List<Integer> result = numbers.stream()
    .takeWhile(n -> n < 4)  // Take while numbers are less than 4
    .collect(Collectors.toList());
System.out.println(result);  // Output: [1, 2, 3]

```


Note:
The takeWhile() operation in Java Streams works by processing the elements sequentially from the start of the stream and continues to process elements as long as the condition is true. Once the condition is false, it stops processing and ignores the rest of the elements, including those that come after the first one that fails the condition.



# Terminal Operations

## 1. collect() - collect to List/Set/etc.

```java
List<String> result = Stream.of("A", "B", "C")
    .collect(Collectors.toList());

```

## 2. forEach() - perform action for each

```java
Stream.of("Java", "Stream")
    .forEach(System.out::println);

```

## 3. reduce() - reduce to single value

```java
int sum = Stream.of(1, 2, 3)
    .reduce(0, Integer::sum);  // Output: 6

```

The reduce() operation reduces the stream to a single value by repeatedly applying a combining function to the elements.


There are 3 variants of reduce():

- 1 T reduce(T identity, BinaryOperator<T> accumulator)

Parameter : 

- identity: the initial value (or seed).
- accumulator: a function to combine two elements.

```java
List<Integer> numbers = List.of(1, 2, 3, 4);

int sum = numbers.stream()
    .reduce(0, (a, b) -> a + b);

System.out.println(sum); // Output: 10

```

- 2. Optional<T> reduce(BinaryOperator<T> accumulator)


Same as above, but no identity value, so it returns an Optional<T> (because the stream might be empty).

```java
List<Integer> numbers = List.of(5, 6, 7);

Optional<Integer> result = numbers.stream()
    .reduce((a, b) -> a + b);

result.ifPresent(System.out::println); // Output: 18

```


## 4. count() - count elements

```java
long count = Stream.of(1, 2, 3, 4).count();  // Output: 4

```

## 5. anyMatch(), allMatch(), noneMatch()

```java
boolean anyEven = Stream.of(1, 2, 3).anyMatch(n -> n % 2 == 0);   // true
boolean allEven = Stream.of(2, 4, 6).allMatch(n -> n % 2 == 0);   // true
boolean noneNegative = Stream.of(1, 2, 3).noneMatch(n -> n < 0); // true

```

Example: 

Input as 

```java
List<Person> people = Arrays.asList(
    new Person("Alice", 30, "New York"),
    new Person("Bob", 22, "Los Angeles"),
    new Person("Charlie", 35, "Chicago"),
    new Person("Diana", 24, "Miami"),
    new Person("Eve", 28, "San Francisco")
);

```
Given a list of Person objects, filter out only those who are older than 25.

```java
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // Sample list of Person objects
        List<Person> people = Arrays.asList(
            new Person("Alice", 30, "New York"),
            new Person("Bob", 22, "Los Angeles"),
            new Person("Charlie", 35, "Chicago"),
            new Person("Diana", 24, "Miami"),
            new Person("Eve", 28, "San Francisco")
        );

        // 1. Filter people who are older than 25
        List<Person> filteredPeople = people.stream()
            .filter(person -> person.getAge() > 25)
            .collect(Collectors.toList());

        // Output the result
        System.out.println(filteredPeople);
    }
}

```

Sorting the Filtered List by Age

```java
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // Sample list of Person objects
        List<Person> people = Arrays.asList(
            new Person("Alice", 30, "New York"),
            new Person("Bob", 22, "Los Angeles"),
            new Person("Charlie", 35, "Chicago"),
            new Person("Diana", 24, "Miami"),
            new Person("Eve", 28, "San Francisco")
        );

        // 1. Filter people who are older than 25
        List<Person> filteredPeople = people.stream()
            .filter(person -> person.getAge() > 25)
            .collect(Collectors.toList());

        // 2. Sort the filtered people by age in ascending order
        List<Person> sortedPeople = filteredPeople.stream()
            .sorted(Comparator.comparingInt(Person::getAge))
            .collect(Collectors.toList());

        // Output the result
        System.out.println(sortedPeople);
    }
}

```

Extracting Names from the Sorted List
Let's extract only the names of the people from the sorted list and store them in a List<String>.


```java
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // Sample list of Person objects
        List<Person> people = Arrays.asList(
            new Person("Alice", 30, "New York"),
            new Person("Bob", 22, "Los Angeles"),
            new Person("Charlie", 35, "Chicago"),
            new Person("Diana", 24, "Miami"),
            new Person("Eve", 28, "San Francisco")
        );

        // 1. Filter people who are older than 25
        List<Person> filteredPeople = people.stream()
            .filter(person -> person.getAge() > 25)
            .collect(Collectors.toList());

        // 2. Sort the filtered people by age in ascending order
        List<Person> sortedPeople = filteredPeople.stream()
            .sorted(Comparator.comparingInt(Person::getAge))
            .collect(Collectors.toList());

        // 3. Extract the names of the sorted people
        List<String> names = sortedPeople.stream()
            .map(Person::getName) // Extract names
            .collect(Collectors.toList());

        // Output the result
        System.out.println(names);
    }
}

```

Limiting the Number of Names to 3

Now, we need to return only the first three names from the list of names, if available.

```java
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // Sample list of Person objects
        List<Person> people = Arrays.asList(
            new Person("Alice", 30, "New York"),
            new Person("Bob", 22, "Los Angeles"),
            new Person("Charlie", 35, "Chicago"),
            new Person("Diana", 24, "Miami"),
            new Person("Eve", 28, "San Francisco")
        );

        // 1. Filter people who are older than 25
        List<Person> filteredPeople = people.stream()
            .filter(person -> person.getAge() > 25)
            .collect(Collectors.toList());

        // 2. Sort the filtered people by age in ascending order
        List<Person> sortedPeople = filteredPeople.stream()
            .sorted(Comparator.comparingInt(Person::getAge))
            .collect(Collectors.toList());

        // 3. Extract the names of the sorted people
        List<String> names = sortedPeople.stream()
            .map(Person::getName)
            .collect(Collectors.toList());

        // 4. Limit the list to the first 3 names
        List<String> limitedNames = names.stream()
            .limit(3)
            .collect(Collectors.toList());

        // Output the result
        System.out.println(limitedNames);
    }
}

```