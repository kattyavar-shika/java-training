# What is BlockingQueue

BlockingQueue is an interface in the java.util.concurrent package that extends Queue and provides thread-safe, blocking operations for adding and removing elements.

```java
public interface BlockingQueue<E> extends Queue<E> {
    // Interface methods here
}

```

## Core Features:

- Thread-safe: Designed for use in concurrent applications.
- Blocking behavior:
  - Producers wait if the queue is full. ( This is true, but only for specific method calls like put() (and offer() with timeout). It is not true for all methods in the BlockingQueue interface.)
  - Consumers wait if the queue is empty.

- Ideal for Producer-Consumer problems.


# BlockingQueue APIs – Blocking vs Non-blocking

##  Producer Side

| Method                          | Blocking? | When?                                   |
|---------------------------------|-----------|------------------------------------------|
| `put(E e)`                      | ✅ Yes    | Blocks if queue is full                  |
| `offer(E e)`                    | ❌ No     | Fails immediately if full                |
| `offer(E e, timeout, unit)`     | ⏳ Yes    | Waits up to timeout for space            |
| `add(E e)`                      | ❌ No     | Throws `IllegalStateException` if full   |

---

##  Consumer Side

| Method                          | Blocking? | When?                                     |
|---------------------------------|-----------|--------------------------------------------|
| `take()`                        | ✅ Yes    | Blocks if queue is empty                   |
| `poll()`                        | ❌ No     | Returns `null` if empty                    |
| `poll(timeout, unit)`           | ⏳ Yes    | Waits for up to timeout                    |
| `peek()`                        | ❌ No     | Just views head, returns `null` if empty   |



# ArrayBlockingQueue

ArrayBlockingQueue is a bounded, thread-safe queue backed by an array. It belongs to the java.util.concurrent package and implements the BlockingQueue interface.

- Bounded: You must specify the capacity at the time of creation.
- Thread-safe: It uses internal locks to ensure thread safety.
- FIFO order: Elements are ordered in the order they were inserted (first-in-first-out).
- Blocking behavior: It can block the thread when trying to insert into a full queue or remove from an empty queue.


## Constructor 

```java
ArrayBlockingQueue(int capacity)
ArrayBlockingQueue(int capacity, boolean fair)
ArrayBlockingQueue(int capacity, boolean fair, Collection<? extends E> c)

```

- capacity: Maximum number of elements the queue can hold.
- fair: If true, the queue uses a fair policy for thread access (first-come, first-served).


Example : 

```java
import java.util.concurrent.ArrayBlockingQueue;

public class Example {
    public static void main(String[] args) throws InterruptedException {
        // Create a blocking queue with capacity 3
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        // Producer thread
        new Thread(() -> {
            try {
                queue.put("Item 1");
                queue.put("Item 2");
                queue.put("Item 3");
                // This will block until space is available
                queue.put("Item 4");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Consumer thread
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulate delay
                System.out.println("Taken: " + queue.take());
                System.out.println("Taken: " + queue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}

```

## Use Case: When to Use ArrayBlockingQueue

Use ArrayBlockingQueue when:
- Fixed Capacity Needed:
  - You want to limit the size of the queue (e.g., for memory or resource control).

- Producer-Consumer Scenarios:
  - Multiple producer and consumer threads exchanging messages/tasks.
  - Prevents producer from overwhelming the consumer by blocking when the queue is full.
    
- Thread Communication:
  - Useful for passing data between threads safely and efficiently.



# 1 LinkedBlockingQueue with Capacity (Bounded)

```java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BoundedLinkedBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        // Create a LinkedBlockingQueue with a fixed capacity of 2
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(2);

        queue.put("Item 1");  // success
        queue.put("Item 2");  // success

        // This will block until space is available
        new Thread(() -> {
            try {
                System.out.println("Trying to put Item 3...");
                queue.put("Item 3");  // blocks until a slot frees up
                System.out.println("Item 3 added");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(2000); // Simulate some delay
        System.out.println("Taking an item: " + queue.take()); // Frees up space
    }
}

```


# 2. LinkedBlockingQueue without Capacity (Unbounded)

```java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class UnboundedLinkedBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        // Create an unbounded LinkedBlockingQueue
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        queue.put("Item A");
        queue.put("Item B");
        queue.put("Item C");  // Keeps going — no blocking

        System.out.println("Items in queue: " + queue);
    }
}

```



# What is ConcurrentModificationException

ConcurrentModificationException is a runtime exception that occurs when a collection is modified while iterating over it using an iterator, and that modification is not done through the iterator itself.

It's most common with non-thread-safe collections like ArrayList, HashMap, etc.


## Why does it happen?

Collections like ArrayList, HashMap, etc.,   
fail fast — they detect that the structure has been modified during iteration (outside of the iterator),  
and they throw this exception to avoid unpredictable behavior.



## Example of ConcurrentModificationException:

```java
import java.util.*;

public class ConcurrentModificationExample {

    public static void main(String[] args) {
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");

        // Let's try to remove an element while iterating
        for (String lang : languages) {
            if (lang.equals("Python")) {
                // Modifying the list during iteration
                languages.add(lang); // 💥 This will throw ConcurrentModificationException
               // languages.remove(lang); // 💥 This will throw ConcurrentModificationException java 8, if you try on java 21 you will not get error.
            }
        }
    }
}

```


Use iterator in case of remove. 

