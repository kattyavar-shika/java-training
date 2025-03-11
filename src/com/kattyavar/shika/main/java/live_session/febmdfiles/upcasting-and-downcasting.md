#  Upcasting and Down casting in Java

Upcasting and Downcasting are types of type casting in Java, specifically related to object-oriented programming and the relationship between a superclass and its subclass.


## Upcasting

- Definition: Upcasting is the process of converting a subclass type to a superclass type. This happens implicitly in Java, and there is no risk of losing data since the subclass object is a specialized version of the superclass.
- Usage: Upcasting allows you to treat an object of a subclass as an object of the superclass. This is often used when you want to work with objects in a more general form (i.e., treat different objects in a class hierarchy uniformly).

Example:
```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();           // Dog object
        Animal animal = dog;           // Upcasting: Dog to Animal (implicitly)
        
        animal.makeSound();            // Outputs "Dog barks" due to dynamic method dispatch
    }
}

```

- dog is of type Dog, but we assign it to an Animal reference (animal). This is upcasting.
- The method makeSound() is overridden in the subclass (Dog), so when animal.makeSound() is called, the Dog's version of makeSound() is executed (thanks to dynamic method dispatch).
- Upcasting allows us to treat a Dog as an Animal but still invoke subclass behavior.


## Downcasting
- Definition: Downcasting is the process of converting a superclass type to a subclass type. This requires explicit casting and can throw a ClassCastException if the object cannot actually be downcasted to the target subclass type.
- Usage: Downcasting is used when you want to treat a superclass reference as a specific subclass type. However, you need to be sure that the object referenced by the superclass variable is indeed an instance of the subclass.

Example:

```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();   // Upcasting
        Dog dog = (Dog) animal;      // Downcasting (explicit cast)
        
        dog.makeSound();             // Outputs "Dog barks"
    }
}

```

- We start with an Animal reference pointing to a Dog object (upcasting).
- To access Dog-specific features or methods, we downcast the animal reference back to Dog (explicit casting).
- Downcasting is necessary because the reference type (Animal) doesn't directly support methods or properties unique to the Dog class.

### Downcasting with Risk:

If you downcast to the wrong subclass type, a ClassCastException will be thrown.

```java
Animal animal = new Animal();
Dog dog = (Dog) animal;   // ClassCastException at runtime

```

### Using instanceof with Downcasting

The instanceof operator is used to check whether an object is an instance of a particular class or implements a specific interface. It returns true if the object is an instance of the specified class or interface, and false otherwise.


### Why Use instanceof with Downcasting?

Before downcasting, it's good practice to check whether the object is of the type you're trying to cast to. This ensures that the cast is safe and avoids the risk of a ClassCastException at runtime.

```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();  // Upcasting

        // Check if the 'animal' object is an instance of the Dog class
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;  // Safe Downcasting
            dog.makeSound();         // Outputs "Dog barks"
        } else {
            System.out.println("animal is not an instance of Dog");
        }
        
        // Trying with an invalid type
        animal = new Animal();     // animal is now an instance of Animal, not Dog
        
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;  // This won't happen because 'animal' is not a Dog
            dog.makeSound();
        } else {
            System.out.println("animal is not an instance of Dog");
        }
    }
}

```
