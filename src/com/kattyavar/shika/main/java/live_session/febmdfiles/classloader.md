# JVM

# Updated Summary Table of Class Loaders in Java 8 vs Java 9+

| **Class Loader (Java 8)**           | **Where It Loads Classes From (Java 8)**                                | **Class Loader (Java 9+)**              | **Where It Loads Classes From (Java 9+)**                                |
|-------------------------------------|------------------------------------------------------------------------|-----------------------------------------|------------------------------------------------------------------------|
| **Bootstrap Class Loader**          | `rt.jar` in `<JDK>/jre/lib/`                                            | **Bootstrap Class Loader**              | `java.base` module (in `jmods` directory)                              |
| **Extension Class Loader**          | `lib/ext/` directory or directories specified by `java.ext.dirs`        | **Platform Class Loader**               | Platform modules (like `java.sql`, `java.desktop`, etc., in `jmods`)    |
| **System Class Loader**             | **Classpath** (specified by `-cp` or `-classpath` at runtime)          | **System Class Loader**                 | **Classpath** or **Module Path** (if using modules)                    |
| **Custom Class Loaders**            | Custom sources like file systems, networks, etc.                       | Custom Class Loaders                    | Custom sources, but may interact with the **module system** (if modules are used) |


## Class Loading process : 

The Class Loader performs several tasks during the loading process:

- **Loading**: The class loader reads the .class file (usually from disk or network) and creates a Class object.
- **Linking**
  - Verification: Ensures that the bytecode adheres to JVM specifications.
  - Preparation: Allocates memory for class variables and sets them to default values.
  - Resolution: Replaces symbolic references in the bytecode (like class names) with direct references (like memory addresses).
- **Initialization**
  - The class is initialized, which includes setting the static variables and executing static blocks.

## Runtime Data Areas
- These are memory areas used by the JVM during program execution. With Java 9 and beyond, there are some important changes in how these areas work.
- Heap: The heap still stores instance variables (non-static fields) and objects created during runtime. It's managed by the Garbage Collector to handle object allocation and deallocation.
- Java Stack: The Java Stack stores frames for each method invocation and local variables. Each thread has its own Java stack. Local variables (non-static) are stored here.
- Program Counter (PC) Register: Each thread has a PC register that keeps track of the current instruction being executed. This helps the JVM know where to continue execution after method calls.
- Native Method Stack: It stores native method calls (methods written in non-Java languages, such as C or C++). Like the Java stack, each thread has its own native method stack.
- Metaspace (introduced in Java 8, refined in Java 9+):
  - In Java 9 and beyond, Metaspace stores class metadata, including static variables and information about classes, methods, and other data structures.
  - Static variables (class variables) are now stored in Metaspace instead of the PermGen space, which was removed in Java 8.
  - Unlike PermGen, Metaspace is allocated outside the Java heap and can grow dynamically, reducing the risk of OutOfMemoryError due to space limitations.


## Execution Engine
- Interpreter: The interpreter reads and executes bytecode instructions one by one. While it can be slower compared to compiled code, it allows for quick execution of small code snippets.
- JIT Compiler: The Just-In-Time (JIT) Compiler compiles bytecode into machine code at runtime for better performance. Starting with Java 9, the JVM can use alternate compilers like Graal (via the JVMCI interface). Graal is a high-performance JIT compiler that allows more aggressive optimizations.
- Garbage Collector: The Garbage Collector manages memory by automatically reclaiming unused memory, removing objects that are no longer reachable.



##  Native Interface
- The Native Interface (via JNI - Java Native Interface) allows the JVM to interact with native code (code written in languages like C or C++). This is useful when interacting with system-level APIs or legacy code.


## Delegation Principle

The Java ClassLoader Delegate Principle is an important concept in Java's class loading mechanism.   
It defines how class loaders search for classes when they are requested to load a class.  
The principle emphasizes that a class loader should delegate the class loading request to its parent class loader before trying to load the class itself.


### How the Delegation Works:
- Step 1: The Application Class Loader receives a class loading request.
  - It first checks if the class is loaded (via findLoadedClass).
  - If the class is not loaded, it delegates to the Platform Class Loader (its parent).
- Step 2: The Platform Class Loader receives the request.
  - It checks if it can load the class, typically from the JDK modules.
  - If it cannot load the class, it delegates further to the Bootstrap Class Loader (the root loader).
- Step 3: The Bootstrap Class Loader is the last resort.
  - It loads core classes (e.g., java.lang.String), but it cannot delegate any further (since it has no parent).
  - If it doesn’t find the class (because it’s part of the application), the request may eventually be handled by a custom class loader.
- Step 4: If no class loader can load the class, the ClassNotFoundException is thrown.












## To get class information 

```java
Human obj = new Human();
 Class c1 = obj.getClass();
 
 //To get all getDeclaredMethods
 Method[] methods = c1.getDeclaredMethods();
 
 //To get all member variables. 

Field[] fields = c1.getDeclaredFields();

//to access it type and name. 
 // field.getName() &&  field.getType()


//PlatformClassLoader
    System.out.println(Connection.class.getClassLoader());
  //AppClassLoader
  System.out.println(HelloWorld.class.getClassLoader());
  //BootStrap class Loaders
  System.out.println(String.class.getClassLoader()); // you will get null
  
```

## To check internal how many thread are required only for HelloWorld.

```java
public class HelloWorldInternalThreadInfo {
  public static void main(String[] args) {
    System.out.println("Hello World");

    long pid = ProcessHandle.current().pid();

    System.out.println("Use this command to check the process more information ");
    System.out.println("ps -T -p " + pid);

    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
  }
}
```

## To check how many class are loaded to run simple hello world program 


```shell
# To Compile 
javac HelloWorld.java

# To Check byte code of .class file
javap -c HelloWorld.class 
# To check how many class are loaded to just run Hello World
java -Xlog:class+load=debug HelloWorld
```