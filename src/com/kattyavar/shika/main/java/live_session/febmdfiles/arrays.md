# Arrays in java

## Single-Dimensional Arrays in Java

A single-dimensional array in Java is a collection of elements of the same data type, stored in contiguous memory locations.  
It can be visualized as a list or a row of values, where each value can be accessed using an index.  
The index of the first element in an array is 0, and it increases sequentially for the subsequent elements.


### Characteristics
- Fixed size: Once an array is created, its size cannot be changed.
- Homogeneous: All elements in the array must be of the same data type (e.g., int[], String[]).
- Zero-based indexing: The first element has an index of 0.

Syntax

```java
dataType[] arrayName = new dataType[size];

```

Where 
- dataType: the type of elements in the array (e.g., int, String).
- arrayName: the name of the array.
- size: the number of elements in the array.


Example:

```java
public class SingleDimensionalArrayExample {
    public static void main(String[] args) {
        // Declare and initialize an array of integers
        int[] numbers = new int[5]; // Array of size 5

        // Assign values to the array elements
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        // Print array elements using a loop
        System.out.println("Elements of the array:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }
    }
}

```

in this example:
- The array numbers is of size 5.
- Values are assigned to each index from 0 to 4.
- A for loop is used to print the elements of the array.

This is a basic example of a single-dimensional array in Java.



## Multi-Dimensional Arrays in Java

A multi-dimensional array in Java is an array of arrays.  
It allows you to store more complex data structures by creating arrays that can hold other arrays as elements.  
A common example of a multi-dimensional array is a 2D array (array of arrays), but Java can support arrays with more than two dimensions (3D, 4D, etc.).

The most commonly used multi-dimensional array is the two-dimensional array, which can be visualized as a matrix (rows and columns).

### Characteristics
- A multi-dimensional array is an array where each element is itself an array.
- The number of dimensions refers to how many levels of arrays are contained within the main array.
- The size of each sub-array may vary (in a jagged array), but typically, all sub-arrays in a multi-dimensional array are of the same size.


Syntax for Multi-Dimensional Arrays:
```java
dataType[][] arrayName = new dataType[rows][columns];

```
Where:
- dataType: The type of data stored in the array (e.g., int, String).
- arrayName: The name of the array.
- rows: Number of rows (first dimension).
- columns: Number of columns (second dimension).

Example of a 2D Array (Matrix):

```java
public class MultiDimensionalArrayExample {
    public static void main(String[] args) {
        // Declare and initialize a 2D array (3 rows, 3 columns)
        int[][] matrix = new int[3][3];

        // Assign values to the 2D array
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;

        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;

        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;

        // Print the 2D array
        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}

```

### Jagged Arrays (Arrays with Uneven Dimensions):

A jagged array is an array of arrays where the sub-arrays can have different lengths. It's a more flexible form of multi-dimensional arrays.


Example of a Jagged Array:

```java
public class JaggedArrayExample {
    public static void main(String[] args) {
        // Declare and initialize a jagged array
        int[][] jaggedArray = new int[3][];
        
        // Initialize each sub-array with different sizes
        jaggedArray[0] = new int[2];  // 2 elements
        jaggedArray[1] = new int[3];  // 3 elements
        jaggedArray[2] = new int[1];  // 1 element
        
        // Assign values to the jagged array
        jaggedArray[0][0] = 1;
        jaggedArray[0][1] = 2;
        
        jaggedArray[1][0] = 3;
        jaggedArray[1][1] = 4;
        jaggedArray[1][2] = 5;
        
        jaggedArray[2][0] = 6;
        
        // Print the jagged array
        System.out.println("Jagged Array:");
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}

```

- The jaggedArray has 3 rows, but each row has a different number of elements.
- The first row has 2 elements, the second row has 3, and the third row has only 1 element.

### Summary:
- 2D arrays are most common and represent a matrix-like structure (rows and columns).
- Jagged arrays offer flexibility in having rows with different lengths.
- Multi-dimensional arrays allow for representing more complex data structures in Java.


