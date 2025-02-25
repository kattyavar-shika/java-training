# everything is "call by value"

In Java, everything is "call by value", but it can be a bit tricky to understand because Java handles objects and primitives differently.

## Here's the key distinction:

- Primitive Types: Java passes by value. When you pass a primitive type (e.g., int, float, char), the method gets a copy of the value. Any changes made to that copy do not affect the original value outside the method.
- Object References: Java still passes by value but the value passed is a reference to the object. This means the method gets a copy of the reference (memory address) pointing to the same object. You can modify the object’s state inside the method, but if you change the reference (i.e., make it point to a new object), it won’t affect the original reference outside the method.



Example 

```java
public class CallByValueExample {
    
    static void modifyPrimitive(int x) {
        x = 10; // Modify the local copy of x
    }

    static void modifyObject(MyClass obj) {
        obj.value = 20;  // Modify the state of the object
        obj = new MyClass();  // Reassign the reference, won't affect original
        obj.value = 30;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println("Before modifyPrimitive: " + num);
        modifyPrimitive(num);
        System.out.println("After modifyPrimitive: " + num);  // num will remain 5

        MyClass myObject = new MyClass();
        myObject.value = 10;
        System.out.println("Before modifyObject: " + myObject.value);
        modifyObject(myObject);
        System.out.println("After modifyObject: " + myObject.value);  // myObject.value will be 20
    }
}

class MyClass {
    int value;
}

```

Output: 

```java
Before modifyPrimitive: 5
After modifyPrimitive: 5
Before modifyObject: 10
After modifyObject: 20

```

# Conclusion: 

Java always passes arguments by value.  
The confusion arises because, for objects, the value being passed is the reference (i.e., memory address), 
so it may seem like "call by reference," but it's still a copy of the reference.  
Changes to the object's fields persist, but reassigning the reference inside the method doesn't change the original reference.



