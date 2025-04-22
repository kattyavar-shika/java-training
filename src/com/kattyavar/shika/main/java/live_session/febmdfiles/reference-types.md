
# 1. Strong Reference (Default Reference)
A strong reference is the most common type of reference in Java.   
If you create a reference to an object, it is a strong reference by default.  
As long as there is a strong reference to an object, the garbage collector will not reclaim the object's memory, even if it is no longer needed.

Key Points:
- Strong references are the default reference type.
- The object is not eligible for garbage collection as long as it has a strong reference.
- As soon as there are no more strong references to an object, it becomes eligible for garbage collection.

```java
public class StrongReferenceExample {
    public static void main(String[] args) {
        // Strong reference to an object
        Object obj = new Object();
        
        System.out.println("Object is created and referenced strongly.");

        // obj will be strongly referenced as long as it exists in this scope.
        
        // Once 'obj' goes out of scope, it can be garbage collected
    }
}

```

# 2. Weak Reference

A weak reference in Java is a reference that does not prevent an object from being garbage collected.   
When an object is only weakly reachable (i.e., it is only referenced by weak references), it becomes eligible for garbage collection.   
This is useful when you want to reference an object but allow it to be collected when memory is needed.


A weak reference allows an object to be garbage collected as soon as there are no strong references to it. Here's how you can use WeakReference in Java:

```java
import java.lang.ref.WeakReference;

public class WeakReferenceExample {
    public static void main(String[] args) {
        // Create a new object and wrap it in a weak reference
        Object obj = new Object(); // Strong reference
        WeakReference<Object> weakRef = new WeakReference<>(obj);
        
        System.out.println("Object is created and weakly referenced.");
        System.out.println("Weak reference: " + weakRef.get());

        // Now, removing the strong reference
        obj = null;

        // After this point, the object is eligible for garbage collection
        System.gc(); // Suggest the JVM to run GC (this is just a hint)

        // The object may have been collected by the GC
        System.out.println("Weak reference after GC: " + weakRef.get()); // Should be null if GC collected it
    }
}

```

- obj is initially a strong reference.
- weakRef is a weak reference to the same object.
- After setting obj = null, the object becomes eligible for garbage collection.
- After calling System.gc(), we check whether the object is collected. If the object has been collected, weakRef.get() will return null.



# 3. Soft Reference

A soft reference in Java is similar to a weak reference, but with the key difference that the garbage collector is less aggressive in collecting objects that are softly referenced.   
Soft references are useful when you want to keep an object in memory for as long as possible but are willing to allow it to be garbage collected if the JVM is running low on memory.

Java provides the SoftReference class to create soft references.

Key Points:
- Soft references are collected by the garbage collector only when the JVM is low on memory.
- Soft references are typically used for caching, where objects should remain in memory as long as there is sufficient memory available.
- Unlike weak references, soft references are not collected as aggressively.


A soft reference is similar to a weak reference, but it is less eager to be collected. It will only be collected by the garbage collector if the JVM is running low on memory.

```java
import java.lang.ref.SoftReference;

public class SoftReferenceExample {
    public static void main(String[] args) {
        // Create a new object and wrap it in a soft reference
        Object obj = new Object(); // Strong reference
        SoftReference<Object> softRef = new SoftReference<>(obj);
        
        System.out.println("Object is created and softly referenced.");
        System.out.println("Soft reference: " + softRef.get());

        // Now, remove the strong reference
        obj = null;

        // The object is still strongly referenced by softRef, and it won't be collected unless memory is low
        System.gc(); // Suggest the JVM to run GC (this is just a hint)

        // At this point, the object is still likely to be in memory.
        System.out.println("Soft reference after GC: " + softRef.get()); // Should not be null unless memory is low
    }
}

```


# 4. Phantom Reference

A phantom reference in Java is the weakest reference type. Objects referenced only by phantom references are ready for garbage collection but have not yet been collected. Phantom references are typically used when you need to know when an object is about to be garbage collected so that you can perform some cleanup (e.g., releasing resources or finalizing operations).

Unlike weak and soft references, phantom references do not provide a way to access the object itself. Instead, phantom references are used in conjunction with a ReferenceQueue to receive notification when an object has been finalized and is ready to be garbage collected.

Key Points:
- Phantom references do not allow access to the object.
- The object is eligible for garbage collection after the finalize method is called.
- Phantom references are mainly used to clean up native resources (e.g., closing file handles or freeing memory in native code).


A phantom reference is the weakest of all references and is used for cleanup activities after the object is garbage collected. You can't access the object through a phantom reference, but you can use it in conjunction with a ReferenceQueue to detect when an object is about to be finalized and garbage collected.





```java
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceExample {
    public static void main(String[] args) {
        // Create a ReferenceQueue to hold objects that are ready for garbage collection
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        
        // Create a new object and wrap it in a phantom reference
        Object obj = new Object();
        PhantomReference<Object> phantomRef = new PhantomReference<>(obj, queue);
        
        System.out.println("Object is created and phantom referenced.");
        
        // The object is eligible for garbage collection, but phantomRef cannot access the object directly
        
        // Remove the strong reference to the object
        obj = null;
        
        // Suggest the JVM to run garbage collection
        System.gc();
        
        // Check if the object has been enqueued for garbage collection
        try {
            // We can retrieve the object from the ReferenceQueue after it has been finalized
            Object collectedObj = queue.poll(); // This will return null if no object is finalized yet
            if (collectedObj == null) {
                System.out.println("Object has not yet been garbage collected.");
            } else {
                System.out.println("Object has been garbage collected.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```












