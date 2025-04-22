# Java instanceof Operator

The instanceof operator in Java is used to test whether an object is an instance of a particular class or subclass, or an interface.  
It helps to ensure type safety when performing type casting by checking whether an object is compatible with a specific type before performing the cast.

Syntax: 
```java
object instanceof ClassName
```

Where 
- object: The object you want to check.
- ClassName: The class or interface you want to test the object against.

It returns a boolean value:
- true if the object is an instance of the specified class or implements the interface.
- false otherwise.

Example 1: Checking with a Class

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog(); // Dog object assigned to Animal reference

        if (animal instanceof Dog) {
            System.out.println("The object is an instance of Dog.");
        } else {
            System.out.println("The object is not an instance of Dog.");
        }

        if (animal instanceof Animal) {
            System.out.println("The object is an instance of Animal.");
        }
    }
}

```


Example 2: Checking with an Interface

```java
interface Flyable {
    void fly();
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Airplane implements Flyable {
    public void fly() {
        System.out.println("Airplane is flying");
    }
}

public class Main {
    public static void main(String[] args) {
        Flyable bird = new Bird();
        Flyable airplane = new Airplane();
        
        if (bird instanceof Flyable) {
            System.out.println("bird is an instance of Flyable.");
        }

        if (airplane instanceof Flyable) {
            System.out.println("airplane is an instance of Flyable.");
        }
    }
}

```

Notes:
- The instanceof operator returns false if the object is null.
- It is commonly used before casting an object to a specific type to avoid ClassCastException.

## Why Use instanceof?
- Type Safety: It avoids ClassCastException by ensuring an object is compatible with the type you're casting it to.
- Polymorphism: It helps in handling polymorphic behavior dynamically at runtime.





# New Features of instanceof in Java 16 and beyond:

## 1. Pattern Matching for instanceof (Java 16/17+)

With pattern matching, you can now perform a type check and cast the object to the specific type in one operation, which reduces verbosity and improves readability.


Instead of writing:
```java
if (obj instanceof Dog) {
    Dog dog = (Dog) obj; // explicit cast
    dog.bark();
}

```

You can now do this:

```java
if (obj instanceof Dog dog) {
    dog.bark(); // No explicit cast needed, obj is already cast to Dog
}

```

How Does it Work?

- The instanceof operator now also declares a variable that is the result of casting the object to the specified type (in this case, Dog).
- This allows you to directly use the object as the specified type in the scope where instanceof is true.
- The type is automatically cast for you, eliminating the need for a separate cast statement.


Example with Pattern Matching for instanceof:

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }

    void bark() {
        System.out.println("Dog is barking");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog(); // Dog object assigned to Animal reference
        
        // Old way (pre-Java 16):
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal; // explicit cast
            dog.bark();
        }

        // New way (Java 16 and later) with Pattern Matching:
        if (animal instanceof Dog dog) {
            dog.bark(); // Directly use dog, no need for explicit cast
        }
    }
}

```

Benefits of the New instanceof:

- Less Boilerplate Code: It reduces the need to explicitly cast the object after the instanceof check, making the code cleaner and less error-prone.
- Improved Readability: You can perform the check and the casting in one step, making it easier to understand what type you're working with.
- Simplifies Complex Conditionals: If you have multiple instanceof checks, pattern matching allows you to streamline the logic.


Example of Using instanceof Pattern Matching in a More Complex Case:

```java
class Animal {}
class Dog extends Animal {
    void bark() {
        System.out.println("Woof!");
    }
}
class Cat extends Animal {
    void meow() {
        System.out.println("Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog(); // Or you can change this to new Cat()

        if (animal instanceof Dog dog) {
            dog.bark(); // Works if it's a Dog
        } else if (animal instanceof Cat cat) {
            cat.meow(); // Works if it's a Cat
        } else {
            System.out.println("Unknown animal");
        }
    }
}

```

## Summary:

Java 8 and earlier: You need to manually check instanceof and then cast.

```java
if (obj instanceof Dog) {
    Dog dog = (Dog) obj;
}

```

Java 16 and beyond: You can now use pattern matching to simplify this into a more concise form.

```java
if (obj instanceof Dog dog) {
    // No need for explicit cast
}

```

This pattern matching feature is available from Java 16, and it is one of the significant changes in the way the instanceof operator works in newer Java versions (including Java 17, 18, and 21).   
This change helps reduce verbosity and makes type checking and casting much easier and cleaner.



# Java 17+/21: Pattern Matching in switch

And now you can take it even further — use it inside a switch!

```java
static void handle(Object obj) {
    switch (obj) {
        case String s -> System.out.println("String length: " + s.length());
        case Integer i -> System.out.println("Integer doubled: " + (i * 2));
        case null -> System.out.println("It's null!");
        default -> System.out.println("Unknown type");
    }
}

```

Super expressive, concise, and type-safe — no need for cascading if-else blocks anymore.