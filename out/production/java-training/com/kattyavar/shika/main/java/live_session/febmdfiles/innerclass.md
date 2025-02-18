# What is an Inner Class?

An inner class is a class defined within another class in Java. 
It is used to logically group classes that are only used in one place, which helps keep the code more readable and organized. 
Inner classes can access the members (both instance and static) of the outer class.

There are several types of inner classes in Java:

1. **Non-static Inner Class (Member Inner Class)**
2. **Static Nested Class**
3. **Local Inner Class**
4. **Anonymous Inner Class**


## 1 Non-static Inner Class (Member Inner Class)

This is the most common type of inner class. It is associated with an instance of the outer class and can access the outer class's members.

```java
class Outer {
    private String outerField = "Outer Field";
    
    class Inner {
        void display() {
            System.out.println("Accessing outer class field: " + outerField);
        }
    }
    
    void createInner() {
        Inner inner = new Inner(); // Creating an instance of the Inner class
        inner.display();
    }
}

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer(); // Creating an instance of Outer class
        outer.createInner(); // Calling method to create and use Inner class
        //or you can do this way 
        outer.new Inner();
      
      
    }
}

```

### Key points:
- The inner class has a reference to the outer class, meaning it can access all members of the outer class.
- It requires an instance of the outer class to be created before you can create an instance of the inner class.


## 2. Static Nested Class

Unlike the non-static inner class, a static nested class can be instantiated without an instance of the outer class. It can only access static members of the outer class.

```java
class Outer {
    private static String staticOuterField = "Static Outer Field";
    
    static class StaticNested {
        void display() {
            System.out.println("Accessing static outer class field: " + staticOuterField);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer.StaticNested nested = new Outer.StaticNested(); // Creating an instance of static nested class
        nested.display();
    }
}

```

### key points:
- It doesn't require an instance of the outer class to be created.
- It can only access the static members of the outer class.


## 3. Local Inner Class
A local inner class is defined within a method, constructor, or block. It is only accessible within the method or block where it is defined.

```java
class Outer {
    void outerMethod() {
        class LocalInner {
            void display() {
                System.out.println("Local inner class method");
            }
        }
        
        LocalInner local = new LocalInner(); // Creating an instance of the local inner class
        local.display();
    }
}

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.outerMethod(); // Calling the method that contains the local inner class
    }
}

```

### key points
- The local inner class is only visible inside the method or block.
- It can access the local variables of the enclosing method if they are marked as final (or effectively final).
- You cannot use access specifiers (public, private, protected) on local inner classes because they are scoped within the method, and their accessibility is limited to that method only. The concept of specifying their visibility outside of the method does not apply.


## 4. Anonymous Inner Class
An anonymous inner class is a class without a name. It is used when you need to instantiate a class that implements an interface or extends a class on the fly, typically when working with event listeners or threads.

```java
interface Greeting {
    void greet();
}

public class Main {
    public static void main(String[] args) {
        Greeting greeting = new Greeting() {
            @Override
            public void greet() {
                System.out.println("Hello from anonymous inner class!");
            }
        };
        
        greeting.greet();
    }
}

```

### Key points:
- The class does not have a name.
- It is used to implement an interface or extend a class in a concise manner.
- It's typically used for short-lived use cases, like callbacks.




# Summary of Different Inner Class Types:

| Type                    | Instantiation Requirement                     | Can Access                          | Scope                          |
|-------------------------|-----------------------------------------------|-------------------------------------|--------------------------------|
| **Non-static Inner Class** | Requires an instance of outer class           | Non-static and static members       | Outer class instance scope     |
| **Static Nested Class**   | Can be instantiated independently             | Only static members                 | Outer class class scope        |
| **Local Inner Class**     | Defined within a method/block                 | Local method variables (final)      | Method/block scope             |
| **Anonymous Inner Class** | Instantiated without class declaration        | Parent class or interface members   | Local to the instantiation context |


# Inheriting from Inner Class


## Inheriting from a Non-static Inner Class

- In Java, a non-static inner class can be inherited just like any other class, but there are a few specific points to keep in mind:
- Inner Class is Tied to an Instance of the Outer Class: A non-static inner class is associated with an instance of the outer class. When you inherit a non-static inner class, you will need an instance of the outer class to create an instance of the inner class, as the inner class depends on the outer class instance.
- Inheriting a Non-static Inner Class: If another class wants to inherit from a non-static inner class, it must do so by creating an instance of the outer class. This means that inheritance will depend on the instance of the outer class.

Example 

```java
class Outer {
    class Inner {
        void display() {
            System.out.println("Inside Inner class");
        }
    }
}

class Derived extends Outer.Inner {
    Derived(Outer outer) {
        outer.super(); // Call the constructor of the Inner class
    }

    void newMethod() {
        System.out.println("New method in Derived class");
    }
}

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Derived derived = new Derived(outer); // Need an instance of Outer to create Derived

        derived.display();  // Calling inherited method from Inner class
        derived.newMethod(); // Calling new method from Derived class
    }
}

```


###  key Takeways:

- Yes, you can inherit from a non-static inner class, but you need an instance of the outer class to do so.
- Inheritance from an inner class might be useful for extending or modifying its behavior, but it's often better to use composition instead of inheritance, depending on the design context.
- Inheritance from inner classes is relatively rare in practice and is more of an advanced or specific design choice.



##  Static Inner Class and Inheritance
- Inheriting from a static inner class is quite different from inheriting from a non-static inner class, and it is generally more straightforward because a static inner class does not depend on an instance of the outer class. This means that it behaves more like a regular nested class, which can be instantiated and inherited without needing an instance of the outer class.


```java
class Outer {
    static class Inner {
        void display() {
            System.out.println("Inside the static inner class");
        }
    }
}

class Derived extends Outer.Inner {
    Derived() {
        super();  // No need for an instance of Outer class
    }

    @Override
    void display() {
        super.display();
        System.out.println("Inside the derived class");
    }
}

public class Main {
    public static void main(String[] args) {
        Derived derived = new Derived();  // Create an instance of the derived class
        derived.display();  // Output: Inside the static inner class
                            //         Inside the derived class
    }
}

```

### Why Use Composition Instead of Inheritance?

- Even though inheritance is possible, it is often considered a good practice to prefer composition over inheritance. This is because inheritance introduces tight coupling between the classes, whereas composition allows for more flexibility and easier maintenance. If the inner class is only used as part of the outer class's functionality, it might be better to use composition to include the inner class rather than inheriting from it.

