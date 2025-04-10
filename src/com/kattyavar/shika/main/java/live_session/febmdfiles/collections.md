# Collections Framework

Please refer excalidraw file : collectiondiagram.excalidraw

##  Overview of Collections Framework
The Collections Framework in Java provides a set of interfaces, classes, and algorithms to handle collections of objects.  
Collections are central to Java programming because they allow you to store, manipulate, and access groups of data efficiently.  
The framework is part of the java.util package, and it simplifies the way data is organized and managed.

### Key Components of the Collections Framework:

#### Interfaces

The Collection Framework defines several key interfaces that form the backbone of the entire framework. The main ones are:

- Collection: The root interface for most collection types. It defines basic operations like add(), remove(), contains(), and size().
- List: 
  - Extends Collection and represents an ordered collection (or sequence).  
     Lists allow duplicate elements and provide methods to access elements by index.  
     Example: ArrayList, LinkedList.
- Set
  - Extends Collection and represents a collection of unique elements. It does not allow duplicates. Example: HashSet, TreeSet.
- Queue
  - A collection designed for holding elements that are to be processed in a specific order (typically FIFO: First In, First Out). Example: LinkedList, PriorityQueue.
- Deque
  - Extends Queue and allows elements to be added or removed from both ends (double-ended queue). Example: ArrayDeque.
- Map
  -  Not a direct subclass of Collection, but a part of the Collections Framework. It represents a collection of key-value pairs, where each key is associated with exactly one value. Example: HashMap, TreeMap.


#### Implementations

These are concrete classes that implement the collection interfaces. They define how data is stored and managed. Examples:

- ArrayList (List implementation)
- HashSet (Set implementation)
- HashMap (Map implementation)
- LinkedList (List and Queue implementation)
- PriorityQueue (Queue implementation)

#### Algorithms
The Collections Framework provides a set of standard algorithms to operate on collections. These include sorting, searching, and manipulating data. Examples include:

- Collections.sort(): Sorts a list of elements.
- Collections.reverse(): Reverses the order of elements in a list.
- Collections.shuffle(): Randomly permutes elements in a list.

#### Utility Classes
The Collections and Arrays utility classes provide static methods to work with collections and arrays, such as searching, sorting, and filling. Examples include:

- Collections: Provides methods like sort(), reverse(), max(), and min().
- Arrays: Provides methods like asList(), copyOf(), sort(), etc.

#### Important Features of the Collections Framework:
- **Generics Support**: The collections framework fully supports generics, which allows type-safe collections. For example, you can create a List<String> to hold only strings.
- **Performance:** The framework provides highly optimized implementations for different types of collections, so developers can choose the one that best fits their needs. For example, ArrayList provides fast random access, while LinkedList provides fast insertions and deletions.
- **Thread Safety:** Some collections are thread-safe, while others are not. For example, Vector and Hashtable are synchronized and thread-safe, while ArrayList and HashMap are not. For thread safety, you can use classes like CopyOnWriteArrayList or use the Collections.synchronizedList() method to make an existing collection thread-safe.
- **Null Elements:** Some collections allow null elements (like ArrayList and HashSet), while others do not (like TreeSet and TreeMap).



## Benefits of Using Collections

Using the Collections Framework in Java offers several key benefits that enhance both the productivity of developers and the performance of applications. Here are some of the primary benefits:


### 1. Simplified Data Management

- **Unified API:** The Collections Framework provides a common set of interfaces and classes for working with various types of data structures. This reduces the need to understand or implement complex algorithms for storing and manipulating data.
- **Standardization:** The framework offers standardized methods for tasks like adding, removing, and accessing elements, meaning developers can work with data structures in a consistent way across different applications.

### 2. Reusability

The collections framework contains reusable data structures (like ArrayList, HashSet, HashMap, etc.) that are already optimized and thoroughly tested. Developers can leverage these classes instead of creating their own implementations from scratch, saving time and effort.

### 3. Optimized Performance

- **Efficient Implementations:** The framework includes high-performance implementations for different types of collections. For example, HashMap provides constant-time access and modification, while TreeSet offers efficient sorting and search capabilities.
- **Adaptability:** Developers can choose the best data structure based on their specific performance requirements (e.g., ArrayList for fast access, LinkedList for quick insertions and deletions, or HashSet for fast lookups).

### 4. Type Safety with Generics

- **Generics Support:** The Collections Framework fully supports generics, ensuring type safety at compile time. This means you can create collections that only hold objects of a specific type (e.g., List<String> or Set<Integer>), reducing the risk of runtime errors due to incompatible types.
- **Avoiding Casts:** With generics, there's no need for explicit casting when retrieving elements from a collection, making your code cleaner and less error-prone.

### 5. Thread Safety (For Specific Collections)

- The framework provides thread-safe collections like CopyOnWriteArrayList and ConcurrentHashMap that can be used in multi-threaded environments. These collections handle synchronization internally, helping to prevent concurrency issues.
- Synchronized Wrappers: You can also make any existing collection thread-safe by wrapping it with the synchronized versions available in the Collections utility class (e.g., Collections.synchronizedList()).

### 6. Flexibility and Extensibility

- The interface-based design of the collections framework allows for flexibility and easy extension. If needed, you can create custom collections by implementing the existing interfaces (like List, Set, or Map), which ensures consistency with other collection types.
- The framework’s architecture allows developers to choose or implement specialized data structures without modifying or overriding core functionality.


### 7. Built-in Algorithms

The Collections utility class offers a variety of useful algorithms (sorting, searching, reversing, etc.) that can be directly applied to collections. For example, you can sort a list or shuffle a collection with just a single method call:

```java
Collections.sort(list);      // Sorts the list in ascending order
Collections.shuffle(list);   // Randomly shuffles the elements

```
These built-in algorithms save time and reduce the need to manually implement common operations.


### 8. Scalability

Java’s Collections Framework is designed to handle a wide range of use cases, from small to large collections. Whether you're working with a small set of data or handling millions of elements, you can scale your applications by selecting the appropriate collection type for the task at hand.

