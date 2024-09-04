package com.kattyavar.shika.main.java.live_session.sep4;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EnumMapExample {

  public static void main(String[] args) {

    GradeWithSalary dev1 = GradeWithSalary.DEVELOPER;

    GradeWithSalary dev2 = GradeWithSalary.DEVELOPER;

    System.out.println(" dev1 =" + dev1 + " hash code = " + dev1.hashCode());
    System.out.println(" dev2 =" + dev2 + " hash code = " + dev2.hashCode());




    Map<GradeWithSalary, String> enumMap = new EnumMap<>(GradeWithSalary.class);

    enumMap.put(GradeWithSalary.DEVELOPER, " it friday...");

    enumMap.put(GradeWithSalary.DEVELOPER, " its develper...");

    enumMap.keySet().stream().peek(x -> x.setSalary(1)).collect(Collectors.toList());

    System.out.println("Dev salary is " + GradeWithSalary.DEVELOPER.getSalary());


    enumMap.put(GradeWithSalary.MANAGER, " it Sunday.. you can put any value or any type;");

    System.out.println(enumMap);


  }
}


