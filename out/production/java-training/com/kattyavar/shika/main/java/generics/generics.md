Note: Generic can not work with primitive data type.
if you have primitive type then use respective wrapper class

| Primitive | Wrapper Class |
|-----------|---------------|
| int       | Integer       |
| char      | Character     |
| byte      | Byte          | 
| short     | Short         |
| long      | Long          |
| float     | Float         |
| double    | Double        |
| boolean   | Boolean       |

### 1. **Basic Generic Class**

```java
class ClassName<T> {
  // This class can accept any type for T.

}
```

//`ClassName<T extends Number>` restricts `T` to be a subclass of `Number` or `Number` itself.

### 2. **Generic Class with an Upper Bound**

```java
class ClassName<T extends Number> {
}
```

### 3. **Generic Class with Multiple Type Parameters**

```java
//`ClassName<T, V>` is a generic class with two type parameters. `T` and `V` can be different types or Same,
class ClassName<T, V> {
}
```

### 4. **Generic Class with an Interface Bound**

```java
// T can be any type that implements InterfaceNameType
class ClassName<T extends InterfaceNameType> {

}
```

### 5. **Multiple Bounds**: If you need to specify both a superclass and an interface, you can combine bounds with &:

  ```java
  class ClassName<T extends SuperClass & SomeInterface> {
  // T must be a subclass of SuperClass and must implement SomeInterface
}
  ```

### 5. **Self-referential generics**:

  ```java
//This is a generic pattern in Java where a type parameter extends its own class, allowing for fluent method chaining and type safety. 
//It ensures that methods return the correct subclass type, facilitating more readable and maintainable code.
class BaseBuilder<T extends BaseBuilder<T>> {

}
  ```

### 6. **Generics Method**

method to accept any type of object and print it out

  ```java
  private <T> void printAnyThing(T anyDataType) {
  System.out.println(anyDataType);
}

private void usage() {
  printAnyThing("Test");
  printAnyThing(123);
  printAnyThing(new Customer());
}

```

method to accept any two type of object and print it out

  ```java
  private <T, V> void printAnyThing(T anyDataType1, V anyDataType2) {
  System.out.println(anyDataType1);
  System.out.println(anyDataType2);
}

```
method to accept any type of object and return the same type
  ```java
  private <T> T printAnyThing(T anyDataType1) {
  return anyDataType1;
}
```

Generic Constructors

```java
public class ExampleClass<T> {
    
    private T value;
   private String description;


  // Generic Constructor
    public <U> ExampleClass(U value) {
        // Type U is a parameter for this constructor only. 
      // Here you can your custom logic if you want...
      this.description = "Descriptions " + value.toString();
        System.out.println("Value: " + value);
    }
    public String getDescription(){
      return this.description;
    }
}

```

Let talk about wildcard

why we need wildcard

  ```java
  import java.util.ArrayList;

//This will not work
private void takeInputAsList(List<Object> list) {
  // ... some custom logic
}
//let change it to correct way
// ? : we dont know the type. but keep in mind you can add to this list.
  private void takeInputAsList(List<?> list) {
    // ... some custom logic
  }
  
  //bounded example this will accept only sub class of Number.
  private void takeInputAsList(List<? extends  Number> list) {
    // ... some custom logic
  }

  //bounded example this will accept only parent class of Number.
  private void takeInputAsList(List<? super  Number> list) {
    // ... some custom logic
  }



  void usage() {
  List<String> stringList = new ArrayList<>();
  stringList.add("Str1");
  stringList.add("Str2");
  takeInputAsList(stringList); // This will not work... 
  /**
   * Technically String is subclass of Object. but List<String > is not subclass List<Object>
   * so this will not work. where wildcard from generic come into picture.
   */
}

```

Type Erasure is how Java handles generics behind the scenes. 
When you write code using generics, like List<String>, Java removes the specific type information during compilation. 
This means that in the compiled code, it just looks like a regular List without any specific type details. 
This approach ensures that Java code using generics can work with older code that doesn't use generics, keeping everything compatible.


Generic Type Information Removal:

List<String> stringList = new ArrayList<>();
compile to
List stringList = new ArrayList();

Type Bounds Replacement method:
public <T extends Number> void process(T value) {
}
compile to
public void process(Number value) {
}

Type bound replacement class level :
public class NumericBox<T extends Number> {
private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

after compile
public class NumericBox {
private Number value;

    public void setValue(Number value) {
        this.value = value;
    }

    public Number getValue() {
        return value;
    }
}

if we have any bound part other wise Object is default one.