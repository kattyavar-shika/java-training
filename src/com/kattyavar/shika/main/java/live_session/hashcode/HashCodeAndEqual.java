package com.kattyavar.shika.main.java.live_session.hashcode;

import java.util.HashMap;
import java.util.Map;

public class HashCodeAndEqual {

    public static void main(String[] args) {
        String s1 = "Amol";
        String s2 = "Amol";

        String s3 = new String("Amol");

        if (s1 == s2) {
            System.out.println("Yes s1 and s2 are same");
        }

        if (s1 == s3) {
            System.out.println("s1 and s3 are same...");
        } else {
            System.out.println("Why they are not same...");
        }

        if (s1.equals(s3)) {
            System.out.println("Yes using equals there are same.. how...");
        }

        Student obj1 = new Student("Test", 1);
        Student obj2 = new Student("Test", 1);

        if(obj1 == obj2) {
            System.out.println("Yes both are same... using obj1 == obj2");
        }

        if(obj1.equals(obj2)) {
            System.out.println("Yes both are same using .equal method...");
        } else {
            System.out.println("Both are not same using equals method...");
        }

        Demo d1 = new Demo();
        Demo d2 = new Demo();

        d1.equals(d2);

    }


    static void hashCodeMissUse() {
        Map<Student, String> map = new HashMap<>();

        Student obj1 = new Student("Test", 1);
        Student obj2 = new Student("Test", 1);

        System.out.println("Lets have look at the size of hashmap....");
        System.out.println(map.size());
        map.put(obj1, "s1");
        System.out.println("after adding 1 element hashmap size is " + map.size());
        map.put(obj2, "s1");
        System.out.println("After adding the same element key let have look at ths size of map is " + map.size());


        //now let find out the bucket index ...

        System.out.println("obj1 hash code is + " + obj1.hashCode());
        System.out.println("obj2 hash code is + " + obj2.hashCode());

        System.out.println("Lets apply the logic here as  (h = key.hashCode()) ^ h >>> 16 & 16");

        System.out.println("Obj1 bucket index as --> " + getBucketIndex(obj1.hashCode()));
        System.out.println("Obj2 bucket index as --> " + getBucketIndex(obj2.hashCode()));


    }

    static int getBucketIndex(int hashCode) {
        return (hashCode ^ hashCode >>> 16) & 15;
    }
}

class Student {
    String name;
    int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}

class Demo {

}
