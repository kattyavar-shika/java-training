package com.kattyavar.shika.main.java.live_session.aug30;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapExample {

  static void hashMapExample() {
    class Student {
      String name;
      Integer rollNumber;

      public Student(String name, Integer rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(rollNumber, student.rollNumber);
      }

      @Override
      public int hashCode() {
        return Objects.hash(name, rollNumber);
      }

      @Override
      public String toString() {
        return "Student{" +
          "name='" + name + '\'' +
          ", rollNumber=" + rollNumber +
          '}';
      }
    }

    Map<Student, String> map = new HashMap<>();
    map.put(new Student("patil", 11), "Smart");
    map.put(new Student("patil", 11), "Smart");
    map.put(new Student("Amol", 12), "Smart");

    System.out.println(map);

  }

  static void bucketIndexUsageExample() {
    letFindOutHashBucketIndex("amol", 16);
    letFindOutHashBucketIndex("patil", 16);
    letFindOutHashBucketIndex("prasad", 160);
    letFindOutHashBucketIndex("nilesh", 160);
    //Now let try with custom object key.

    letFindOutHashBucketIndex(new HashMapHashCodeExampleWithConstantHashCode("amol"), 16);
    letFindOutHashBucketIndex(new HashMapHashCodeExampleWithConstantHashCode("patil"), 16);
    letFindOutHashBucketIndex(new HashMapHashCodeExampleWithConstantHashCode("prasad"), 16);
    letFindOutHashBucketIndex(new HashMapHashCodeExampleWithConstantHashCode("nilesh"), 16);
    letFindOutHashBucketIndex(new HashMapHashCodeExampleWithConstantHashCode("nilesh"), 16);
    letFindOutHashBucketIndex(new HashMapHashCodeExampleWithConstantHashCode("nilesh"), 16);
    letFindOutHashBucketIndex(new HashMapHashCodeExampleWithConstantHashCode("nilesh"), 16);
    letFindOutHashBucketIndex(new HashMapHashCodeExampleWithConstantHashCode("nilesh"), 16);

  }

  static void hashMapFewMoreExample() {


    Map<String, String> map = new HashMap<>();
    map.put("step1", null);

    System.out.println(" Map content  :" + map);

    //Now let put diff value using the same key...

    map.put("step1", " new values");
    System.out.println(" Map content  :" + map);


    map.put("new key step1", " new values");
    System.out.println(" Map content  :" + map);

    map.containsKey("step1");


    map.remove("step1");
    System.out.println("After delete");
    System.out.println(" Map content  :" + map);
  }

  public static void main(String[] args) throws InterruptedException {


    Map<String, String> map = new ConcurrentHashMap<>();

    map.put("step1", null);

    System.out.println("Map content = " + map);

    map.putIfAbsent("step1", "Will this values will be udapted?");
    System.out.println("Map content = " + map);

    System.out.println("About to sleep  process id : " + ProcessHandle.current().pid());

    Thread.sleep(9000000000L);

    List<String> abc;


  }

  static void letFindOutHashBucketIndex(Object key, int sizeOfHashArray) {

    int h = key.hashCode();
    int hash = h ^ h >>> 16;

    int bucketIndex = ((sizeOfHashArray - 1) & hash);
    System.out.println(" Key = " + key + " : bucket Index = " + bucketIndex);

  }

}

class HashMapHashCodeExampleWithConstantHashCode {
  String name;

  public HashMapHashCodeExampleWithConstantHashCode(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    return 11;
  }

  @Override
  public String toString() {
    return "HashMapHashCodeExampleWithConstantHashCode{" +
      "name='" + name + '\'' +
      '}';
  }
}
