# Concurrency

Concurrency in Java refers to the ability of a program to execute multiple tasks or processes simultaneously, or seemingly simultaneously, by managing multiple threads. In simpler terms, it allows a program to perform several tasks at once or in overlapping periods.

Concurrency is important for improving the performance of applications, especially in multi-core processors, as it allows different parts of a program to run in parallel or interleave their execution to make better use of system resources.

## Key Concepts:
- Thread: The smallest unit of a CPU's execution. Java allows you to create and manage multiple threads to perform concurrent tasks.
- Multithreading: It’s the practice of using multiple threads to execute tasks concurrently.
- Synchronization: A mechanism to ensure that multiple threads do not interfere with each other when accessing shared resources.


### Example of Concurrency in Java:

Here's a simple example of two threads running concurrently:

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Value " + i);
        }
    }
}

public class ConcurrencyExample {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        
        thread1.start(); // Start thread 1
        thread2.start(); // Start thread 2
    }
}

```

## Benefits of Concurrency:
- Performance Improvement: By running multiple threads simultaneously, a program can complete tasks faster, especially on multi-core systems.
- Resource Utilization: More efficient use of system resources (CPU, memory) by handling multiple tasks in parallel.

## Challenges:
- **Thread Safety**: Ensuring that multiple threads don't corrupt shared data.
- **Deadlock**: A situation where two or more threads are blocked forever because they are waiting for each other to release resources.
- **Race Conditions**: When the behavior of a program depends on the order of execution of threads, leading to unpredictable results.


# Threads: Creating and Running in Java

In Java, a Thread is a lightweight process that runs independently of the main program. A thread allows your program to perform multiple operations simultaneously or concurrently. Java provides two primary ways to create and run threads.

## Definition of a Thread:

A Thread is essentially a small unit of a process, and it can run independently. In Java, the Thread class represents a thread of execution in a program. Java supports multithreading, which means it can run multiple threads concurrently, making it more efficient for performing complex tasks.


## Creating and Running Threads in Java
There are two main ways to create and run threads in Java:
- By Extending the Thread Class
- By Implementing the Runnable Interface
- By Implementing the Callable Interface


### 1. Creating a Thread by Extending the Thread Class

You can create a new thread by subclassing the Thread class and overriding its run() method. The run() method contains the code that will be executed by the thread.

Steps:
- Step 1: Create a subclass of the Thread class.
- Step 2: Override the run() method to define the task.
- Step 3: Create an object of the subclass and call the start() method to begin execution.

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Value " + i);
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        
        thread1.start(); // Start thread 1
        thread2.start(); // Start thread 2
    }
}

```

### 2. Creating a Thread by Implementing the Runnable Interface

Another way to create a thread is by implementing the Runnable interface. This is considered more flexible because it allows you to create a thread from any class, not just by subclassing Thread.

Steps:
- Step 1: Implement the Runnable interface in your class.
- Step 2: Override the run() method to define the task.
- Step 3: Create a Thread object and pass an instance of the Runnable class to it.
- Step 4: Call the start() method on the Thread object to begin execution.

```java
class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Value " + i);
        }
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        
        thread1.start(); // Start thread 1
        thread2.start(); // Start thread 2
    }
}

```

You can convert the code to use a lambda expression in Java for the Runnable interface. Here's the updated version of your code using lambda:

```java
public class RunnableExample {
    public static void main(String[] args) {
        // Using lambda for Runnable
        Runnable myRunnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getId() + " Value " + i);
            }
        };

        // Creating threads with the lambda expression
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);

        thread1.start(); // Start thread 1
        thread2.start(); // Start thread 2
    }
}

```

### 2. Creating a Thread by Implementing the Callable Interface

In addition to Thread and Runnable, Java provides another interface called Callable for creating tasks that can be executed concurrently, especially when you need to return a result or handle exceptions during execution.


#### Callable Interface:
- The Callable interface is very similar to Runnable, but with a few key differences:
  - Return Value: While Runnable cannot return a result (its run() method is void), Callable allows the task to return a result or throw an exception.
  - Exception Handling: Runnable.run() cannot throw any checked exceptions, but Callable.call() can throw exceptions (like IOException, etc.).

The Callable interface is typically used with an ExecutorService, which can manage and execute tasks asynchronously. The ExecutorService provides methods to submit tasks that return results, such as submit().