Resizable Collections: Collections like ArrayList automatically resize themselves as elements are added, making it easy to handle dynamic data sizes.

### 9. Memory Efficiency

Some collection types are more memory-efficient than others, allowing developers to choose the most appropriate one for the given scenario. For example, HashSet (which uses a hash table) is more memory-efficient for handling large datasets with unique elements, while ArrayList is more efficient when elements need to be accessed by index.

### 10. Improved Code Readability and Maintainability

Using the standard collections reduces the need to write custom data structures, making code easier to read and maintain. Developers familiar with the framework can quickly understand how collections work without needing to dig into the implementation details.

The naming conventions and structure of the framework make it clear what each collection is used for, which enhances the overall readability of the code.

### 11. Rich Set of Data Structures

The framework offers a rich variety of data structures, from lists (for ordered data) to sets (for unique data) to maps (for key-value pairs). It also supports more specialized structures, such as queues, deques, and sorted maps, giving developers many choices to address specific problems.

Advanced Implementations: The framework also provides more advanced structures like TreeSet (which keeps elements in sorted order), PriorityQueue (which orders elements based on their priority), and LinkedHashMap (which maintains insertion order).

### 12. Interoperability

The Collections Framework is designed to be interoperable with other Java APIs and libraries. Collections can be easily converted to arrays using toArray(), and Java’s utility classes like Arrays.asList() make it simple to convert arrays to collections.




# Collection Interface: Basics and Methods

The Collection Interface is the root interface of the Java Collections Framework, and it is part of the java.util package. It is the foundation for most of the collections in Java, defining the basic operations that all collections must support. The Collection interface is extended by more specific collection interfaces like List, Set, and Queue.

## Key Characteristics of the Collection Interface:

- It provides the basic methods for adding, removing, and accessing elements from a collection.
- It is not intended to be implemented directly (although it can be extended).
- It serves as the parent for other more specialized collection interfaces (List, Set, etc.).


## Key Methods of the Collection Interface

The Collection interface defines several methods that apply to all types of collections (lists, sets, queues, etc.). These methods allow you to manipulate the data contained in a collection, whether it’s adding elements, checking for presence, or removing elements.

### 1. Adding Elements

- boolean add(E var1): Adds the specified element to the collection. This method generally returns true if the collection was modified as a result of the addition.

```java
Collection<String> collection = new ArrayList<>();
collection.add("Apple"); // Adds "Apple" to the collection

```

- `boolean addAll(Collection<? extends E> c): Adds all elements from the specified collection to this collection. Returns true if the collection was modified as a result.`

Example:

```java
Collection<String> collection1 = new ArrayList<>();
collection1.add("Apple");
collection1.add("Banana");

Collection<String> collection2 = new ArrayList<>();
collection2.addAll(collection1); // Adds all elements from collection1 to collection2

```

### 2. Removing Elements

- boolean remove(Object o): Removes a single instance of the specified element from the collection. Returns true if the collection contained the specified element.

```java
Collection<String> collection = new ArrayList<>();
collection.add("Apple");
collection.remove("Apple"); // Removes "Apple" from the collection

```

- `boolean removeAll(Collection<?> c): Removes all elements in the specified collection from this collection. Returns true if the collection was modified.`

Example:

```java
Collection<String> collection1 = new ArrayList<>();
collection1.add("Apple");
collection1.add("Banana");

Collection<String> collection2 = new ArrayList<>();
collection2.add("Apple");

collection1.removeAll(collection2); // Removes "Apple" from collection1

```

- boolean clear(): Removes all elements from the collection, leaving it empty. Returns true if the collection was modified.

```java
Collection<String> collection = new ArrayList<>();
collection.add("Apple");
collection.add("Banana");
collection.clear(); // Clears all elements from the collection

```


### 3. Querying the Collection

- int size(): Returns the number of elements in the collection.

```java
Collection<String> collection = new ArrayList<>();
collection.add("Apple");
collection.add("Banana");
System.out.println(collection.size()); // Output: 2

```

- boolean isEmpty(): Checks if the collection is empty (i.e., contains no elements).

```java
Collection<String> collection = new ArrayList<>();
System.out.println(collection.isEmpty()); // Output: true

```

- boolean contains(Object o): Checks if the collection contains the specified element. Returns true if the collection contains the element.

```java
Collection<String> collection = new ArrayList<>();
collection.add("Apple");
System.out.println(collection.contains("Apple")); // Output: true

```

- `boolean containsAll(Collection<?> c): Checks if the collection contains all elements from the specified collection.`

```java
Collection<String> collection1 = new ArrayList<>();
collection1.add("Apple");
collection1.add("Banana");

Collection<String> collection2 = new ArrayList<>();
collection2.add("Apple");

System.out.println(collection1.containsAll(collection2)); // Output: true

```

### 4. Iterating Over Elements

- `Iterator<E> iterator(): Returns an iterator over the elements in the collection, which can be used to loop through the collection.`

Example

```java
Collection<String> collection = new ArrayList<>();
collection.add("Apple");
collection.add("Banana");

Iterator<String> iterator = collection.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}

```

- `Object[] toArray(): Converts the collection to an array of Object type.`

```java
Collection<String> collection = new ArrayList<>();
collection.add("Apple");
collection.add("Banana");

Object[] array = collection.toArray();
System.out.println(Arrays.toString(array)); // Output: [Apple, Banana]

```

- `<T> T[] toArray(T[] a): Converts the collection to an array of the specified type.`

Example:

```java
Collection<String> collection = new ArrayList<>();
collection.add("Apple");
collection.add("Banana");

String[] array = collection.toArray(new String[0]);
System.out.println(Arrays.toString(array)); // Output: [Apple, Banana]

```


### 5. Bulk Operations

- `boolean removeIf(Predicate<? super E> filter): Removes all elements that satisfy the given condition (specified by a Predicate). Returns true if any elements were removed.`

Example:

```java
Collection<String> collection = new ArrayList<>();
collection.add("Apple");
collection.add("Banana");

collection.removeIf(s -> s.startsWith("B")); // Removes "Banana"

```


