package com.kattyavar.shika.main.java.live_session.mar5.enumexample;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class EnumExample {

  void test() {

    Day obj = Day.MONDAY;

    Class cls = obj.getClass();

    System.out.println("Day enum class Parent Name is -> " + cls.getSuperclass().getName());
    System.out.println("Day enum class Parent Name is -> " + cls.getSuperclass().getSuperclass().getName());

    Day dayObj = Day.FRIDAY;

    for (Field filed : cls.getDeclaredFields()) {

      int modifier = filed.getModifiers();
      System.out.println("Filed name is =>" + filed.getName() + ", and type is " + Modifier.toString(modifier));
      System.out.println("here is data type " + filed.getType());

    }
  }

  public static void main(String[] args) {


    for (Day day : Day.values()) {
      System.out.println(day);
      System.out.println("Ordinal => " + day.ordinal());
    }

  }

  static Day convertStringToEnum(String input) {
    Day day = Day.valueOf(input);

    return day;
  }
}


class Base {
}

class Derived extends Base {
}

interface PersonInterface {
  long applyDiscount(long value);
}

enum Day2 {
  ON0, ON1, ON2, ON3
}


enum Day {
  FRIDAY(99) {
    @Override
    long applyDiscount(long value) {
      return 0;
    }
  }, SUNDAY(1) {
    @Override
    long applyDiscount(long value) {
      return 0;
    }
  },
  MONDAY(33) {
    @Override
    long applyDiscount(long value) {
      return 0;
    }
  };

  private int code;

  Day(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  abstract long applyDiscount(long value);
}


//public static final Day MONDAY