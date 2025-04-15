# Comparable Interface

Comparable is an interface used to define the natural ordering of objects.  
A class implements Comparable to allow its objects to be sorted using Collections.sort() or Arrays.sort() without needing a separate comparator.

```java
public interface Comparable<T> {
    int compareTo(T o);
}

```

Usage : 

You implement Comparable in the class you want to sort and override the compareTo() method.

Example: 

```java
class Student implements Comparable<Student> {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public int compareTo(Student s) {
        return this.rollNo - s.rollNo;  // Sort by roll number
    }
}

```

# Comparator Interface


Comparator is an interface used to define custom ordering (external to the class). You use this when:
- You can’t modify the class.
- You want multiple sort logics.

```java
public interface Comparator<T> {
    int compare(T o1, T o2);
}

```

Usage: 

You create a separate class (or anonymous class/lambda) that implements Comparator.

```java
class Student {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);  // Sort by name
    }
}

void usage(){
  List<Student> list = new ArrayList<>();
  list.add(new Student(2, "Alice"));
  list.add(new Student(1, "Bob"));

  Collections.sort(list, new NameComparator());  // Sort by name

}

void usingLambdaExample(){
  Collections.sort(list, (s1, s2) -> s1.name.compareTo(s2.name));
}
```

## Key Differences Summary

| Feature            | Comparable                         | Comparator                              |
|--------------------|-------------------------------------|------------------------------------------|
| **Package**        | `java.lang`                        | `java.util`                              |
| **Method**         | `compareTo(T o)`                   | `compare(T o1, T o2)`                    |
| **Default/Custom** | Defines natural order              | Defines custom order                     |
| **Modified class?**| Yes (must implement interface)     | No need to modify target class           |
| **Usage**          | `Collections.sort(list)`           | `Collections.sort(list, comparator)`     |



# When to Use Comparable vs Comparator in Java

Both Comparable and Comparator are used for sorting objects in Java, but they are applied in different scenarios and offer different levels of flexibility.   
Let’s break down when you should use Comparable and when you should use Comparator.

## 1. Using Comparable

The Comparable interface is used when you want objects to have a natural ordering.   
It is implemented within the class itself, meaning that the class defines how its instances should be compared to one another.

- When to Use Comparable:
  - Default Sorting Logic: Use Comparable when the class has a natural order (i.e., there is a clear, default way the objects should be sorted).
    - Example: Sorting Person objects by their age or name, where the natural order is ascending.
  - Single Sorting Criterion: If the objects should only be sorted in one way (e.g., ascending by age, alphabetically by name), Comparable is a good choice because it is built into the class itself.
  - Custom Class Sorting: If you want your class to have an inherent sorting order, implement Comparable and override the compareTo() method.
    - For example, if you have a Person class, you might want the natural order to be by age.


Example: 
```java
class Person implements Comparable<Person> {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        // Compare by age (ascending order)
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + ": " + age;
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35)
        );

        // Sorting using natural order (compareTo)
        people.sort(null);  // sort() uses Comparable by default

        people.forEach(person -> System.out.println(person));
    }
}

```

In the Person class, we implement Comparable and override the compareTo() method to define the natural order by age.

The people.sort(null) uses the natural order (compareTo()) defined in the Person class.

## 2. Using Comparator


The Comparator interface is used when you need to define custom sorting logic outside of the class itself.   
A Comparator provides greater flexibility because it allows you to define multiple different ways to compare objects, rather than relying on a single compareTo() method.


- When to Use Comparator:
  - Custom Sorting Logic: 
    - If you want to sort objects in multiple ways, you should use Comparator. 
    - A Comparator allows you to define different sorting criteria (e.g., by age, name, etc.) without **modifying the object class itself**.
    - Example: You might want to sort Person objects by name or by age, depending on the scenario.
  - Different Sorting Criteria: 
    - If your class does not implement Comparable, or if the natural ordering is not suitable for the use case, Comparator is a better option.
  - External Sorting Logic: 
    - Use Comparator when sorting logic needs to be external to the class or when you want to provide multiple sorting strategies.
    - Example: Sorting Person objects by name, age, or salary as different sorting criteria.
  - Multiple Sorting Orders: 
    - A Comparator can be used for multiple sorting orders (e.g., first by age and then by name if ages are the same).

```java
import java.util.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ": " + age;
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35)
        );

        // Sorting by age using a custom comparator
        people.sort(Comparator.comparingInt(person -> person.age));

        System.out.println("Sorted by age:");
        people.forEach(person -> System.out.println(person));

        // Sorting by name using a custom comparator
        people.sort(Comparator.comparing(person -> person.name));

        System.out.println("\nSorted by name:");
        people.forEach(person -> System.out.println(person));

        // Sorting by age (descending) using a custom comparator
        people.sort(Comparator.comparingInt((Person person) -> person.age).reversed());

        System.out.println("\nSorted by age (descending):");
        people.forEach(person -> System.out.println(person));
    }
}

```



Summary
- **Comparable** is used for the default sorting logic and is implemented within the class itself. It’s suitable for simple use cases where you only need one way to compare objects.
- **Comparator** is more flexible, allows multiple sorting strategies, and is useful when you want to sort objects by various properties or use custom sorting logic without modifying the class.










