## List Interface in Java: Ordered Collections

The List interface in Java is a part of the java.util package and extends the Collection interface. It defines an ordered collection that allows duplicate elements. The primary characteristic of a List is that it maintains the order of elements, meaning the elements are indexed, and you can access them by their position in the list.


### Key Characteristics of the List Interface:
- Ordered: Elements in a List are stored in the order they were added, and this order is maintained.
- Indexed Access: You can access elements by their index (starting from 0). This makes List suitable for use cases where random access to elements is needed.
- Allow Duplicates: Unlike Set, List allows duplicate elements.
- Null Elements: Most List implementations allow null elements, though some may have limitations.
- Resizable: Lists can dynamically grow in size, as elements are added.


### Common Methods of the List Interface:

Besides the methods inherited from the Collection interface, List provides several methods for working with ordered collections:

- void add(int index, E element): Inserts the specified element at the specified position in the list, shifting elements to the right (if necessary).

- E get(int index): Returns the element at the specified position in the list.

- E set(int index, E element): Replaces the element at the specified position with the specified element.

- E remove(int index): Removes the element at the specified position, shifting subsequent elements to the left.

- int indexOf(Object o): Returns the index of the first occurrence of the specified element in the list, or -1 if the element is not found.

- int lastIndexOf(Object o): Returns the index of the last occurrence of the specified element, or -1 if the element is not found.

- `List<E> subList(int fromIndex, int toIndex): Returns a view of the portion of the list between the specified indices.`

- boolean contains(Object o): Returns true if the list contains the specified element.

- `ListIterator<E> listIterator(): Returns a list iterator over the elements in the list, starting from the first element.`


### Common Implementations of the List Interface

The List interface has several commonly used implementations in Java, each with different performance characteristics. The two most frequently used implementations are ArrayList and LinkedList.


#### 1. ArrayList

ArrayList is one of the most commonly used implementations of the List interface. It is backed by an array and allows fast random access to elements. The size of the ArrayList automatically increases as elements are added.


##### Key Characteristics of ArrayList:
- Backed by an Array: Internally uses a dynamic array to store elements.
- Fast Access: Provides constant-time (O(1)) access to elements via their index.
- Slow Insertions/Deletions (in the middle): Inserting or deleting elements at the middle or beginning of the list requires shifting elements, making it slower (with a time complexity of O(n) for these operations).
- Resizable: Automatically resizes when elements exceed the capacity, but resizing itself can be an expensive operation.
- Performance: Best suited for applications where random access to elements is frequent, but insertions and deletions are relatively rare.

Example Usage of ArrayList:

```java
import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Accessing elements by index
        System.out.println("Element at index 1: " + list.get(1)); // Output: Banana

        // Removing an element by index
        list.remove(1); // Removes "Banana"

        // Iterating through the list
        for (String item : list) {
            System.out.println(item); // Output: Apple, Cherry
        }
    }
}

```

Performance Considerations:
- Access: O(1) for retrieving an element at a specific index.
- Insertions: O(n) in the worst case (inserting in the middle), but O(1) for adding to the end (if there is space).
- Resizing: When the array is full and a new element is added, the array needs to be resized, which can be an expensive operation (O(n)).



#### 2. LinkedList

LinkedList is another implementation of the List interface, but instead of using an array, it uses a doubly linked list. It provides fast insertions and deletions, especially at the beginning and middle of the list, but slower access time compared to ArrayList.

##### Key Characteristics of LinkedList:

- Backed by a Doubly Linked List: Each element in the list is stored in a node that holds a reference to both the previous and next element.
- Fast Insertions/Deletions: Inserting or deleting elements is efficient (O(1)) when done at the beginning or the end of the list, and relatively efficient for operations in the middle if you have a reference to the node.
- Slow Access: Accessing an element by index is slower than ArrayList (O(n)), as it may require traversing the list from the beginning (or end) to the required index.
- More Memory Usage: Each element needs to store two additional references (previous and next), so LinkedList generally uses more memory than ArrayList.

Example

```java
import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Accessing elements by index
        System.out.println("Element at index 1: " + list.get(1)); // Output: Banana

        // Removing an element by index
        list.remove(1); // Removes "Banana"

        // Iterating through the list
        for (String item : list) {
            System.out.println(item); // Output: Apple, Cherry
        }
    }
}

```

Performance Considerations:

- Access: O(n) for retrieving an element at a specific index, as it needs to traverse the list.
- Insertions: O(1) for inserting elements at the beginning or end of the list, but O(n) in the worst case if you need to traverse to the correct position in the list.
- Memory Usage: Requires more memory due to storing additional pointers to the previous and next nodes.


# Comparison Between ArrayList and LinkedList

| Feature                   | ArrayList                          | LinkedList                        |
|---------------------------|------------------------------------|-----------------------------------|
| **Backing Data Structure** | Dynamic Array                      | Doubly Linked List                |
| **Access Time**            | Fast (O(1)) for index-based access | Slow (O(n))                       |
| **Insertions/Deletions**   | Slow (O(n)) for middle, Fast for end| Fast (O(1)) for head/tail, slow for middle |
| **Memory Usage**           | Efficient (no extra references)    | Higher (needs extra pointers)     |
| **Resizing**               | Resizes when capacity is exceeded, slow | No resizing needed, but more memory usage |
| **Best Use Case**          | Frequent access, infrequent insertion/deletion | Frequent insertions/deletions, less frequent access |


Summary: 
- ArrayList is ideal when you need fast access to elements by index and are doing fewer insertions and deletions.
- LinkedList is better suited when your application requires frequent insertions and deletions, particularly at the beginning or middle of the list, but does not require frequent random access to elements by index.

Note: Choosing the right implementation of the List interface depends on your specific use case and the operations you need to optimize for.



## Set Interface in Java: Unordered Collections

The Set interface in Java, part of the java.util package, represents a collection of unique elements. It is a part of the Java Collections Framework and extends the Collection interface. A key characteristic of a Set is that it does not allow duplicates, meaning each element in the set is guaranteed to be unique.