Steps to Use Callable:
- Step 1: Create a class that implements the Callable interface and overrides the call() method.
- Step 2: Submit the Callable task to an ExecutorService using the submit() method, which returns a Future object.
- Step 3: The Future object allows you to retrieve the result or handle exceptions after the task completes.


```java
import java.util.concurrent.*;

class MyCallable implements Callable<Integer> {
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
            Thread.sleep(500); // Simulating some delay
        }
        return sum; // Returning the result
    }
}

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        MyCallable myCallable = new MyCallable();
        
        // Submit the task and get a Future object
        Future<Integer> future = executorService.submit(myCallable);
        
        try {
            // Retrieve the result from the Callable task this is blocking call.
            Integer result = future.get();
            System.out.println("The sum is: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}

```

you can use Callablle without executor service. 

```java
import java.util.concurrent.*;

class MyCallable implements Callable<Integer> {
  public Integer call() throws Exception {
    int sum = 0;
    for (int i = 1; i <= 5; i++) {
      sum += i;
      Thread.sleep(500); // Simulating some delay
    }
    return sum; // Returning the result
  }
}

public class PollingForResult {
  public static void main(String[] args) {
    MyCallable myCallable = new MyCallable();
    FutureTask<Integer> futureTask = new FutureTask<>(myCallable);

    // Start the task in a new thread
    Thread thread = new Thread(futureTask);
    thread.start();

    // Poll for the result without blocking
    while (!futureTask.isDone()) {
      System.out.println("Task is still running...");
      try {
        Thread.sleep(100); // Poll every 100ms
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    try {
      // Once the task is done, get the result
      Integer result = futureTask.get();
      System.out.println("The sum is: " + result);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}

```


# Difference Between Runnable, Callable, and Thread

| Feature            | Runnable                              | Callable                              | Thread                                |
|--------------------|---------------------------------------|---------------------------------------|---------------------------------------|
| **Return Value**    | No return value (void run() method)   | Returns a result (via call() method)  | No return value (you must manage the task manually) |
| **Exceptions**      | Cannot throw checked exceptions      | Can throw checked exceptions          | Cannot throw checked exceptions      |
| **Usage**           | Basic tasks without return values    | Tasks that require results or may throw exceptions | Basic task execution (does not return values or handle exceptions directly) |
| **Result Handling** | No result handling                   | Can retrieve the result via Future    | No built-in result handling          |





# Java Thread Lifecycle

The Java Thread Lifecycle refers to the various states a thread can be in during its existence, from when it is created until it terminates.  
Understanding the thread lifecycle is essential for managing threads effectively in Java.   
The thread lifecycle is controlled by the Java Virtual Machine (JVM) and can be divided into the following key states:


## 1. New (Born) State
- Definition: A thread is in the new state when it is created, but it has not yet started. In this state, the thread has been instantiated but has not begun execution.
- Example: Thread t = new Thread();

## 2. Runnable State
- Definition: A thread enters the runnable state when the start() method is invoked. A thread is considered runnable when the JVM is ready to execute it, but it may not immediately get CPU time to run. The thread can be in this state for a while, depending on the operating system’s thread scheduling.
- Example: t.start();


## 3. Blocked State

- Definition: A thread enters the blocked state when it is waiting to acquire a lock (monitor) for a synchronized block or method. This happens if another thread is holding the lock, and the current thread is waiting for that lock to be released.
- Example: A thread trying to enter a synchronized method or block while another thread is already executing in that synchronized block.

## 4. Waiting State

- Definition: A thread enters the waiting state when it is waiting indefinitely for another thread to perform a particular action, such as calling notify() or notifyAll(). The thread in this state is waiting for some condition to be met before it can resume execution.
- Methods: Thread.wait(), Object.wait()
- Example: synchronized (obj) { obj.wait(); }


## 5. Timed Waiting State
- Definition: A thread enters the timed waiting state when it is waiting for a specified period of time. This is typically used when a thread needs to pause its execution for a specific duration and then resume automatically.
- Methods: Thread.sleep(millis), Thread.join(millis), Object.wait(millis)
- Example: Thread.sleep(1000);

## 6. Terminated (Dead) State
- Definition: A thread enters the terminated state when its run() method has completed, or if the thread is terminated due to an exception. Once in this state, a thread cannot be restarted. It is considered dead.
- Example: When the run() method completes or the thread is interrupted or stops due to an exception.