```java
 public static void main(String[] args) {

    List<String> languages = new ArrayList<>();
    languages.add("Java");
    languages.add("Python");
    languages.add("C++");

    System.out.println(languages);
    // Using Iterator to safely remove elements during iteration
    Iterator<String> iterator = languages.iterator();
    while (iterator.hasNext()) {
      String lang = iterator.next();
      if (lang.equals("Python")) {
        System.out.println("Removing: " + lang);
        iterator.remove(); // ✅ Safe way to modify list during iteration
      }
    }

    System.out.println(languages);
  }
```



# CopyOnWriteArrayList


CopyOnWriteArrayList is a thread-safe variant of ArrayList from the java.util.concurrent package.  
It works by creating a new copy of the underlying array each time it is modified (add, remove, etc.), ensuring that all iterators will see a consistent and thread-safe view of the list.

**Important:** This collection is optimized for situations where there are more reads than writes (e.g., a scenario where you frequently iterate through the list but only occasionally modify it).


## How does it work?

When an operation like add(), remove(), or set() is called, CopyOnWriteArrayList creates a new copy of the internal array, modifies the new copy, and then replaces the old array. This ensures that reading operations can happen simultaneously without synchronization issues, as they work on the old, unmodified array.


Example of CopyOnWriteArrayList in Action:

Here’s an example where multiple threads can safely iterate over and modify the list concurrently without causing a ConcurrentModificationException:


```java
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {

    public static void main(String[] args) throws InterruptedException {
        
        // Creating a CopyOnWriteArrayList
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        
        // Create a thread that modifies the list
        Thread writerThread = new Thread(() -> {
            try {
                // Simulate some work and then modify the list
                Thread.sleep(1000);
                System.out.println("Writer thread modifying the list...");
                list.add("JavaScript");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Create a thread that iterates over the list
        Thread readerThread = new Thread(() -> {
            for (String lang : list) {
                try {
                    Thread.sleep(500); // Simulate reading work
                    System.out.println("Reading: " + lang);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Start both threads
        writerThread.start();
        readerThread.start();

        // Wait for threads to finish
        writerThread.join();
        readerThread.join();

        // Final list after modification
        System.out.println("Final list: " + list);
    }
}

```

## When to Use CopyOnWriteArrayList?

Use Case 1: Read-heavy applications – When your application mostly reads data from a list and only occasionally modifies it (e.g., a shared configuration list that is often read but rarely changed).

Use Case 2: Iteration with concurrent modifications – If you need to allow concurrent modifications by multiple threads and you want to avoid the complexity of manual synchronization or the possibility of ConcurrentModificationException.



# ConcurrentHashMap

ConcurrentHashMap is part of the java.util.concurrent package, and it's a thread-safe implementation of the Map interface, designed to allow concurrent reads and writes by multiple threads without locking the entire map. This is particularly useful in multi-threaded environments where multiple threads need to access and modify a shared map concurrently.

Unlike HashMap, which isn't thread-safe, ConcurrentHashMap allows for concurrent updates, meaning multiple threads can read from and write to the map without causing data corruption or throwing exceptions like ConcurrentModificationException.


## How does ConcurrentHashMap work internally?

In Java 8 and above, ConcurrentHashMap was optimized further with the introduction of a bucketized structure and locks at the bucket level rather than locking the entire map. This allows for fine-grained concurrency. Each segment in the map is independently locked when writing, ensuring other threads can work on different segments without interfering with each other.

Example:

```java
import java.util.concurrent.*;

public class ConcurrentHashMapExample {

    public static void main(String[] args) throws InterruptedException {

        // Create a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Adding initial values
        map.put("Java", 10);
        map.put("Python", 20);
        map.put("C++", 30);

        // Create a thread that updates the map
        Thread writerThread = new Thread(() -> {
            try {
                // Simulate some work
                Thread.sleep(1000);
                System.out.println("Writer thread modifying the map...");
                map.put("Java", 40); // Update the value for "Java"
                map.put("JavaScript", 50); // Add new key-value pair
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Create a thread that reads the map
        Thread readerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(500); // Simulate some reading work
                    System.out.println("Reading: " + map);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Start both threads
        writerThread.start();
        readerThread.start();

        // Wait for threads to finish
        writerThread.join();
        readerThread.join();

        // Final map after modification
        System.out.println("Final map: " + map);
    }
}

```

# When to Use ConcurrentHashMap:

When you need concurrent read and write operations: If multiple threads are reading and writing to the same map, ConcurrentHashMap is an ideal choice because it provides thread-safety without the overhead of locking the entire map.

In scenarios where performance is crucial: Since ConcurrentHashMap only locks individual buckets during writes (and not the whole map), it can outperform other thread-safe maps (like Hashtable or synchronized HashMap) in high-concurrency situations.

Use cases like caching, resource management, or counters where thread-safe updates are needed.



# Using Non-Thread-Safe Collections with Collections.synchronized*() Methods

## Purpose of Synchronization:

The Collections.synchronizedList(), Collections.synchronizedSet(), and Collections.synchronizedCollection() methods are used to wrap non-thread-safe collections (like ArrayList, HashSet, LinkedList, etc.) and make them thread-safe.

They do this by synchronizing all modification operations (e.g., add(), remove(), clear()) at the method level.

## How to Use:

Simply pass a non-thread-safe collection to one of these methods to create a synchronized version of the collection.

```java
List<String> list = new ArrayList<>();
List<String> synchronizedList = Collections.synchronizedList(list);

```

In this case, synchronizedList will ensure that all modifications to the list (like adding, removing, and updating elements) are thread-safe.


## Synchronization Scope:

The synchronization applies to the modification methods of the collection (e.g., add(), remove(), put(), etc.), ensuring that multiple threads can modify the collection without causing data corruption.

**The synchronization does not apply to iteration.** Iterating through the collection is not inherently thread-safe.