Additionally, Sets are unordered, meaning the order in which elements are stored is not guaranteed (with the exception of certain implementations like LinkedHashSet and TreeSet).

### Key Characteristics of the Set Interface:

- **No Duplicates:** A Set does not allow duplicate elements. If you try to add a duplicate element, the collection remains unchanged.
- **Unordered:** Unlike List, the elements in a Set do not have a defined order.
- **Faster Lookups**: Because of the underlying data structures (hash tables or trees), Sets typically offer faster lookups, insertions, and deletions than Lists (especially for HashSet and TreeSet).


### Common Methods of the Set Interface:

In addition to methods inherited from the Collection interface, the Set interface provides some specialized methods:

- boolean add(E e): Adds the specified element to the set if it is not already present. Returns false if the element was already in the set.

- boolean remove(Object o): Removes the specified element from the set if it is present. Returns true if the element was removed.

- boolean contains(Object o): Returns true if the set contains the specified element.

- boolean isEmpty(): Checks if the set is empty.

- int size(): Returns the number of elements in the set.

- `Iterator<E> iterator(): Returns an iterator to iterate over the set.`

- void clear(): Removes all elements from the set.

- boolean equals(Object o): Checks if the set is equal to another set.


### Common Implementations of the Set Interface

The Set interface has several important implementations, each offering different features and performance characteristics. The three most commonly used implementations are HashSet, LinkedHashSet, and TreeSet.

#### 1. HashSet

HashSet is the most commonly used implementation of the Set interface. It is backed by a hash table (technically, a HashMap with the keys being the elements of the set). It provides constant-time (O(1)) performance for basic operations such as add(), remove(), and contains(), assuming the hash function disperses elements properly.

##### Key Characteristics of HashSet:

- Unordered: Elements in a HashSet are not stored in any particular order.
- No Duplicates: Ensures that no duplicate elements can be stored.
- Efficient: Offers fast performance for basic operations like adding, removing, and checking for elements.
- Null Elements: Allows one null element.

Example:

```java
import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        // Adding elements
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");

        // Adding a duplicate (this will not be added)
        set.add("Apple");

        // Iterating through the set
        for (String item : set) {
            System.out.println(item);  // Output: Apple, Banana, Cherry (order is not guaranteed)
        }

        // Checking if an element is present
        System.out.println(set.contains("Banana")); // Output: true

        // Removing an element
        set.remove("Banana");

        // Checking the size
        System.out.println(set.size()); // Output: 2
    }
}

```

Performance Considerations:

- Access: O(1) for adding, removing, and checking elements (assuming a good hash function).
- Memory: More memory-efficient than LinkedHashSet and TreeSet because it doesn't store additional information like ordering or sorting.


#### 2. LinkedHashSet

LinkedHashSet is a subclass of HashSet, but with an added feature: it maintains the insertion order of elements. Internally, it uses a combination of a hash table and a linked list. As a result, elements are stored in the order they were inserted, while still benefiting from the fast lookup times of a HashSet.

Key Characteristics of LinkedHashSet:

- Ordered: Elements are stored in the order they were added, which is different from HashSet, where the order is unpredictable.
- Faster Iteration: Because the elements maintain insertion order, iterating over a LinkedHashSet will return the elements in the order they were inserted.
- No Duplicates: Like HashSet, it does not allow duplicate elements.
- Null Elements: Allows one null element.

Example:

```java
import java.util.*;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();

        // Adding elements
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");

        // Adding a duplicate (this will not be added)
        set.add("Apple");

        // Iterating through the set
        for (String item : set) {
            System.out.println(item);  // Output: Apple, Banana, Cherry (order is preserved)
        }

        // Checking if an element is present
        System.out.println(set.contains("Banana")); // Output: true
    }
}

```


Performance Considerations:

- Access: O(1) for adding, removing, and checking elements.
- Memory: Uses more memory than HashSet due to the need for maintaining the linked list of elements for insertion order.
- Insertion Order: The order in which elements are iterated over is guaranteed to be the same as the order of insertion.


#### 3. TreeSet

TreeSet is an implementation of the Set interface that is backed by a red-black tree, a type of self-balancing binary search tree. It provides logarithmic-time (O(log n)) performance for basic operations like add(), remove(), and contains(). It also guarantees that the elements will be sorted in natural order (or by a custom comparator if provided).


#### Key Characteristics of TreeSet:

- Sorted: Elements are stored in a sorted order. By default, this order is the natural order of the elements (i.e., the elements must be comparable, such as Integer or String), but a custom sorting order can be provided via a Comparator.
- No Duplicates: Like other Set implementations, duplicates are not allowed.
- Slower Operations: While it guarantees sorted order, it performs operations like adding and removing in O(log n) time, which is slower than HashSet and LinkedHashSet.
- No Null Elements: Unlike HashSet and LinkedHashSet, TreeSet does not allow null elements, because null is not comparable.

Example:

```java
import java.util.*;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        // Adding elements
        set.add(5);
        set.add(1);
        set.add(3);
        set.add(4);

        // Adding a duplicate (this will not be added)
        set.add(3);

        // Iterating through the set
        for (Integer item : set) {
            System.out.println(item);  // Output: 1, 3, 4, 5 (sorted order)
        }

        // Checking if an element is present
        System.out.println(set.contains(3)); // Output: true
    }
}

```

Performance Considerations:

- Access: O(log n) for adding, removing, and checking elements.
- Sorted Order: Elements are always sorted in their natural order or the order determined by the Comparator.
- Memory: Uses more memory than HashSet and LinkedHashSet due to the overhead of maintaining the tree structure.


#### Comparison Between HashSet, LinkedHashSet, and TreeSet