### Lifecycle Transitions:
- A new thread becomes runnable when its start() method is invoked.
- A runnable thread can become blocked if it is trying to acquire a lock.
- A runnable thread can move to the waiting or timed waiting state if it calls wait(), sleep(), or join().
- After finishing its task, a thread moves to the terminated state.




# Java Thread Lifecycle Diagram
# Java Thread Lifecycle Diagram

```plaintext
     +-------------------+
     |      New          |  <-- Thread is created but not yet started.
     +-------------------+
             |
             v
     +-------------------+
     |    Runnable       |  <-- Thread is ready to run and waiting for CPU time.
     +-------------------+
        ^      ^      ^
       /       |       \
      v        v        v
+-----------+ +-----------+ +-----------+
|  Blocked  | | Waiting   | | Timed     |  <-- Thread is waiting for lock, notify, or timeout.
+-----------+ +-----------+ +-----------+
             |
             v
    +-------------------+
    |    Terminated     |  <-- Thread has completed its task or is terminated.
    +-------------------+
       ^ 
       |
       +----------------------------------+
          <-- Thread can also go directly
          from Runnable to Terminated.

```



Please refer https://excalidraw.com/ diagram for more details.. (threadState.excalidraw)



# Thread Synchronization in Java:

Thread synchronization is a concept used in Java to ensure that only one thread can access a shared resource at any given time. This is important to avoid conflicts or inconsistent data when multiple threads are accessing or modifying shared data.

In a multithreaded environment, if multiple threads modify shared data concurrently without synchronization, it can lead to race conditions where the threads interfere with each other, leading to unpredictable results.

## Why is Synchronization Important?

**Race Conditions:** If two or more threads try to update the same resource at the same time without synchronization, the result might be incorrect or inconsistent. For example, two threads updating a counter might both read the same value before updating it, causing one update to be lost.

**Data Integrity:** Synchronization ensures that critical sections (parts of code that access shared resources) are executed by only one thread at a time, ensuring consistent and reliable behavior.



## Types of Synchronization in Java:

- Synchronized Methods
- Synchronized Blocks
- Reentrant Locks (java.util.concurrent.locks)
- Atomic Classes
- Volatile Variables


## 1. Synchronized Methods

The most basic form of synchronization is using the synchronized keyword to mark a method as synchronized. This ensures that only one thread can execute the method at any given time.

### Instance-level Synchronization:

```java
public synchronized void method() {
    // Only one thread can execute this method at a time
    // Critical section
}

```

- When a method is marked synchronized, the lock is applied on the instance of the object (the object itself).
- Only one thread can execute this synchronized method on the same object.

### Class-level Synchronization:

If the synchronized keyword is used on a static method, the lock is applied to the class itself.

```java
public synchronized static void staticMethod() {
    // Only one thread can execute this method on the class
}

```
In this case, all threads will compete for the lock on the class itself, not an instance.


## 2. Synchronized Blocks

Sometimes, it's more efficient to synchronize only part of a method, especially when the method does other non-critical tasks. This is done using synchronized blocks.

```java
public void someMethod() {
    // Some non-critical code

    synchronized (lockObject) {
        // Only one thread can execute this block at a time
        // Critical section code that accesses shared resources
    }

    // Some non-critical code
}

```

lockObject is an object that acts as a lock. Only one thread can acquire the lock on this object and enter the synchronized block.

This provides fine-grained control over synchronization and is usually more efficient than synchronizing an entire method.


## 3. Reentrant Locks (java.util.concurrent.locks)

Java provides more advanced synchronization tools via the java.util.concurrent.locks package, particularly ReentrantLock. It provides more flexibility than synchronized methods and blocks, such as the ability to attempt to acquire a lock without blocking, or to interrupt a thread waiting for a lock.

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyClass {
    private final Lock lock = new ReentrantLock();

    public void method() {
        lock.lock();  // Acquire lock
        try {
            // Critical section code
        } finally {
            lock.unlock();  // Ensure the lock is released even if an exception occurs
        }
    }
}

```

ReentrantLock allows a thread to acquire a lock multiple times, making it reentrant (the same thread can lock it multiple times).

lock.lock() and lock.unlock() allow explicit control over acquiring and releasing locks, providing more flexibility than synchronized methods and blocks.


### ReentrantLock and tryLock()

In the java.util.concurrent.locks package, ReentrantLock is a more flexible and powerful alternative to the synchronized keyword. It allows fine-grained control over locking and unlocking, as well as additional features like tryLock(), lockInterruptibly(), and more.

Basic ReentrantLock Usage:

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyClass {
    private final Lock lock = new ReentrantLock();  // Create a reentrant lock

    public void method() {
        lock.lock();  // Acquire the lock
        try {
            // Critical section code
        } finally {
            lock.unlock();  // Ensure the lock is released
        }
    }
}

```

