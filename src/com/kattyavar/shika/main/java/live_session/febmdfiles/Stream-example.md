# Stream examples 


## Filter Even Numbers

Data:
You have a list of integers:
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Task:
Write a stream-based solution to filter out only the even numbers from the list.

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(num -> num % 2 == 0)
                                           .collect(Collectors.toList());
        
        System.out.println(evenNumbers); // Output: [2, 4, 6, 8, 10]
    }
}

```

## Square of Odd Numbers

Data:
You have a list of integers:
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Task:
Write a stream-based solution to find the square of only the odd numbers from the list.

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        List<Integer> oddSquares = numbers.stream()
                                          .filter(num -> num % 2 != 0)
                                          .map(num -> num * num)
                                          .collect(Collectors.toList());
        
        System.out.println(oddSquares); // Output: [1, 9, 25, 49, 81]
    }
}

```

## Concatenate All Strings with a Specific Length

Data:
You have a list of strings:
["apple", "banana", "kiwi", "pear", "orange", "melon"]

Task:
Write a stream-based solution to concatenate all the strings that have a length greater than 4.

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "kiwi", "pear", "orange", "melon");
        
        String concatenatedFruits = fruits.stream()
                                          .filter(fruit -> fruit.length() > 4)
                                          .collect(Collectors.joining(", "));
        
        System.out.println(concatenatedFruits); // Output: "apple, banana, orange, melon"
    }
}

```

##  Find the Maximum Element in a List

Data:
You have a list of integers:
[34, 12, 98, 67, 23, 12]

Task:
Write a stream-based solution to find the maximum element in the list.

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(34, 12, 98, 67, 23, 12);
        
        Optional<Integer> maxNumber = numbers.stream()
                                             .max(Integer::compareTo);
        //same as       .max((a, b) -> a.compareTo(b));


      maxNumber.ifPresent(System.out::println); // Output: 98
    }
}

```

##  Count the Frequency of Each Character in a String

Data:
You have a string:
"programming"

Task:
Write a stream-based solution to count the frequency of each character in the string.

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        String str = "programming";
        
        Map<Character, Long> frequencyMap = str.chars() // IntStream of characters
                                               .mapToObj(c -> (char) c) // Convert to Character stream
                                               .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
        System.out.println(frequencyMap); // Output: {g=2, r=2, o=1, p=1, a=1, m=2, i=1, n=1}
    }
}

```

or You can write something like it. 

```java
public class StreamExample {
    public static void main(String[] args) {
        String str = "programming";

      Map<Character, Long> frequencyMap = str.chars()
        .peek(x -> System.out.println(x)) // Optionally print each character's ASCII value
        .mapToObj(c -> (char) c) // Convert each int to a char
        .collect(Collectors.toMap(
          c -> c, // Key: the character itself
          c -> 1L, // Value: initialize each character with a count of 1
          (count1, count2) -> count1 + count2 // If the character already exists, sum the counts
        ));
        
        System.out.println(frequencyMap); // Output: {g=2, r=2, o=1, p=1, a=1, m=2, i=1, n=1}
    }
}
```

## Sort a List of Strings by Length

Data:
You have a list of strings:
["apple", "banana", "kiwi", "pear", "grapefruit", "orange"]

Task:
Write a stream-based solution to sort the strings by length in ascending order.

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "kiwi", "pear", "grapefruit", "orange");
        
        List<String> sortedByLength = fruits.stream()
                                           .sorted(Comparator.comparingInt(String::length))
          // or     .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))

          .collect(Collectors.toList());
        
        System.out.println(sortedByLength); // Output: [kiwi, pear, apple, orange, banana, grapefruit]
    }
}

```

## Find First Element That Is Divisible by 3

Data:
You have a list of integers:
[5, 8, 12, 19, 30, 6]

Task:
Write a stream-based solution to find the first element in the list that is divisible by 3.

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 8, 12, 19, 30, 6);
        
        Optional<Integer> firstDivisibleBy3 = numbers.stream()
                                                    .filter(num -> num % 3 == 0)
                                                    .findFirst();
        
        firstDivisibleBy3.ifPresent(System.out::println); // Output: 12
    }
}

