#  Initialization Block

- in Java, there are two types of initialization blocks:
  - Static Initialization Block (static {}) → Executes once when the class is loaded.
  - Instance Initialization Block ({}) → Executes every time an object is created.

## 1. Static Initialization Block (static {})
- Runs only once, when the class is loaded into memory (before any objects are created).
- Used to initialize static variables.
- Executes before the main method (if present).

Example: Static Block Execution

```java
public class StaticExample {
    static int x;

    // Static Initialization Block
    static {
        x = 10;
        System.out.println("Static Block Executed! x = " + x);
    }

    public static void main(String[] args) {
        System.out.println("Main Method Executed!");
    }
}

```

output:

```text
Static Block Executed! x = 10
Main Method Executed!

```

### Key Points:

-  Static block executes only once when the class is loaded.
-  It is used to initialize static variables before the main method runs.
-  It is not dependent on object creation.


## 2. Instance Initialization Block ({})
- Executes before the constructor, every time an object is created.
- Used to initialize instance variables.
- Runs each time an object is instantiated.


Example: Instance Block Execution

```java
public class InstanceExample {
    int y;

    // Instance Initialization Block
    {
        y = 20;
        System.out.println("Instance Block Executed! y = " + y);
    }

    // Constructor
    public InstanceExample() {
        System.out.println("Constructor Executed!");
    }

    public static void main(String[] args) {
        InstanceExample obj1 = new InstanceExample();
        InstanceExample obj2 = new InstanceExample();  // Block runs again
    }
}

```

Output:

```text
Instance Block Executed! y = 20
Constructor Executed!
Instance Block Executed! y = 20
Constructor Executed!

```

### Key Points:
- Instance block runs before the constructor.
- It executes every time an object is created.
- Used to initialize instance variables.



# Using Both Static & Instance Blocks Together

```java
public class BlockExample {
    static int a;
    int b;

    // Static Block
    static {
        a = 50;
        System.out.println("Static Block Executed! a = " + a);
    }

    // Instance Block
    {
        b = 100;
        System.out.println("Instance Block Executed! b = " + b);
    }

    // Constructor
    public BlockExample() {
        System.out.println("Constructor Executed!");
    }

    public static void main(String[] args) {
        System.out.println("Main Method Executed!");

        BlockExample obj1 = new BlockExample();
        BlockExample obj2 = new BlockExample(); // Instance block runs again
    }
}

```

Output:

```text
Static Block Executed! a = 50
Main Method Executed!
Instance Block Executed! b = 100
Constructor Executed!
Instance Block Executed! b = 100
Constructor Executed!

```

Note: 
- Static Block Executes First → Before main(), when the class loads.
- Main Method Runs.
- Instance Block Executes Before the Constructor → Runs for each object creation.


# When to Use Them?
- Use Static Blocks when you need to initialize static variables (e.g., database connections, configuration loading).
- Use Instance Blocks when you need to initialize instance variables but want to avoid code duplication in multiple constructors.



## Comparison: Static vs Instance Blocks

| Feature               | Static Block (`static {}`)                     | Instance Block (`{}`)                     |
|-----------------------|--------------------------------|--------------------------------|
| **Execution**        | Executes **only once** when the class is loaded | Executes **every time** an object is created |
| **Purpose**          | Initializes **static variables** | Initializes **instance variables** |
| **Runs Before**      | Main method or first object creation | Constructor |
| **Dependency on Objects** | **No** (Runs before any object is created) | **Yes** (Runs when an object is created) |
| **Order of Execution** | Before `main()` and object creation | Before the constructor |
