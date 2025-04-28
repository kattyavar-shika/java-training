# Singleton Design Pattern

> The Singleton pattern ensures that a class has only one instance and provides a global point of access to it.


This is useful when exactly one object is needed to coordinate actions across the system, such as configuration managers, logging, thread pools, or caching.

# When to Use Singleton Pattern (Usage)

- Logger classes
- Configuration settings (AppConfig)
- Thread pools
- Caching
- Accessing resources shared across the application
- Managing a single database connection or driver instance

# Basic Implementation (Lazy Initialization)

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private constructor prevents instantiation from outside
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

```

**Problem with this**: Not thread-safe. In multithreaded applications, two threads could create separate instances at the same time.

# Thread-Safe Singleton (Synchronized Method)

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

```

**Drawback**: Synchronizing the entire method can reduce performance.


# Best Practice: Double-Checked Locking

```java
public class Singleton {
  private static volatile Singleton instance;

  private Singleton() {}

  public static Singleton getInstance() {
    if (instance == null) {  // 1st check (without synchronization)
      synchronized (Singleton.class) {  // enter synchronized block
        if (instance == null) {  // 2nd check (with synchronization)
          instance = new Singleton();  // create the instance
        }
      }
    }
    return instance;  // return the instance
  }
}


```

volatile ensures changes to the instance are visible to all threads.

Double-checked locking improves performance by locking only the first time.


## Without volatile — What Could Go Wrong?

- When volatile is not used, the JVM can reorder instructions during object creation, which may lead to Thread B seeing a partially initialized object.

### Thread A creates the object:
- Thread A enters getInstance().
- Thread A sees that instance is null.
- Thread A enters the synchronized block and checks again if instance is null.
- Thread A allocates memory for the Singleton object.
- Thread A assigns the reference instance = new Singleton().
- This could happen before the constructor finishes initializing the object's fields.
- Thread A then finishes the constructor, and the Singleton object is now fully initialized.
- Thread A exits the synchronized block.


### Now, Thread B accesses getInstance():
- Thread B enters getInstance(), and checks if instance is null.
- Thread B sees that instance != null because Thread A has assigned the reference to instance.
- Thread B skips the synchronized block because instance is non-null.
- Thread B uses the instance object, but it **might not be fully initialized because Thread A could have assigned the reference before finishing the constructor**.

Result : 

Thread B could end up working with a partially initialized object (e.g., fields like name or id could be uninitialized).


# Comparison — What Happens:

## Without `volatile` (Potential Issue):

| **Thread A**                         | **Thread B**                                  |
|--------------------------------------|-----------------------------------------------|
| 1. Enters `getInstance()`            |                                               |
| 2. Sees `instance` is `null`         |                                               |
| 3. Enters synchronized block         |                                               |
| 4. Sees `instance` is still `null`   |                                               |
| 5. Allocates memory for the object   |                                               |
| 6. Assigns reference to `instance`   |                                               |
| 7. Finishes object initialization    |                                               |
|                                      | 1. Enters `getInstance()`                    |
|                                      | 2. Sees `instance` is **non-null**           |
|                                      | 3. Skips synchronized block                  |
|                                      | 4. Uses **partially initialized object** ❌   |

**Problem**: **Thread B** could use a **partially initialized object** because the reference was assigned **before** the constructor finished, due to **instruction reordering**.

---

## With `volatile` (Expected Behavior):

| **Thread A**                         | **Thread B**                                  |
|--------------------------------------|-----------------------------------------------|
| 1. Enters `getInstance()`            |                                               |
| 2. Sees `instance` is `null`         |                                               |
| 3. Enters synchronized block         |                                               |
| 4. Sees `instance` is still `null`   |                                               |
| 5. Allocates memory for the object   |                                               |
| 6. Initializes the object’s fields   |                                               |
| 7. Assigns reference to `instance`   |                                               |
| 8. Exits synchronized block          |                                               |
|                                      | 1. Enters `getInstance()`                    |
|                                      | 2. Sees `instance` is **non-null**           |
|                                      | 3. Skips synchronized block                  |
|                                      | 4. Uses **fully initialized object** ✅       |

**With `volatile`,** **Thread B** will always see the **fully initialized object**, ensuring no **partially initialized state**.


## Understanding Instruction Reordering:

```java
instance = new Singleton();

```

When a thread executes code like instance = new Singleton();, it involves several steps:

- Allocate memory for the new object (Singleton).
- Initialize the object's fields (in the constructor).
- Assign the reference to instance.


> However, the JVM and the underlying CPU can reorder certain operations for performance optimization.   
> This means that the JVM is allowed to change the order in which the instructions are executed to speed up execution, as long as the program’s visible behavior (the final result) remains logically correct within the current thread.


However, this reordering can introduce issues when multiple threads are involved, which is the root of the issue in the Singleton pattern.   
Let me explain each step in more detail, and how it can be reordered by the JVM.



## Steps in Object Creation

- 1 Memory Allocation:
  - The JVM allocates memory for the new Singleton object. This step involves reserving space in memory for the object but doesn’t initialize its fields yet.

- 2 Constructor Initialization:
  - The constructor (Singleton()) is called, and it initializes the fields of the object (e.g., setting variables like name, id, etc.). This is where the object is fully constructed and initialized.

- 3 Reference Assignment:
  - The reference instance is assigned the newly created object, linking the variable instance to the memory location of the Singleton object.

-----

## How Reordering Can Happen

In the absence of synchronization or volatile, the JVM can reorder the above operations. Here's a possible reordering:

- Step 1 (Allocate memory): The JVM might assign memory for the object after setting the reference. This could mean that the reference points to an uninitialized object.

- Step 3 (Assign reference): The JVM might assign the reference (instance = new Singleton()) to instance before the object’s fields are fully initialized in the constructor.

This can happen because assigning the reference is a quick operation compared to field initialization, and the JVM may decide to perform this first.

- Step 2 (Initialize fields): The initialization of fields might be delayed until after the reference assignment. This can lead to a situation where other threads might see the reference to instance as non-null, but the fields inside the object are not yet initialized.