## Array of Objects in Java
In Java, you can also create an array of objects, which allows you to store multiple objects of the same class in a single array.   
An array of objects can be used to hold references to objects of a class.  
Just like primitive data types, arrays in Java can store objects, but instead of storing the actual object, the array holds references (or pointers) to those objects.

Example:

```java
public class Book {
    String title;
    String author;

    // Constructor to initialize the Book object
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Method to display book details
    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}


public class ArrayOfObjectsExample {
  public static void main(String[] args) {
    // Create an array of Book objects
    Book[] books = new Book[3];  // Array of 3 Book objects

    // Initialize the objects in the array
    books[0] = new Book("The Catcher in the Rye", "J.D. Salinger");
    books[1] = new Book("To Kill a Mockingbird", "Harper Lee");
    books[2] = new Book("1984", "George Orwell");

    // Display information about each book using a loop
    for (int i = 0; i < books.length; i++) {
      books[i].displayInfo();  // Call the displayInfo method of each Book object
    }
  }
}

```

## Important Notes:
- Array of References: The array itself holds references (not the actual object) to the Book objects in memory. When you access books[0], you're accessing the reference to the first Book object, not the object directly.
- Memory Allocation: The array of objects is initially allocated with null values, and each element needs to be initialized with an actual object (like new Book()).



## Enhanced For Loop with Arrays in Java

The enhanced for loop (also called the "for-each" loop) in Java provides a simplified syntax to iterate through elements of an array or a collection.  
It is particularly useful when you don't need to know the index of the element and just want to process each element in the array.

The enhanced for loop helps make your code more readable and reduces the chance of making errors (such as accessing invalid indices).  
It’s often used when you want to iterate through all the elements of an array or collection without manually managing the index.

Syntax of the Enhanced For Loop:

```java
for (dataType element : arrayName) {
    // Code to process the element
}

```

Where:
- dataType: The type of the array elements.
- element: The variable that holds the value of the current array element in each iteration.
- arrayName: The name of the array you want to iterate over.

Example: Using the Enhanced For Loop with Arrays

```java
public class EnhancedForLoopExample {
    public static void main(String[] args) {
        // Create an array of integers
        int[] numbers = {10, 20, 30, 40, 50};

        // Using the enhanced for loop to print all elements in the array
        System.out.println("Array elements:");
        for (int num : numbers) {
            System.out.println(num);  // num is the current element of the array
        }
    }
}

```

Example: Using the Enhanced For Loop with Arrays of Objects

```java
public class Book {
    String title;
    String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Method to display book info
    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

public class EnhancedForLoopWithObjects {
  public static void main(String[] args) {
    // Create an array of Book objects
    Book[] books = new Book[3];

    // Initialize the Book objects
    books[0] = new Book("The Catcher in the Rye", "J.D. Salinger");
    books[1] = new Book("To Kill a Mockingbird", "Harper Lee");
    books[2] = new Book("1984", "George Orwell");

    // Use the enhanced for loop to print details of each book
    System.out.println("Books in the collection:");
    for (Book book : books) {
      book.displayInfo();  // Call the displayInfo method for each book
    }
  }
}

```

### Benefits of Using the Enhanced For Loop:
- Simpler Syntax: The enhanced for loop automatically handles the iteration through the array elements, removing the need for an explicit index variable.
- Prevents Index Errors: You don’t need to worry about accessing invalid indices, reducing the risk of ArrayIndexOutOfBoundsException.
- Improved Readability: The enhanced for loop is cleaner and easier to read, making the code more understandable.


### Limitations of the Enhanced For Loop:
- No Access to Index: You cannot access the index of the current element directly, which may be necessary in some cases (e.g., modifying elements based on their index).
- Only Read-Only Access: The enhanced for loop is designed for reading the elements. If you need to modify elements in the array, you cannot do so directly inside the loop (you’ll need to use a regular for loop for that).

Example of modifying elements with a regular for loop:

```java
for (int i = 0; i < numbers.length; i++) {
    numbers[i] = numbers[i] * 2;  // Modify each element
}

```


## Summary:
- The enhanced for loop simplifies array iteration when you only need to access the elements, not their indices.
- It improves code readability and reduces the risk of errors.
- It is useful for reading through elements but is not suitable when you need to modify elements or work with the indices.