| Feature                   | HashSet                           | LinkedHashSet                    | TreeSet                           |
|---------------------------|-----------------------------------|-----------------------------------|-----------------------------------|
| **Order**                 | No specific order (unordered)    | Maintains insertion order        | Sorted order (natural or custom order) |
| **Duplicates**            | No duplicates                     | No duplicates                    | No duplicates                     |
| **Null Elements**         | Allows one null element           | Allows one null element          | Does not allow null elements      |
| **Performance (Insert)**  | O(1)                              | O(1)                              | O(log n)                          |
| **Performance (Access)**  | O(1)                              | O(1)                              | O(log n)                          |
| **Memory**                | Most memory-efficient             | More memory usage due to linked list | More memory usage due to tree structure |
| **Best for**              | Fast lookups and insertions with no need for order | Maintaining insertion order and fast lookups | Sorted order or range-based queries |


Summary:

- HashSet is the most commonly used implementation of Set due to its fast performance for adding, removing, and checking elements, but it does not guarantee any order of the elements.
- LinkedHashSet maintains the insertion order of elements while providing the same fast performance as HashSet, making it suitable when the order in which elements were added matters.
- TreeSet is the best choice when you need elements to be sorted in a specific order (either natural or custom), but it comes with a tradeoff in performance (O(log n)) and does not allow null elements.

Note: Choosing the right Set implementation depends on your specific requirements regarding performance, ordering, and handling of duplicates.


# Queue Interface in Java: Queue Operations and Common Implementations

The Queue interface in Java is a part of the java.util package and represents a collection designed for holding elements prior to processing. Queues are typically used in scenarios where elements are processed in a specific order, usually in a FIFO (First-In-First-Out) manner, though other types of order can also be implemented.

The Queue interface extends the Collection interface, and it defines additional methods specific to queue operations.

## Key Characteristics of the Queue Interface:

- FIFO Order: In a typical queue, the first element added is the first to be removed (First-In-First-Out).
- Enqueue/Dequeue: Queue operations revolve around adding (enqueue) and removing (dequeue) elements in a particular order.
- Supports Blocking Operations: Some implementations (such as those used in multi-threaded environments) support blocking operations like waiting for an element to become available.
- Priority Queues: While the standard queue follows FIFO, priority queues allow elements to be dequeued based on priority rather than the order they were added.

## Common Methods in the Queue Interface:

In addition to the methods inherited from the Collection interface, the Queue interface provides specialized methods to manage the queue:


- boolean offer(E e): Adds the specified element to the queue if possible. Returns true if the element was successfully added, otherwise returns false (e.g., if the queue is full).
- E poll(): Retrieves and removes the head of the queue, or returns null if the queue is empty.
- E remove(): Removes and returns the head of the queue. Throws an exception **(NoSuchElementException)** if the queue is empty.
- E peek(): Retrieves the head of the queue without removing it. Returns null if the queue is empty.
- E element(): Retrieves the head of the queue without removing it. Throws an exception (NoSuchElementException) if the queue is empty.
- boolean isEmpty(): Returns true if the queue is empty.
- int size(): Returns the number of elements in the queue.

## Common Implementations of the Queue Interface

There are several implementations of the Queue interface in Java, each suited to different use cases. The two most commonly used implementations are LinkedList and PriorityQueue.


### 1. LinkedList

LinkedList is a commonly used implementation of the Queue interface. It is a doubly linked list that supports efficient additions and removals at both ends of the list. Because LinkedList implements the Queue interface, it supports all the necessary queue operations such as enqueue and dequeue.

#### Key Characteristics of LinkedList:
- FIFO Order: Elements are processed in the order they were added (FIFO).
- Efficient: Offers constant time complexity (O(1)) for adding and removing elements from the front and rear.
- Doubly Linked List: It allows for efficient insertions and removals at both ends, making it ideal for both queues and deque-like use cases.
- Null Elements: Allows null elements to be added to the queue.

Example Usage of LinkedList as a Queue:

```java
import java.util.*;

public class LinkedListQueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // Adding elements (Enqueue)
        queue.offer("Apple");
        queue.offer("Banana");
        queue.offer("Cherry");

        // Peek at the first element (no removal)
        System.out.println("Peek: " + queue.peek()); // Output: Apple

        // Removing elements (Dequeue)
        System.out.println("Removed: " + queue.poll()); // Output: Apple

        // Iterating over the queue
        System.out.println("Queue after dequeue:");
        for (String item : queue) {
            System.out.println(item);  // Output: Banana, Cherry
        }

        // Checking the size of the queue
        System.out.println("Size: " + queue.size());  // Output: 2
    }
}

```

Performance Considerations:

- Enqueue/Dequeue: O(1) for adding and removing elements from both ends.
- Accessing/Iterating: Iteration through the LinkedList has a time complexity of O(n).


### 2. PriorityQueue

PriorityQueue is a specialized implementation of the Queue interface that stores elements in a priority order. Instead of following the FIFO order, PriorityQueue allows elements to be dequeued based on their priority, which is determined by either their natural ordering (for comparable elements) or by a Comparator provided at the time of queue creation.

#### Key Characteristics of PriorityQueue:

- Priority Order: Elements are ordered according to their priority, with the element having the highest priority being removed first.
- Natural Ordering or Comparator: By default, PriorityQueue uses the natural ordering of elements (i.e., elements must implement the Comparable interface). Alternatively, a custom Comparator can be provided to define the priority order.
- Not FIFO: Unlike standard queues, PriorityQueue does not follow the FIFO principle. The order of elements is based on their priority (lowest or highest, depending on the ordering).
- No Capacity Limit: A PriorityQueue does not have a fixed capacity and grows as needed.


Example Usage of PriorityQueue:

```java
import java.util.*;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Creating a PriorityQueue that orders elements in natural ascending order
        Queue<Integer> queue = new PriorityQueue<>();

        // Adding elements (Enqueue)
        queue.offer(10);
        queue.offer(20);
        queue.offer(5);

        // Peeking at the first element (highest priority)
        System.out.println("Peek: " + queue.peek()); // Output: 5 (smallest element)

        // Removing elements (Dequeue)
        System.out.println("Removed: " + queue.poll()); // Output: 5 (smallest element)

        // Iterating over the queue
        System.out.println("Queue after dequeue:");
        for (Integer item : queue) {
            System.out.println(item); // Output: 10, 20
        }

        // Checking the size of the queue
        System.out.println("Size: " + queue.size());  // Output: 2
    }
}

```