lock.lock() is used to acquire the lock, and lock.unlock() is used to release it, with the finally block ensuring that the lock is released even if an exception occurs inside the critical section.

**tryLock() Method**

The tryLock() method is a non-blocking method that attempts to acquire the lock. It returns immediately, either indicating that the lock was successfully acquired or that the lock is currently unavailable.

tryLock(): Tries to acquire the lock without blocking. It returns true if the lock was acquired, and false if the lock is not available.

Example:
```java
if (lock.tryLock()) {
    try {
        // Critical section code
    } finally {
        lock.unlock();
    }
} else {
    // Handle the situation when the lock is not available
    System.out.println("Lock not available, performing alternate action.");
}

```

In this example, if the lock is available, the thread enters the critical section, and if the lock is not available, the thread handles the situation by executing an alternate action (such as retrying later or performing other tasks).


**Variations of tryLock()**

There are a couple of variations of tryLock() that provide more flexibility:

1. tryLock(long time, TimeUnit unit):

This version of tryLock() allows you to specify a timeout. It will attempt to acquire the lock, and if the lock is not available within the specified time period, it will return false. This allows you to implement custom behavior if the thread cannot acquire the lock in a reasonable amount of time.

syntax:
```java
boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

```

Example: 
```java
if (lock.tryLock(1, TimeUnit.SECONDS)) {
    try {
        // Critical section code
    } finally {
        lock.unlock();
    }
} else {
    // Handle timeout, such as retrying or performing other tasks
    System.out.println("Lock not acquired within the specified time.");
}

```



## 4. Atomic Classes (java.util.concurrent.atomic)

Java provides atomic classes in the java.util.concurrent.atomic package, such as AtomicInteger, AtomicLong, AtomicBoolean, and more. These classes offer atomic operations on shared variables, meaning the operations are performed atomically without the need for synchronization.

Example: 
```java
import java.util.concurrent.atomic.AtomicInteger;

public class MyClass {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();  // Atomic increment operation
    }
}

```

Atomic classes ensure thread-safe operations on a single variable, making it easy to manage shared data without manually synchronizing the code.

## 5. Volatile Variables

The volatile keyword ensures that a variable is always read from and written to main memory, rather than from a thread’s local cache. This guarantees visibility of changes to variables across all threads.

```java
private volatile boolean flag = false;

public void someMethod() {
    while (!flag) {
        // Busy-wait until flag is set to true by another thread
    }
}

```




# Virtual Threads 

A Virtual Thread in Java is a lightweight thread that is managed by the Java Virtual Machine (JVM), rather than by the underlying operating system (OS).  
Virtual threads are introduced in Java 19 as part of Project Loom.   
These threads are designed to allow developers to efficiently handle large numbers of concurrent tasks, particularly for I/O-bound or non-blocking workloads, without consuming significant system resources.



Lets create the thread using system thread 

```java
public class TraditionalThreadsExample {

    public static void main(String[] args) {
        int numberOfThreads = 2000; // Use a smaller number for demonstration, but this can be adjusted for stress testing

        // Start threads
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " - Thread started.");
                    // Simulate some work
                    Thread.sleep(1000); // Simulate a 1-second task
                    System.out.println(Thread.currentThread().getName() + " - Thread completed.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " - Thread interrupted.");
                }
            });

            thread.start();
        }

        System.out.println("Started " + numberOfThreads + " traditional threads.");
    }
}

```

and now try this.. 

```java
public class VirtualThreadsExample {

    public static void main(String[] args) {
        int numberOfThreads = 2000; // A smaller number for demonstration; you can increase it for stress testing

        // Start virtual threads
        for (int i = 0; i < numberOfThreads; i++) {
            Thread.ofVirtual().start(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " - Virtual thread started.");
                    // Simulate some work
                    Thread.sleep(1000); // Simulate a 1-second task
                    System.out.println(Thread.currentThread().getName() + " - Virtual thread completed.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " - Virtual thread interrupted.");
                }
            });
        }

        System.out.println("Started " + numberOfThreads + " virtual threads.");
    }
}

```