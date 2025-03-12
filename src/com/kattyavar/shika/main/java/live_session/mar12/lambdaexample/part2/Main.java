package com.kattyavar.shika.main.java.live_session.mar12.lambdaexample.part2;

import java.lang.annotation.*;

public class Main {

  @MyAnnotation
  String input;

  @MyAnnotation
  public static void main(String[] args) {


    TempInterface obj = () -> {};


  }
}


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@interface  MyAnnotation {
}


@FunctionalInterface
interface TempInterface {

  void youcangivaeanynamethisisnotimportant();

}

abstract class AbstractClassExample {
  abstract Integer addThisIsFunctionNamePlayAnyRole(Integer a, Integer b);
}


class TempImp extends AbstractClassExample {


  private String name;

  @Override
  Integer addThisIsFunctionNamePlayAnyRole(Integer a, Integer b) {
    return 0;
  }
}