```

## Group Strings by Their Length

Data:
You have a list of strings:
["apple", "banana", "kiwi", "pear", "orange", "melon"]

Task:
Write a stream-based solution to group the strings by their length.

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "kiwi", "pear", "orange", "melon");
        
        Map<Integer, List<String>> groupedByLength = fruits.stream()
                                                           .collect(Collectors.groupingBy(String::length));
        
        System.out.println(groupedByLength); 
        // Output: {4=[kiwi, pear], 5=[apple], 6=[banana, orange, melon]}
    }
}

```

## Sum of Positive Numbers

Data:
You have a list of integers:
[-1, 2, 3, -4, 5, 6]

Task:
Write a stream-based solution to calculate the sum of all positive numbers in the list.

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-1, 2, 3, -4, 5, 6);
        
        int sumOfPositiveNumbers = numbers.stream()
                                          .filter(num -> num > 0)
                                          .mapToInt(Integer::intValue)
                                          .sum();
        
        System.out.println(sumOfPositiveNumbers); // Output: 16
    }
}

```

Or we can use reduce 

```java
List<Integer> numbers = Arrays.asList(-1, 2, 3, -4, 5, 6);

int sumOfPositiveNumbers = numbers.stream()
                                  .filter(num -> num > 0)
                                  .reduce(0, (a, b) -> a + b);  // Summing manually

System.out.println(sumOfPositiveNumbers);

```

## Check if All Numbers Are Positive

Data:
You have a list of integers:
[1, 2, 3, 4, 5]

Task:
Write a stream-based solution to check if all numbers in the list are positive.

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        boolean allPositive = numbers.stream()
                                     .allMatch(num -> num > 0);
        
        System.out.println(allPositive); // Output: true
    }
}

```

## Concatenate Strings into a Single String

Data:
You have a list of strings:
["Java", "is", "awesome"]

Task:
Write a stream-based solution to concatenate the strings in the list into a single string, separated by a space.

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "is", "awesome");
        
        String result = words.stream()
                             .collect(Collectors.joining(" "));
        
        System.out.println(result); // Output: "Java is awesome"
    }
}

```

## Remove Duplicates from a List

Data:
You have a list of integers with duplicates:
[1, 2, 3, 1, 2, 4, 5, 6, 3]

Task:
Write a stream-based solution to remove the duplicates from the list.

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 1, 2, 4, 5, 6, 3);
        
        List<Integer> distinctNumbers = numbers.stream()
                                               .distinct()
                                               .collect(Collectors.toList());
        
        System.out.println(distinctNumbers); // Output: [1, 2, 3, 4, 5, 6]
      
      // or you can use below 

      /*
      List<Integer> numbers = Arrays.asList(1, 2, 3, 1, 2, 4, 5, 6, 3);

      Set<Integer> distinctNumbersSet = numbers.stream()
        .collect(Collectors.toSet());  // Collects to Set

      System.out.println(distinctNumbersSet);
      
       */
      
      // Or you can use this.. 
      Set<Integer> distinctNumbersSet = new HashSet<>(numbers);

    }
}

```

## Flatten a List of Lists

Data:
You have a list of lists of integers:
[[1, 2, 3], [4, 5], [6, 7]]

Task:
Write a stream-based solution to flatten the list of lists into a single list of integers.

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(6, 7)
        );
        
        List<Integer> flattenedList = listOfLists.stream()
                                                 .flatMap(List::stream)
                                                 .collect(Collectors.toList());
        
        System.out.println(flattenedList); // Output: [1, 2, 3, 4, 5, 6, 7]
    }
}

```

##  Group People by Age
Data:
You have a list of Person objects as described earlier.

Task:
Write a stream-based solution to group people by their age.

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("John", 25),
            new Person("Alice", 22),
            new Person("Bob", 25),
            new Person("Eve", 22)
        );
        
        Map<Integer, List<Person>> groupedByAge = people.stream()
                                                        .collect(Collectors.groupingBy(Person::getAge));
        
        groupedByAge.forEach((age, peopleList) -> {
            System.out.println(age + ": " + peopleList);
        });
    }
}

```