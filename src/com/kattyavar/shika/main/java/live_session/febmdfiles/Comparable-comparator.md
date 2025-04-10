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






