Performance Considerations:

- Enqueue/Dequeue: The time complexity for adding or removing elements is O(log n) due to the underlying heap structure that is used to maintain the priority order.
- Access: Peeking (retrieving the head element) takes constant time, O(1).
- Memory: Uses more memory than a LinkedList due to the need for maintaining the heap structure.

#### Comparison Between LinkedList and PriorityQueue

| Feature                 | LinkedList (FIFO)                  | PriorityQueue (Priority Order)    |
|-------------------------|------------------------------------|-----------------------------------|
| **Order of Elements**    | FIFO (First-In-First-Out)          | Order determined by priority (natural or custom) |
| **Enqueue Operation**    | O(1) for adding at the end         | O(log n) for adding elements      |
| **Dequeue Operation**    | O(1) for removing from the front   | O(log n) for removing the highest priority element |
| **Peek Operation**       | O(1)                               | O(1) (returns the element with highest priority) |
| **Null Elements**        | Allows null elements               | Does not allow null elements      |
| **Best for**             | Use when order of processing matters (FIFO) | Use when processing needs to follow a priority order (e.g., scheduling tasks) |


Summary

- LinkedList as a Queue: Ideal when you need a simple, efficient FIFO queue with fast enqueue and dequeue operations. It is best suited for general-purpose queue usage where the order of processing is based on arrival time (FIFO).
- PriorityQueue: Best suited when elements need to be processed based on priority rather than the order they were added. It's often used in scheduling systems, task management, and scenarios where elements with higher priority need to be dequeued before those with lower priority.

Note: Choosing between LinkedList and PriorityQueue depends on whether you need a strict FIFO order or if you need elements to be processed according to some custom priority order.



## Deque Interface in Java: Double-Ended Queue Operations and Common Implementations

The Deque (pronounced "deck") interface in Java, part of the java.util package, represents a double-ended queue. It extends the Queue interface and provides more flexibility by allowing elements to be added or removed from both ends (front and rear) of the queue. This makes the Deque ideal for implementing queues, stacks, and other data structures that require efficient access to both ends.

### Key Characteristics of the Deque Interface:
- Double-Ended Queue: Unlike the standard Queue interface (which typically allows operations only at the front), Deque supports both FIFO (First-In-First-Out) and LIFO (Last-In-First-Out) behaviors.
- Supports Stack-like and Queue-like Operations: The Deque interface can be used both as a queue (FIFO) or as a stack (LIFO) by performing operations at either end of the deque.
- Efficient Operations: It allows for fast insertion and removal of elements from both the front and the rear of the deque.


### Common Methods of the Deque Interface:

The Deque interface includes methods from both the Queue interface and additional methods specific to double-ended queues. Here are the most important ones:

From the Queue Interface (inherited):
- boolean offer(E e): Adds the element to the end of the deque (equivalent to enqueue in a standard queue).
- E poll(): Retrieves and removes the element from the front of the deque (FIFO).
- E peek(): Retrieves the front element without removing it.

Additional Methods for Deque:
- void addFirst(E e): Adds the element at the front of the deque.
- void addLast(E e): Adds the element at the end of the deque.
- E removeFirst(): Removes and returns the element from the front of the deque.
- E removeLast(): Removes and returns the element from the end of the deque.
- E getFirst(): Retrieves the first element without removing it.
- E getLast(): Retrieves the last element without removing it.
- boolean offerFirst(E e): Adds the element to the front of the deque (non-blocking).
- boolean offerLast(E e): Adds the element to the end of the deque (non-blocking).
- E pollFirst(): Retrieves and removes the element from the front of the deque (returns null if the deque is empty).
- E pollLast(): Retrieves and removes the element from the end of the deque (returns null if the deque is empty).

### Common Implementations of the Deque Interface

Java provides two main implementations of the Deque interface: ArrayDeque and LinkedList.

#### 1. ArrayDeque

ArrayDeque is an implementation of the Deque interface backed by a dynamic array. It provides efficient operations for adding and removing elements from both ends of the deque. It is often preferred over LinkedList for its better performance in terms of memory usage and faster operations, especially in cases where frequent additions and removals from both ends are required.

##### Key Characteristics of ArrayDeque:

- Resizable Array: It uses an array to store elements, which means the size of the deque can grow or shrink dynamically as needed.
- Efficient Operations: ArrayDeque provides constant time O(1) operations for adding and removing elements at both ends.
- No Capacity Limit: Unlike ArrayList, the ArrayDeque grows dynamically as needed. However, unlike LinkedList, it doesn't allow access to elements in the middle of the deque, which can make some operations slower.
- Not Thread-Safe: It is not thread-safe, so synchronization is required if used in a multi-threaded environment.
- No null Elements: ArrayDeque does not allow null elements to be added.

Example:

```java
import java.util.*;

public class ArrayDequeExample {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        // Adding elements to the deque
        deque.addFirst("Apple");   // Adds at the front
        deque.addLast("Banana");   // Adds at the end
        deque.addFirst("Cherry");  // Adds at the front

        // Display the deque
        System.out.println("Deque: " + deque);  // Output: [Cherry, Apple, Banana]

        // Removing elements from the deque
        System.out.println("Removed first: " + deque.removeFirst());  // Output: Cherry
        System.out.println("Removed last: " + deque.removeLast());    // Output: Banana

        // Peeking at the front and rear
        System.out.println("First element: " + deque.getFirst());  // Output: Apple
        System.out.println("Last element: " + deque.getLast());    // Output: Apple

        // Size of the deque
        System.out.println("Size: " + deque.size());  // Output: 1
    }
}

```

Performance Considerations:

- Insertion and Removal: O(1) for both ends (adding or removing from the front or the end).
- Accessing: Accessing elements in the middle is not efficient (O(n)), as ArrayDeque does not allow direct access by index.
- Memory: More memory-efficient than LinkedList because it uses a dynamic array.


#### 2. LinkedList (Deque Implementation)

