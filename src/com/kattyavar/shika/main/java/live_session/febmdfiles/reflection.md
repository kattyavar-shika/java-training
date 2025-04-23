# Introduction to Reflection in Java

# What is Reflection?

Reflection is a powerful feature in Java that allows a program to:

- Inspect classes, interfaces, fields, and methods at runtime,
- And even modify them, invoke methods, or create objects dynamically — without knowing their names at compile time.


# Why and When is Reflection Used?

Reflection is often used in advanced programming scenarios, where you need flexibility and don’t know the structure of the code ahead of time. It’s particularly useful for:

- Frameworks and libraries
  - (e.g., Spring, Hibernate) — They use reflection to inject dependencies, map objects to databases, etc.

- Plugins or modular systems
  - Where new classes or modules can be loaded dynamically.

- Serialization/Deserialization
  - To convert objects to data formats (like JSON or XML) and back again.


# What Can Reflection Do?

Reflection lets you analyze and interact with a program's structure at runtime. Specifically, you can:

- Inspect a class or interface
- Discover and read its fields (even private ones)
- Find and invoke its methods
- Access and use its constructors
- Create new instances of classes
- Modify values of fields or behavior of methods dynamically

This is possible without knowing the exact class or structure ahead of time, making reflection very dynamic.


# How It Works Internally

Reflection relies heavily on the Class class (from java.lang) and the java.lang.reflect package, which includes:

- `Class<T>` – Represents a class or interface in the Java runtime
- Field – Represents fields (variables) of a class
- Method – Represents methods of a class
- Constructor – Represents constructors of a class
- Modifier – Used to check the access level (e.g., public, private)
- Array – Provides static methods to dynamically create and access arrays

# How to Access Reflection in Java

There are typically three ways to get a Class object:

- 1 Using .class syntax:

```java
Class<?> clazz = MyClass.class;

```

- 2 Using getClass() method:

```java
MyClass obj = new MyClass();
Class<?> clazz = obj.getClass();

```

- 3 Using Class.forName():

```java
Class<?> clazz = Class.forName("com.example.MyClass");

```

This is very useful when the class name is only available at runtime (like from a config file).

##  Important Note

Reflection allows access to private members as well, but you must explicitly enable that:

```java
field.setAccessible(true); // to bypass private access

```

Note: Use this carefully — it breaks the typical rules of encapsulation.


# Reflection Exploration Overview (with API Methods)

## Class Info

Purpose: Get metadata about the class itself
 
```java
Class<?> clazz = Person.class;             // or Class.forName("Person")
clazz.getName();                           // returns full class name

```

## Fields

Purpose: Access all fields (including private), get/set values

```java
Field[] fields = clazz.getDeclaredFields(); // get all declared fields
field.setAccessible(true);                  // make private field accessible
field.get(personObj);                       // get value of the field
field.set(personObj, value);                // (optional) set value of the field
field.getType();                            // get data type of the field

```

## Constructor

Purpose: Access constructors and create new instances

```java
Constructor<?> constructor = clazz.getConstructor();    // get public constructor
Object obj = constructor.newInstance();                 // create new object

```

## Methods

Purpose: List and invoke methods (even private)

```java
Method[] methods = clazz.getDeclaredMethods(); // get all declared methods
method.setAccessible(true);                    // allow access to private methods
method.invoke(obj, args);                      // invoke method
method.getReturnType();                        // get return type

```

## Modifiers

Purpose: Check access levels (public, private, static, etc.)

```java
int mod = field.getModifiers();                // or method.getModifiers()
Modifier.toString(mod);                        // convert to readable format
Modifier.isPrivate(mod);                       // check if it's private

```

## Arrays

Purpose: Check if a field is an array and access elements


```java
field.getType().isArray();                     // check if field is an array
Object[] array = (Object[]) field.get(obj);    // get array value

```


Example 
```java
 class Person {
  private String name;
  private int age;
  private String[] hobbies;

  public Person() {
    this.name = "John";
    this.age = 30;
    this.hobbies = new String[]{"Reading", "Gaming"};
  }

  private void greet() {
    System.out.println("Hello, my name is " + name);
  }

  public int getAge() {
    return age;
  }
}

 
public class ReflectionDemo {
  public static void main(String[] args) throws Exception {
    // 1. Get Class object
    Class<?> clazz = Person.class;

    System.out.println("Class Name: " + clazz.getName());

    // 2. Get and use Constructor
    Constructor<?> constructor = clazz.getConstructor();
    Object personObj = constructor.newInstance();
    System.out.println("Constructor: " + constructor.getName());

    // 3. Get all fields (including private)
    Field[] fields = clazz.getDeclaredFields();
    System.out.println("\nFields:");
    for (Field field : fields) {
      field.setAccessible(true); // access private fields
      System.out.println("  Field: " + field.getName());
      System.out.println("    Type: " + field.getType().getSimpleName());
      System.out.println("    Value: " + field.get(personObj));
      System.out.println("    Modifier: " + Modifier.toString(field.getModifiers()));

      // If it's an array, loop through values
      if (field.getType().isArray()) {
        Object[] array = (Object[]) field.get(personObj);
        System.out.println("    Array Elements:");
        for (Object item : array) {
          System.out.println("      - " + item);
        }
      }
    }

    // 4. Get and invoke methods
    Method[] methods = clazz.getDeclaredMethods();
    System.out.println("\nMethods:");
    for (Method method : methods) {
      method.setAccessible(true); // access private methods
      System.out.println("  Method: " + method.getName());
      System.out.println("    Return Type: " + method.getReturnType().getSimpleName());
      System.out.println("    Modifier: " + Modifier.toString(method.getModifiers()));

      // Call greet method as a demo
      if (method.getName().equals("greet")) {
        method.invoke(personObj); // Output: Hello, my name is John
      }
    }
  }
}

```



# Simplified DI Example with Reflection

In the following example, we will demonstrate how reflection can be used to inject dependencies,   
similar to how frameworks like Spring manage dependency injection.

we’ll create just two classes: a service and a controller. The controller will have a service dependency, and we'll inject it using reflection.


Service class 

```java
public class Service {
    public void serve() {
        System.out.println("Service is serving!");
    }
}

```

Controller class 

```java
public class Controller {
    private Service service;  // This is our dependency (like @Autowired in Spring)

    public void run() {
        service.serve();  // Using the service
    }
}

```

3. Simple DI Container (Using Reflection)

```java
import java.lang.reflect.Field;

public class SimpleDI {

    public static void main(String[] args) throws Exception {
        // Create a Controller object (the one that needs dependencies)
        Controller controller = new Controller();

        // Inject the Service dependency using reflection
        injectDependency(controller);

        // Run the controller (now it can use the Service)
        controller.run();
    }

    // Mimics Spring's DI by injecting dependencies using reflection
    public static void injectDependency(Object obj) throws Exception {
        // Find the field that needs injection (Service in this case)
        Field field = obj.getClass().getDeclaredField("service");

        // Create the dependency (Service object)
        Service service = new Service();

        // Make the field accessible (bypass private modifier)
        field.setAccessible(true);

        // Inject the Service object into the Controller
        field.set(obj, service);
    }
}

```


## Downsides of Reflection
While reflection is a powerful tool, it comes with a few drawbacks:
- **Performance Overhead**: Reflective operations are generally slower than direct code.
- **Security Risks**: Reflecting on private fields or methods can break encapsulation and expose sensitive data.
- **Complexity**: Reflection makes the code harder to read and understand, especially when used excessively.
