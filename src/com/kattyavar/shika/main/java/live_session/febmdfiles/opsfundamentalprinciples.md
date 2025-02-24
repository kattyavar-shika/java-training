# Object Oriented programing (OOP) fundamental principles:

Java, Object-Oriented Programming (OOP) is based on four fundamental principles:

## Encapsulation
- Encapsulation means hiding the internal details of an object and only exposing what is necessary.
- This is achieved using private fields and public getter and setter methods.


```java
class Person {
    private String name; // Private field (hidden from outside)

    // Getter method
    public String getName() {
        return name;
    }

    // Setter method
    public void setName(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("prasad"); // Setting value using setter
        System.out.println(p.getName()); // Getting value using getter
    }
}

```

## Inheritance

- Inheritance allows a child class (subclass) to inherit fields and methods from a parent class (superclass).
- This promotes code reuse.

```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal { // Dog class inherits from Animal
    void bark() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.makeSound(); // Inherited method
        d.bark();      // Dog's own method
    }
}

```

## Polymorphism
- Polymorphism allows one method to take different forms.
- It can be achieved through Method Overloading (Compile-time polymorphism) and Method Overriding (Runtime polymorphism).

Example of Method Overloading (Compile-time polymorphism):

```java
class MathOperations {
    // Same method name, different parameters
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        MathOperations obj = new MathOperations();
        System.out.println(obj.add(5, 10)); // Calls int version
        System.out.println(obj.add(5.5, 2.5)); // Calls double version
    }
}

```

Example of Method Overriding (Runtime polymorphism):

```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() { // Overriding method
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Dog(); // Parent reference, child object
        myAnimal.makeSound(); // Calls Dog's overridden method
    }
}

```

## Abstraction
- Abstraction hides complex implementation details and only shows the essential features.
- It is achieved using abstract classes or interfaces.

Example using Abstract Class:

```java
abstract class Vehicle {
    abstract void start(); // Abstract method (no body)

    void stop() { // Concrete method
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car starts with a key");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.start();
        myCar.stop();
    }
}

```

Example using Interface:

```java
interface Animal {
    void makeSound(); // Abstract method (no implementation)
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myCat = new Cat();
        myCat.makeSound();
    }
}

```


## Summary Table

| OOP Principle  | Description  | Achieved By  |
|---------------|-------------|--------------|
| **Encapsulation** | Hides data and provides controlled access | Private fields, public getters & setters |
| **Inheritance** | Child class inherits from parent class | `extends` keyword |
| **Polymorphism** | One method, different implementations | Method Overloading & Overriding |
| **Abstraction** | Hides implementation details | Abstract classes & Interfaces |


## Association (General Relationship)
- Definition: A general relationship between two objects where one object can use another.
- Key Feature: There is no ownership; both objects can exist independently.
- Example: A Student and a Teacher have an association—students are taught by teachers, but both can exist separately.

```java
class Student {
    private String name;

    Student(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Student: " + name);
    }
}

class Teacher {
    private String name;

    Teacher(String name) {
        this.name = name;
    }

    void teach(Student student) {
        System.out.println(name + " is teaching " + student.name);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Alice");
        Teacher t = new Teacher("Mr. Smith");
        t.teach(s);
    }
}

```

Implication: Objects are related but do not depend on each other.

## Aggregation (Weak Ownership)
- Definition: A "Has-A" relationship where one object contains another, but the contained object can exist independently.
- Key Feature: It represents a weak form of ownership. If the container object is destroyed, the contained object can still exist.

Example: A Library has multiple Books, but if the library closes, the books can still exist elsewhere.

```java
import java.util.List;
import java.util.ArrayList;

class Book {
    String title;

    Book(String title) {
        this.title = title;
    }

    void display() {
        System.out.println("Book: " + title);
    }
}

class Library {
    private List<Book> books;

    Library() {
        books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void showBooks() {
        for (Book b : books) {
            b.display();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("Java Programming");
        Book book2 = new Book("Data Structures");

        library.addBook(book1);
        library.addBook(book2);
        library.showBooks();
    }
}

```

Implication: The Library contains Books, but if the Library is deleted, the Books still exist.

## Composition (Strong Ownership)
- Definition: A "Has-A" relationship where one object contains another, but the contained object cannot exist without the container.
- Key Feature: It represents a strong form of ownership. If the container is destroyed, the contained object is also destroyed.
- Example: A Car has an Engine. If the Car is destroyed, the Engine is also gone.

```java
class Engine {
    Engine() {
        System.out.println("Engine created.");
    }

    void start() {
        System.out.println("Engine is starting...");
    }
}

class Car {
    private Engine engine;

    Car() {
        this.engine = new Engine(); // Strong ownership: Car creates and owns the Engine
    }

    void startCar() {
        engine.start();
        System.out.println("Car is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.startCar();
    }
}

```

Implication: The Car owns the Engine, and if the Car is destroyed, the Engine is also gone.

## Which One Should You Use?
- Use Association when objects are related but independent.
- Use Aggregation when one object "has" another, but they can live separately.
- Use Composition when one object "has" another, and they must exist together.



## 🔑 Key Difference: Association vs. Aggregation vs. Composition

| Feature        | Association (General Relationship)  | Aggregation (Weak Ownership) | Composition (Strong Ownership)  |
|---------------|---------------------------------|--------------------------------|--------------------------------|
| **Definition** | General relationship between objects | One object contains another (**Has-A**) | One object fully owns another (**Has-A**) |
| **Ownership**  | ❌ No ownership | ✅ Weak ownership | 🔒 Strong ownership |
| **Dependency** | Objects can exist independently | Objects can exist independently | Contained object **cannot exist without** the container |
| **Lifespan**   | Both objects are independent | Contained object is not dependent on the container | Contained object **dies** with the container |
| **Example**    | A `Teacher` teaches a `Student` | A `Library` has `Books` (Books exist even if Library is gone) | A `Car` has an `Engine` (If the Car is destroyed, the Engine is too) |