LinkedList also implements the Deque interface, and it provides the same functionality but is backed by a doubly linked list. In contrast to ArrayDeque, LinkedList provides better performance when performing operations on elements in the middle of the list. However, it uses more memory due to the need for storing extra pointers (for the previous and next elements) in each node.


##### Key Characteristics of LinkedList:

- Doubly Linked List: Elements are stored in nodes, and each node has pointers to both the next and previous nodes.
- Efficient Insertion/Deletion: Provides O(1) insertion and removal operations at both ends (front and rear).
- Access: Direct access to an element (by index) is slower (O(n)), but adding/removing elements is efficient at both ends.
- Memory Usage: Uses more memory than ArrayDeque because each node stores additional pointers.

Example:
```java
import java.util.*;

public class LinkedListDequeExample {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        // Adding elements to the deque
        deque.addFirst("Apple");
        deque.addLast("Banana");
        deque.addFirst("Cherry");

        // Display the deque
        System.out.println("Deque: " + deque);  // Output: [Cherry, Apple, Banana]

        // Removing elements from the deque
        System.out.println("Removed first: " + deque.removeFirst());  // Output: Cherry
        System.out.println("Removed last: " + deque.removeLast());    // Output: Banana

        // Peeking at the front and rear
        System.out.println("First element: " + deque.getFirst());  // Output: Apple
        System.out.println("Last element: " + deque.getLast());    // Output: Apple

        // Size of the deque
        System.out.println("Size: " + deque.size());  // Output: 1
    }
}

```

Performance Considerations:

- Insertion and Removal: O(1) for adding/removing elements at both ends.
- Access: Slower access for specific elements (O(n)), but it excels when elements are added/removed at the ends.
- Memory: Uses more memory than ArrayDeque because each element is a node with additional pointers.


#### Comparison Between ArrayDeque and LinkedList for Deque Operations

| Feature                  | ArrayDeque                        | LinkedList                       |
|--------------------------|-----------------------------------|----------------------------------|
| **Memory Usage**          | More memory efficient             | Uses more memory due to node pointers |
| **Insertion/Removal (Front/End)** | O(1)                           | O(1)                             |
| **Access Time**           | O(n) for accessing middle elements | O(n) for accessing middle elements |
| **Thread-Safety**         | Not thread-safe                   | Not thread-safe                  |
| **Null Elements**         | Does not allow null elements      | Does not allow null elements     |
| **Best For**              | High-performance, resizable queue | When you need flexible, dynamic list-based operations |
| **Preferred Use Case**    | When memory efficiency and speed are critical | When you need flexibility with frequent inserts/removals from both ends |


Summary
- ArrayDeque is the most efficient and commonly used implementation of the Deque interface, especially when you need a high-performance queue with dynamic resizing. It is best for scenarios where elements need to be added/removed frequently from both ends.
- LinkedList is useful when you need to implement a deque using a doubly linked list. It offers similar functionality to ArrayDeque, but its memory usage is higher due to the need to store pointers for each node. It is better suited for scenarios where flexibility and frequent insertions/deletions in the middle are required.

Note: Choose ArrayDeque for a more memory-efficient and faster implementation of a deque when you only need operations at the ends of the deque. Use LinkedList if you need a more flexible data structure that also supports other types of list operations.


# Map Interface in Java: Key-Value Pairs and Common Implementations

The Map interface in Java represents a collection of key-value pairs, where each key is unique, and each key maps to exactly one value. It is part of the java.util package and is one of the most important interfaces in Java for working with collections.

Unlike other collection interfaces like List and Set, the Map interface **does not extend the Collection interface** because it does not represent a collection of individual elements; instead, it represents a collection of key-value pairs.


## Key Characteristics of the Map Interface:

- Key-Value Pairs: Each entry in a Map consists of a unique key and a corresponding value.
- Uniqueness of Keys: The keys in a Map must be unique. However, the values can be duplicated.
- Efficient Lookup: Map provides an efficient way to look up values based on keys. The time complexity for lookup and insertion is typically O(1) for most implementations.
- No Ordering Guarantee: Some Map implementations provide ordering based on the insertion order or the natural order of keys, while others do not guarantee any specific ordering.


## Common Methods in the Map Interface

Here are the essential methods provided by the Map interface:

- V put(K key, V value): Adds the specified key-value pair to the map. If the key already exists, the old value is replaced by the new value.

- V get(Object key): Retrieves the value associated with the specified key. Returns null if the key does not exist in the map.

- boolean containsKey(Object key): Checks if the map contains a mapping for the specified key.

- boolean containsValue(Object value): Checks if the map contains one or more keys mapping to the specified value.

- V remove(Object key): Removes the mapping for the specified key from the map. Returns the value associated with the key, or null if the key was not present.

- void clear(): Removes all the entries from the map.

- int size(): Returns the number of key-value pairs in the map.

- boolean isEmpty(): Returns true if the map is empty.

- `Set<K> keySet(): Returns a Set view of the keys contained in the map.`

- `Collection<V> values(): Returns a Collection view of the values contained in the map.`

- `Set<Map.Entry<K, V>> entrySet(): Returns a Set view of the key-value mappings (entries) contained in the map.`


## Common Implementations of the Map Interface

Java provides several implementations of the Map interface, each with different characteristics. The most commonly used implementations are HashMap, LinkedHashMap, TreeMap, and WeakHashMap.

### 1. HashMap

HashMap is one of the most commonly used implementations of the Map interface. It is based on a hash table, and it provides an efficient way to store and retrieve key-value pairs.

Key Characteristics of HashMap:

- No Order Guarantee: HashMap does not guarantee any specific order of key-value pairs. The order of elements may change when the map is modified.
- Null Keys and Values: HashMap allows one null key and multiple null values.
  - One null key: A HashMap allows exactly one null key.
  - Multiple null values: A HashMap allows multiple null values for different keys. However, for the same key, you can only have one value, even if that value is null.
- Efficiency: Provides constant-time O(1) time complexity for most operations such as put, get, and remove, assuming a good hash function and minimal collisions.
- Thread-Safety: HashMap is not thread-safe. If multiple threads access the map concurrently and at least one of the threads modifies the map, external synchronization is required.

