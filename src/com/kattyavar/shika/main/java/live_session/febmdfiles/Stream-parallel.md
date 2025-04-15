# Parallel Streams in Java

A parallel stream is a special type of stream in Java introduced in Java 8 that allows operations on the stream to be performed concurrently using multiple threads.   
The Stream API provides a way to convert a stream into a parallel stream by calling the parallel() method.   
This can potentially improve performance, especially when dealing with large datasets, by taking advantage of multiple CPU cores.

However, using parallel streams is not always beneficial.   
It depends on factors like the size of the dataset, the nature of the operations, and the overhead of managing multiple threads.   
Parallel streams are particularly useful when the operations are independent (i.e., no side-effects) and can be divided into smaller chunks.

## How Parallel Streams Work

When a stream is converted to parallel, the underlying fork/join framework is used to divide the stream into multiple substreams. Each substream is processed in parallel by different threads.

The results of these substreams are then combined to produce the final result.

### Creating a Parallel Stream

You can create a parallel stream in two ways:

- Using the parallel() method: This converts an existing stream into a parallel stream.

```java
Stream<T> parallelStream = stream.parallel();

```

- Using the parallelStream() method on collections: If you have a Collection (like a List or Set), you can directly create a parallel stream using the parallelStream() method.

```java
List<T> list = new ArrayList<>();
Stream<T> parallelStream = list.parallelStream();

```

## When to Use Parallel Streams

Parallel streams are useful in the following scenarios:

- The operation performed on each element is independent (e.g., no side-effects).
- The dataset is large enough to benefit from parallelization.
- The cost of dividing the data and combining the results is not higher than the performance gain from parallelism.
- The hardware has multiple CPU cores to perform parallel execution.

However, parallel streams should not be used for tasks like:
- Operations with side-effects (like modifying shared variables).
- Small datasets, where the overhead of managing threads may outweigh the benefits.
- State-dependent operations (e.g., incrementing a counter shared by multiple threads).



# What is a Side Effect?

A side effect in functional programming refers to any interaction with the outside world or modification of state that occurs during the execution of a function.   
Examples of side effects include:
- Modifying a variable outside the function scope.
- Writing to a file or console (I/O operations).
- Changing the state of an object.
- Updating a global variable or external resource.

In contrast, operations that are side-effect free do not alter any state outside their scope and do not rely on or modify any variables outside of their immediate context.


## No Side Effects in Java Streams

When working with Java Streams, operations are typically designed to be stateless and side-effect free. For example, map() performs an operation on each element independently without modifying external variables or state.


Example of a side-effect-free operation in Java Streams:

```java
import java.util.List;
import java.util.stream.Collectors;

public class NoSideEffectExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        
        // Operation is side-effect free; does not modify anything outside the scope
        List<Integer> squares = numbers.stream()
                                       .map(n -> n * n)
                                       .collect(Collectors.toList());
        
        System.out.println(squares);  // Output: [1, 4, 9, 16, 25]
    }
}

```

Here, the operation n * n (mapping each number to its square) does not modify any external state, nor does it rely on or change any variables outside of the stream.


Example of a Side Effect in Java Streams

Now, let's take a look at an example of an operation that does introduce side effects. This is often considered poor practice in streams because it can lead to unpredictable results, especially when combined with parallel streams.

Example of a side-effect operation in Java Streams:

```java
import java.util.List;
import java.util.stream.Collectors;

public class SideEffectExample {
    static int counter = 0;  // A shared state variable (side effect)

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        
        // Operation with side effects: modifying an external variable 'counter'
        List<Integer> result = numbers.stream()
                                      .map(n -> {
                                          counter++;  // This introduces a side effect by modifying 'counter'
                                          return n * n;
                                      })
                                      .collect(Collectors.toList());

        System.out.println(result);  // Output: [1, 4, 9, 16, 25]
        System.out.println("Counter value: " + counter);  // Counter value changes unpredictably
    }
}

```

Why is This a Side Effect?

