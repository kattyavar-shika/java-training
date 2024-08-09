package com.kattyavar.shika.main.java.live_session.dummy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DummyNew {
  public static void main(String[] args) {

    System.out.println("In new demo...");

    College college1 = new College("MIT", 1);
    College college2 = new College("MIT2", 2);
    College college3 = new College("VIT", 3);
    College college4 = new College("Fergusson", 4);

    System.out.println("Let have a look at hashCode of college1  =" + college1.hashCode());
    System.out.println("Let have a look at hashCode of college12 =" + college2.hashCode());

    System.out.println("let have look at the object ");
    System.out.println("college1  =" + college1.toString());
    System.out.println("college2  =" + college2);

    if (college1.equals(college2)) {
      System.out.println("Both are same");
    } else {
      System.out.println("Both are not same");
    }

    Map<String, String> stringMap = new HashMap<>();


    String amolKey = "Amol";
    String aKey = "A";

    stringMap.put(amolKey, "Deshpande");
    stringMap.put(aKey, "Patil");
    stringMap.put("Amol", "Deshpande new");
    stringMap.put("A", "Patil new");
    stringMap.put("A1", "Patil new");
    System.out.println("let have look at how many element we have in map =" + stringMap.size());

    Map<College, String> collegeStringMap = new HashMap<>();

    collegeStringMap.put(college4, "Let give this updated value");
    collegeStringMap.put(college1, "new value");
    collegeStringMap.put(college2, "new value");
    collegeStringMap.put(college3, "Let give this updated value");


    System.out.println("Let have look at how many element do we have have in college hashMap " + collegeStringMap.size());



  }
}


class College {
  private String name;
  private int collegeCode;
  private String principalName;

  public College(String name, int collegeCode) {
    this.name = name;
    this.collegeCode = collegeCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    College college = (College) o;
    return collegeCode == college.collegeCode && Objects.equals(name, college.name) && Objects.equals(principalName, college.principalName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, collegeCode, principalName);
  }

  void whatIsTheIssue (){
    /**
     * if you say from equal you will always return true and you will return constant hashCode ex 900 then following case
     * ob1.equals(obj2) === always true even obj1 and obj2 values are diff...
     * ob1.hashCode and obj2.hashCode is same due to this hash collision occurs. then hashMap is trying to check
     * object value if its same then it just replace / override the value only.
     */
  }
}


class Test {
  private String name;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Test test)) return false;
    return Objects.equals(name, test.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }
}


class Student {
  private Integer rollNumber;
  private String name;
  private String address;
  private String fatherName;
  private String lastName;
  private String motherName;
  private String bloadGroup;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return Objects.equals(rollNumber, student.rollNumber) && Objects.equals(name, student.name) && Objects.equals(address, student.address) && Objects.equals(fatherName, student.fatherName) && Objects.equals(lastName, student.lastName) && Objects.equals(motherName, student.motherName) && Objects.equals(bloadGroup, student.bloadGroup);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(rollNumber);
  }
}




