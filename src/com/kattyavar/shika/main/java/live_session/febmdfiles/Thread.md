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











