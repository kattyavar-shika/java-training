# Equals HashCode and toString


## Problem:  Using == (Reference Equality)

- The == operator in Java is used to compare references, not the actual content of the objects. In other words, it checks if two references point to the same memory location (i.e., if they are the exact same object).
  - For primitives, == checks the actual values (e.g., for int, double).
  - For objects, == checks if two references point to the same object in memory.


```java
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30);
        Person p3 = p1;  // p3 is a reference to p1, so they point to the same object

        // Using == for comparison
        System.out.println(p1 == p2);  // false, because p1 and p2 are different objects
        System.out.println(p1 == p3);  // true, because p1 and p3 refer to the same object
    }
}

```

## How to solve this..? 

Three important methods in Java: equals(), toString(), and hashCode().  
These methods are commonly used to compare objects, display object information, and help with hashing in collections like HashMap and HashSet.  
Here’s an overview of each:

## 1. equals() Method

The equals() method is used to compare two objects for equality.  
By default, the equals() method in the Object class checks for **reference equality** (i.e., whether two references point to the same object in memory).   
However, it's often overridden to check for logical equality, meaning whether the content of the objects is the same.

Usage:
- When you want to compare two objects for logical equality, you override equals() in your class.
- This method typically returns a boolean: true if the objects are considered equal, false otherwise.


```java
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Same reference check
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);  // Content equality
    }
}

Person p1 = new Person("Alice", 30);
Person p2 = new Person("Alice", 30);

System.out.println(p1.equals(p2));  // Output: true

```

## 2. hashCode() Method

The hashCode() method returns an integer value that represents the hash code of an object.  
It’s primarily used in hash-based collections (like HashMap, HashSet, and Hashtable) to quickly locate an object in the collection.  
The general contract for hashCode() is that if two objects are equal according to the equals() method, they must have the same hash code.

Usage :
- If you override equals(), you should also override hashCode() to ensure that equal objects have the same hash code. Otherwise, collections like HashMap may not function correctly.
- The hashCode() method must return consistent hash codes for the same object.


```java
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);  // Uses both fields to generate a hash code
    }
}

Person p1 = new Person("Charlie", 40);
Person p2 = new Person("Charlie", 40);

System.out.println(p1.hashCode() == p2.hashCode());  // Output: true

```

## 3. toString() Method

The toString() method is used to return a string representation of an object.  
It's particularly useful when you need to print or log objects in a human-readable format.   
By default, Object.toString() returns the class name and the hash code, but it is common to override it to provide a more meaningful string representation of the object.

Usage: 
- You override toString() to provide a string that represents the object’s state (e.g., its fields).

```java
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

Person p = new Person("Bob", 25);
System.out.println(p.toString());  // Output: Person{name='Bob', age=25}

```

## Contract Between equals() and hashCode()

- Consistency of equals() and hashCode():
  - If two objects are equal according to the equals() method, they must also have the same hash code. This is critical for ensuring proper behavior when objects are stored in hash-based collections like HashMap and HashSet.
  - If a.equals(b) is true, then a.hashCode() == b.hashCode() must be true.
  - This is because hash-based collections use hash codes to quickly locate objects, and if two equal objects have different hash codes, they could end up in different "buckets" in the collection, breaking the equality contract.
- Consistency in hashCode():
  - The hashCode() method should consistently return the same value for the same object as long as the object’s state doesn’t change.
  - If an object’s fields that are used in equals() do not change, the result of hashCode() should remain the same throughout the lifetime of the object.
- Inequality in equals():
  - If two objects are not equal according to the equals() method, their hash codes may be the same, but they are not required to be. This means that the hash codes of unequal objects can be different, but they do not have to be.
  - If a.equals(b) is false, then it is not required that a.hashCode() != b.hashCode(). In fact, different objects may still have the same hash code (this is known as a "hash collision").


## The hashCode() Method Contract:

- It is generally recommended that when you override equals(), you also override hashCode(). 
- If you don't, Java's default hashCode() method (from the Object class) will be used, which does not guarantee the correct behavior for objects that are logically equal but have different references.

Example Scenario for equals() and hashCode() Contract

```java
import java.util.Objects;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);  // Hashes based on the fields used in equals
    }
}

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30);
        Person p3 = new Person("Bob", 25);

        System.out.println(p1.equals(p2));  // true
        System.out.println(p1.hashCode() == p2.hashCode());  // true

        System.out.println(p1.equals(p3));  // false
        System.out.println(p1.hashCode() == p3.hashCode());  // May or may not be true
    }
}

```