In the above code, counter++ introduces a side effect because it modifies a shared variable (counter) from outside the scope of the stream operation. This is problematic for a few reasons:

- **Non-Deterministic Behavior:** In parallel streams, the order of operations is not guaranteed. This could lead to unpredictable results, as counter might be updated by multiple threads concurrently.
- **Harder to Test:** Code with side effects is often harder to reason about and test because it introduces state changes that aren't directly linked to the input/output of the operation.
- **Potential Bugs:** Side effects make the code less predictable and harder to debug, especially when working with concurrent execution.






# Example of Parallel Stream


Example 1: Parallel Stream for Summing Values

```java
import java.util.*;
import java.util.stream.*;

public class ParallelStreamExample {
    public static void main(String[] args) {
        // Creating a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using a parallel stream to sum the values
        int sum = numbers.parallelStream()  // Convert list to parallel stream
                          .mapToInt(Integer::intValue)  // Convert Integer to int
                          .sum();  // Sum all elements

        System.out.println("Sum of numbers: " + sum);  // Output: 55
    }
}

```

Example 2: Parallel Stream with Filtering and Mapping

```java
import java.util.*;
import java.util.stream.*;

public class ParallelStreamExample {
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using parallel stream to filter even numbers and square them
        List<Integer> result = numbers.parallelStream()
                                      .filter(n -> n % 2 == 0)  // Filter even numbers
                                      .map(n -> n * n)           // Square the numbers
                                      .collect(Collectors.toList());  // Collect the result into a list

        System.out.println("Squared even numbers: " + result);  // Output: [4, 16, 36, 64, 100]
    }
}

```

Example 3: Parallel Stream with Performance Comparison

```java
import java.util.*;
import java.util.stream.*;

public class ParallelStreamExample {
    public static void main(String[] args) {
        // List with a large number of elements
        List<Long> numbers = new ArrayList<>();
        for (long i = 1; i <= 100000000L; i++) {
            numbers.add(i);
        }

        // Sequential stream sum
        long startTime = System.currentTimeMillis();
        long sequentialSum = numbers.stream()
                                    .mapToLong(Long::longValue)
                                    .sum();
        long sequentialTime = System.currentTimeMillis() - startTime;

        // Parallel stream sum
        startTime = System.currentTimeMillis();
        long parallelSum = numbers.parallelStream()
                                  .mapToLong(Long::longValue)
                                  .sum();
        long parallelTime = System.currentTimeMillis() - startTime;

        // Display results
        System.out.println("Sequential sum: " + sequentialSum);
        System.out.println("Time taken for sequential stream: " + sequentialTime + " ms");

        System.out.println("Parallel sum: " + parallelSum);
        System.out.println("Time taken for parallel stream: " + parallelTime + " ms");
    }
}

```

```java
import java.util.*;
import java.util.stream.*;

public class ParallelStreamExample {
    public static void main(String[] args) {
        // Creating a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Creating a regular sequential stream
        Stream<Integer> sequentialStream = numbers.stream();

        // Convert the sequential stream to parallel using parallel()
        int sum = sequentialStream.parallel()  // Convert to parallel stream
                                  .mapToInt(Integer::intValue)  // Convert Integer to int
                                  .sum();  // Sum all elements

        System.out.println("Sum of numbers (parallel): " + sum);  // Output: 55
    }
}

```

Note: If you call .parallel() after certain operations, only the operations after .parallel() will be executed in parallel.

```java
import java.util.*;
import java.util.stream.*;

public class ParallelStreamExample {
    public static void main(String[] args) {
        // Creating a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Sequential stream with parallel applied after filtering
        List<Integer> result = numbers.stream()  // Sequential stream
                                      .filter(n -> n % 2 == 0)  // Sequential filtering
                                      .parallel()  // Convert to parallel stream after filtering
                                      .map(n -> n * n)  // Parallel mapping
                                      .collect(Collectors.toList());  // Collect the result

        System.out.println("Squared even numbers: " + result);  // Output: [4, 16, 36, 64, 100]
    }
}

```