```java
import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // Adding key-value pairs to the map
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);

        // Retrieving a value by key
        System.out.println("Apple: " + map.get("Apple")); // Output: 1

        // Checking if a key exists
        System.out.println("Contains 'Banana'? " + map.containsKey("Banana")); // Output: true

        // Removing a key-value pair
        map.remove("Cherry");

        // Displaying all key-value pairs
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

```

Performance Considerations:

- Insertion/Search/Deletion: O(1) on average (assuming a good hash function).
- Memory: The hash table uses more memory than other implementations, as it must store both the keys and values as well as their corresponding hash codes.


### 2. LinkedHashMap

LinkedHashMap is a subclass of HashMap that maintains the insertion order of elements, meaning the order in which key-value pairs are added to the map is preserved.

#### Key Characteristics of LinkedHashMap:
- Maintains Insertion Order: LinkedHashMap maintains the order in which keys are inserted. This makes it useful when you need a predictable order of key-value pairs.
- Null Keys and Values: Like HashMap, LinkedHashMap allows one null key and multiple null values.
- Efficiency: Similar to HashMap, LinkedHashMap provides constant-time performance for most operations (O(1) for put, get, and remove).

```java
import java.util.*;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();

        // Adding key-value pairs
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);

        // Iterating over key-value pairs (in insertion order)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

```

Performance Considerations:

- Insertion/Search/Deletion: O(1) on average.
- Memory: Slightly more memory overhead than HashMap due to the linked list that maintains the order of insertion.


### 3. TreeMap

TreeMap is a Map implementation that stores keys in sorted order according to their natural ordering or according to a custom comparator provided at the time of map creation. It is based on a Red-Black tree.

Key Characteristics of TreeMap:
- Sorted Order: Keys are stored in sorted order (either natural order or based on a custom comparator). This makes it ideal for applications that require keys to be sorted.
- Null Keys: TreeMap does not allow null keys (throws a NullPointerException if attempted).
- Efficiency: Provides O(log n) time complexity for basic operations such as put, get, and remove because of the underlying Red-Black tree structure.

```java
import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();

        // Adding key-value pairs
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);

        // Iterating over key-value pairs (in sorted order)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

```

another example 

```java

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Map<Temp, Integer> map = new TreeMap<>(Comparator.comparing(a -> a.name));
    //Map<Temp, Integer> map = new TreeMap<>((a,b ) -> a.name.compareTo(b.name));

    // Adding key-value pairs
    map.put(new Temp("Apple"), 1);
    map.put(new Temp("Banana"), 2);
    map.put(new Temp("Cherry"), 3);

    // Iterating over key-value pairs (in sorted order)
    for (Map.Entry<Temp, Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }


  }
}

class Temp {
  String name;

  public Temp(String name) {
    this.name = name;
  }
}

```

Performance Considerations:
- Insertion/Search/Deletion: O(log n) due to the underlying tree structure.
- Memory: Uses more memory than HashMap and LinkedHashMap due to the tree structure.


### 4. WeakHashMap

WeakHashMap is a specialized implementation of the Map interface that uses weak references for its keys. This means that if a key in a WeakHashMap is no longer referenced outside the map, it will be automatically removed from the map during garbage collection.

#### Key Characteristics of WeakHashMap:

- Weak References for Keys: Keys are stored using weak references, meaning if there are no strong references to a key, it will be eligible for garbage collection, and the entry will be removed from the map.
- Null Keys and Values: Allows null values but does not allow null keys.
- Use Case: Suitable for caches and memory-sensitive applications, where entries should be automatically removed when no longer in use.

```java
import java.util.*;

public class WeakHashMapExample {
  public static void main(String[] args) throws InterruptedException {
    // Create a WeakHashMap
    Map<Object, Integer> map = new WeakHashMap<>();

    // Adding key-value pairs
    map.put("Apple", 1);
    map.put("Banana", 2);

    // Simulating the behavior of weak references by nullifying a key reference
    Object key = new String("Cherry");  // This creates a non-interned string
    map.put(key, 3);

    System.out.println("Before marking reference as null");
    System.out.println(map);

    // Nullifying the strong reference to the key
    key = null;  // Now, the "Cherry" key is eligible for garbage collection

    // Suggesting the garbage collector to run
    System.gc();  // Hint to JVM to run GC
    Thread.sleep(3000);  // Sleep to give GC time

    // Print the map after GC
    System.out.println("After marking reference as null");
    System.out.println(map);  // Cherry key should be removed if GC runs


  }
}

```


Performance Considerations:

- Insertion/Search/Deletion: Similar to HashMap, but entries are subject to removal by garbage collection.
- Memory: Suitable for memory-sensitive applications, as it automatically clears unused entries.

#### Comparison Between the Map Implementations

| Feature                 | HashMap                           | LinkedHashMap                    | TreeMap                           | WeakHashMap                       |
|-------------------------|-----------------------------------|-----------------------------------|-----------------------------------|-----------------------------------|
| **Ordering**             | No ordering                       | Insertion order                  | Sorted order                      | No ordering                       |
| **Null Keys/Values**     | One null key, multiple null values| One null key, multiple null values| No null keys                      | One null value, no null keys      |
| **Performance**          | O(1) for most operations          | O(1) for most operations          | O(log n) for most operations      | O(1) for most operations          |
| **Thread-Safety**        | Not thread-safe                   | Not thread-safe                   | Not thread-safe                   | Not thread-safe                   |
| **Best for**             | General-purpose map               | Preserving insertion order       | Sorted key-value pairs            | Memory-sensitive caches           |



Summary
- HashMap: Best when order doesn't matter and you need efficient access to key-value pairs. It is widely used for general-purpose maps.
- LinkedHashMap: Ideal when you need to preserve the order of insertion, useful for scenarios like maintaining the order of processing.
- TreeMap: Best for when you need sorted key-value pairs. Useful for situations where you need keys in a specific order.
- WeakHashMap: Useful for memory-sensitive applications, like caches, where you want to allow garbage collection of keys that are no longer in use.















































































































































































































